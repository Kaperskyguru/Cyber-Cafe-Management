package Cyber_Cafe_Management.Server;

import Cyber_Cafe_Management.DatabaseClass;
import static Cyber_Cafe_Management.DatabaseClass.Connection;
import Cyber_Cafe_Management.Server.ChatDialog.chatServer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class HandleSession {

    private static Timer time;
    public Socket socket;
    private Thread recieve, Timer;
    private final boolean running = false;
    private static int per = 0, noOfClient = 0;

    private Object mess, mess1;
    private int min, sec, ID, UniqueID, count = 0, counter = 0;
    private ObjectInputStream input, input1;
    private static ObjectOutputStream output;
    private Double ticketPrice;

    public HandleSession(Socket socket, int port, final int ID, int count) {
        this.socket = socket;
        this.count = count;
        UniqueID = ID;
        setupStream();
        //Notification("chat");
    }

    public HandleSession() {

    }

    public final void setupStream() {
        new Thread("setupStreams") {
            @Override
            public void run() {
                try {
                    input = new ObjectInputStream(socket.getInputStream());
                    output = new ObjectOutputStream(socket.getOutputStream());
                    recieve();
                } catch (IOException ex) {
                    Logger.getLogger(HandleSession.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.start();

    }

    public void recieve() {
        recieve = new Thread("Receive" + count) {
            @Override
            public void run() {
                int count = 0;
                try {
                    // Recieving from Clients
                    while (true) {
                        int user = (int) input.readObject();
                        String pass = (String) input.readObject();
                        Connection con = DatabaseClass.Connection();
                        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String query = "select TicketLogin,TicketPassword,  TicketPeriod, TicketId, Price from tickettable where TicketLogin = '" + user + "'and TicketPassword = '" + pass + "'"
                                + "and isActive = '" + 0 + "'";
                        ResultSet rs = st.executeQuery(query);
                        while (rs.next()) {
                            per = rs.getInt("TicketPeriod");
                            ID = rs.getInt("TicketId");
                            ticketPrice = rs.getDouble("Price");
                            count++;
                            // break;
                        }
                        // Sending data to clients
                        if (count == 1) {

                            // Proccessing Ticket
                            processTicket();
                            int UniqueID = DatabaseClass.getUniqueIDFromTem_terminal(socket.getPort());
                            DatabaseClass.updateTem_terminalStatus(UniqueID);
                            new DatabaseClass().setTerminal(socket.getLocalAddress().getHostAddress(), UniqueID, socket.getPort(), count);
                            setNoOfClient(DatabaseClass.getTerminalIDFromDB(UniqueID));
                            input1 = new ObjectInputStream(socket.getInputStream());

                            // check for successful log on
                            Object min11 = input1.readObject();
                            Object mess11 = input1.readObject();

                            // Checking Client Log off
                            if (min11.toString().startsWith("sux") && mess11.toString().startsWith("m")) {
                                int id = Integer.parseInt(min11.toString().split("/")[1].trim());
                                String me = mess11.toString().split("/")[1].trim();
                                successLogOn(id, me);
                            } else {
                                min = Integer.parseInt(min11.toString());
                                mess1 = Integer.parseInt(mess11.toString());
                            }

                            // Setting updates
                            setUpdates(socket.getPort());

                            break;
                        }
                        if (count == 0) {
                            socket.setKeepAlive(running);
                            sendMessage("false");
                            sendMessage(0);
                            sendMessage(0);
                            sendMessage(0);
                            sendMessage(0);
                            break;
                        }
                    }

                } catch (IOException | ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    //isVerify = false;
                } finally {
                    //closeDown();
                }
            }

        };

        recieve.start();

    }

    private void setUpdates(int port) {
        int count1 = 0;
        if (count1 == 0) {
            try {
                Connection con = DatabaseClass.Connection();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = st.executeQuery("select * from timertable where uniquenumber = '" + DatabaseClass.getUniqueTicketNumber(ID) + "'");
                while (rs.next()) {
                    rs.updateInt("uniquenumber", port);
                    rs.updateRow();
                    break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            getTime();
        }
    }

    private void getTime() {
        Timer = new Thread("timer" + counter) {
            @Override
            public void run() {
                time = new Timer(1000, getTime);
                time.start();
            }

        };
        Timer.start();
    }
    ActionListener getTime = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int min = 0, sec = 0;
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                mess = input.readObject();
                mess1 = input.readObject();

                //Client Chat with admin
                if (mess.toString().startsWith("chat") || mess1.toString().startsWith("sender")) {
                    String key = mess.toString().split("/")[0].trim();
                    chatServer chatServer = new chatServer(mess, mess1, socket.getPort(), socket.getLocalAddress().getHostAddress());
                    getNotification(key, DatabaseClass.getNumberOfNewMessages());

                    //Client top up ticket
                } else if (mess.toString().startsWith("topupID") && mess1.toString().startsWith("topupPass")) {
                    int id = Integer.parseInt(mess.toString().split("/")[1].trim());
                    String pass = mess1.toString().split("/")[1].trim();
                    verifyTopUp(UniqueID, id, pass);

                    // Client Log off or Exit Timer
                } else if (mess.toString().startsWith("exit") && mess1.toString().startsWith("exitby")) {
                    String exitMessage = mess.toString().split("/")[1].trim();
                    int session = Integer.parseInt(mess1.toString().split("/")[1].trim());
                    int port = Integer.parseInt(mess1.toString().split("/")[2].trim());
                    closingClient(exitMessage, session, port);

                    //Client Change Password
                } else if (mess1.toString().startsWith("chnPass")) {
                    String ticketOrUserID = mess.toString().split(",")[0];
                    String oldPass = mess.toString().split(",")[1];
                    String newPass = mess.toString().split(",")[2];
                    int uniqueID = Integer.parseInt(mess1.toString().split("/")[1].trim());
                    changePassword(ticketOrUserID, oldPass, newPass, uniqueID);

                    // Order an item
                } else if (mess.toString().startsWith("order")) {
                    String productName = mess.toString().split("/")[1];
                    int prodID = Integer.parseInt(mess.toString().split("/")[2].trim());
                    int prodQty = Integer.parseInt(mess.toString().split("/")[3].trim());
                    int uniqueID = (int) mess1;

                    // Notify Admin
                    processOrder(productName, prodID, prodQty, uniqueID);
                    getNotification("order", DatabaseClass.getNumberOfNewOrders());

                } else {
                    min = (int) mess;
                    sec = (int) mess1;
                }
                UpdateTimer(min, sec, socket.getPort());
            } catch (IOException ex) {
                time.stop();
                Timer.stop();
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HandleSession.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    };

    private void setReturnTimer(int period, int min, int sec, String ipaddress, int session, int ID) {
        try {
            Connection con = DatabaseClass.Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from timertable");

            rs.moveToInsertRow();
            rs.updateString("ipaddress", ipaddress);
            rs.updateInt("TicketID", ID);
            rs.updateInt("minutes", min);
            rs.updateInt("seconds", sec);
            rs.updateInt("uniquenumber", session);
            rs.updateInt("TimeLeft", period);
            rs.insertRow();

        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void UpdateTimer(final int min, final int sec, final int port) {
        Thread updateTimerThread = new Thread("updateTimerThread") {
            @Override
            public void run() {
                try {
                    Connection con = DatabaseClass.Connection();
                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = st.executeQuery("select * from timertable where uniquenumber = '" + port + "'");
                    while (rs.next()) {
                        rs.updateInt("minutes", min);
                        rs.updateInt("seconds", sec);
                        rs.updateInt("TimeLeft", min);
                        rs.updateRow();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        updateTimerThread.start();

    }

    public static void sendMessage(final Object message) {
        try {
            output.writeObject(message);
            output.flush();

        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void stopTime() {
        time.stop();
    }

    private void processTicket() {
        counter++;
        if (!DatabaseClass.isTicketUsed(ID)) {
            setReturnTimer(per, min, sec, socket.getLocalAddress().getHostAddress(), socket.getPort(), ID);
        }
        if (DatabaseClass.hasTicketExpired()) {
            sendMessage("Ticket Expired");
            sendMessage(0);
            sendMessage(0);
            sendMessage(0);
            sendMessage(0);
            DatabaseClass.copyTicketToUsedUpTable(ID, 4);
        }
        switch (DatabaseClass.getTimeLeft(ID)) {
            case 0:

                sendMessage("Ticket Used Up");
                sendMessage(0);
                sendMessage(0);
                sendMessage(0);
                sendMessage(0);

                DatabaseClass.copyTicketToUsedUpTable(ID, 3);
                DatabaseClass.updateTicket("Used up", ID, 1);
                break;
            case -1:

                sendMessage("true");
                sendMessage(DatabaseClass.getTimeLeft(ID));
                sendMessage(UniqueID);
                sendMessage(ticketPrice);
                sendMessage(DatabaseClass.getStoreItem());
                DatabaseClass.updateTicket("In Use", ID, 1);
                break;

            default:

                sendMessage("true");
                sendMessage(DatabaseClass.getTimeLeft(ID));
                sendMessage(UniqueID);
                sendMessage(ticketPrice);
                sendMessage(DatabaseClass.getStoreItem());

                DatabaseClass.updateTicket("In Use", ID, 1);
                break;

        }
    }

    private void verifyTopUp(int session, int user, String pass) {

        try {
            int count1 = 0;// try using a method to check the isActive TicketLogin,TicketPassword, Price, TicketPeriod, TicketId
            String query = "select * from tickettable where TicketLogin = '" + user + "'and TicketPassword = '" + pass + "'"
                    + "and isActive = '" + 0 + "'";
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(query);
            Double ticketPrice1 = null;
            while (rs.next()) {
                per = rs.getInt("TicketPeriod");
                ID = rs.getInt("TicketId");
                ticketPrice1 = rs.getDouble("Price");
                setTicketPrice(ticketPrice1);
                count1++;
            }
            if (count1 == 1) {
                if (!DatabaseClass.isTicketUsed(ID)) {
                    setReturnTimer(per, min, sec, socket.getLocalAddress().getHostAddress(), socket.getPort(), ID);
                }
                if (DatabaseClass.hasTicketExpired()) {
                    sendMessage(session + "/topup/Your Ticket Has Expire");
                    DatabaseClass.copyTicketToUsedUpTable(ID, 4);

//                } else if (DatabaseClass.isTicketUsedUp(ID)) {
//                    sendMessage(session + "/topup/Your Ticket Is Used Up");
//                    DatabaseClass.copyTicketToUsedUpTable(ID, 3);
                } else {
                    switch (DatabaseClass.getTimeLeft(ID)) {
                        case 0:
                            sendMessage(session + "/topup/Your Ticket Is Used Up");
                            DatabaseClass.copyTicketToUsedUpTable(ID, 3);
                            break;
                        case -1:
                            sendMessage(session + "/topup/" + DatabaseClass.getTimeLeft(ID) + "," + ticketPrice1);
                            DatabaseClass.updateTicket("In Use", ID, 1);
                            break;
                        default:
                            sendMessage(session + "/topup/" + DatabaseClass.getTimeLeft(ID) + "," + ticketPrice1);
                            DatabaseClass.updateTicket("In Use", ID, 1);
                            break;
                    }
                }
                if (DatabaseClass.isTicketUsedUp(ID) && !DatabaseClass.isTicketDouble(ID)) {
                    // DatabaseClass.copyTicketToUsedUpTable(ID, 3);
                }
            } else {
                socket.setKeepAlive(running);
                sendMessage(session + "/topup/false");
            }
        } catch (SQLException | SocketException ex) {
            Logger.getLogger(HandleSession.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void closingClient(String exitMessage, int session, int port) {
        //use sessionID to get port and name
        //if name and port == a particular client
        // disconnect client
        if (DatabaseClass.getSession(port) == session) {
            // get the computer name using session
            //DatabaseClass.deleteClientTerminal(session, port);
            //time.stop();
            //Dashboard.disconnect(exitMessage, DatabaseClass.getClientName(session, port));
        }

    }

    private void successLogOn(int id, String me) {
        //ok = true;
        Dashboard.t = true;
        //System.out.println(ok + "ok");
        //setOk(ok = me.equals("success"));
    }

    private void changePassword(String ticketOrUserID, String oldPass, String newPass, int session) {
        //ticketOrUserID.
        Connection con = Connection();
        Statement st;
        int coun = 0;
        try {
            String query = "select TicketPassword from tickettable where ticketPassword = '" + oldPass + "' and TicketLogin ='" + ticketOrUserID + "'";
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                rs.updateString("TicketPassword", newPass);
                coun++;
                break;
            }
            if (coun == 1) {
                sendMessage(session + "/chnPass/Password updated successfully");
            } else {
                String query1 = "select CustomersPassword from customerstable where CustomersPassword = '" + oldPass + "' and CustomersLogin ='" + ticketOrUserID + "'";
                ResultSet rs1 = st.executeQuery(query1);
                while (rs1.next()) {
                    rs1.updateString("CustomersPassword", newPass);
                    coun++;
                    break;
                }
                if (coun == 1) {
                    sendMessage(session + "/chnPass/Password updated successfully!");
                } else {
                    sendMessage(session + "/chnPass/Incorrect old password!");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(HandleSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processOrder(String productName, int prodID, int prodQty, int uniqueID) {
        try {
            int qty = 0;
            double prodAmount;
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            prodAmount = prodQty * DatabaseClass.getPricePerItem(prodID);
            ResultSet rs = st.executeQuery("SELECT * FROM ordertable");

            rs.moveToInsertRow();
            rs.updateString("Name", productName);
            rs.updateString("Terminal", getTerminalName(uniqueID));
            rs.updateInt("items", prodQty);
            rs.updateInt("Session", uniqueID);
            rs.updateDouble("Total", prodAmount);
            rs.updateInt("Status", 0);
            rs.insertRow();

        } catch (SQLException ex) {
            Logger.getLogger(HandleSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getTerminalName(int session) {
        String name = "";
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT Terminal_Name FROM terminaltable WHERE Terminal_Number = '" + session + "'");
            while (rs.next()) {
                name = rs.getString("Terminal_Name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HandleSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    public static int getNoOfClient() {
        return noOfClient++;
    }

    private void setNoOfClient(int n) {
        noOfClient += n;
    }

    public void getNotification(String key, int total) {
        Dashboard.setNotication(key, total);

    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice += ticketPrice;
    }
}
