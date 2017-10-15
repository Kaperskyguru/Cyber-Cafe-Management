package Cyber_Cafe_Management;

import Cyber_Cafe_Management.Server.Dashboard;
import java.awt.Image;
import java.sql.DriverManager;
import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DatabaseClass {

    public static Connection con;
    public static Statement st;
    private static int uniqueNumber = 0;
    static Thread del;

    public DatabaseClass(boolean createTables) {
        boolean create = new CreatTables().createMultipleTable();
        if (create) {
            System.out.println("tables created");
        } else {
            try {
                System.out.println("tables Exit");
                st = con.createStatement();
                // st.execute("drop table admintable,customerstable,itemtable,tickettable");
                System.out.println("tables droped");

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public DatabaseClass() {

    }

    public static Connection Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyberblasterdb", "root", "");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void InsertTicket(int numberOfTicket, int TicketLogin, double price, String Period, int trafficMax, String dateExpired, String Terminal) {
        int counter = 1;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from tickettable");
            while (counter <= numberOfTicket) {

//                System.out.println(counter + " " + isTicketExist(rs.getInt("TicketLogin")));
                rs.moveToInsertRow();
                //if (!isTicketExist(TicketLogin)) {
                rs.updateInt("TicketLogin", AutoLoginID(numberOfTicket));
                rs.updateString("TicketPassword", PasswordGenerator(7));
                rs.updateString("TicketState", "Created");
                rs.updateString("TicketPeriod", Period);
                rs.updateDouble("Price", price);
                rs.updateInt("TrafficMax", trafficMax);
                rs.updateString("Terminal", Terminal);
                rs.updateString("dateExpired", dateExpired);
                rs.insertRow();
                //}

                counter = counter + 1;
            }
            JOptionPane.showMessageDialog(null, "Successfully Inserted");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean isTicketExist(int TicketLogin) {
        try {
            int exist = 0;
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select TicketLogin from tickettable where TicketLogin = '" + TicketLogin + "'");
            while (rs.next()) {
                exist = rs.getInt("TicketLogin");
                //break;
            }
            return exist >= 1;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public class CreatTables {

        public boolean createMultipleTable() {
            try {

                Connection con1 = Connection();
                st = con1.createStatement();

                String AdminTable = "create table IF NOT EXISTS AdminTable ("
                        + "AdminId int(8) not null auto_increment,"
                        + "AdminName varchar(25) not null,"
                        + "AdminPassword varchar(25) not null,"
                        + "AdminEmail varchar(100) not null,"
                        + "AdminContact varchar(255) not null,"
                        + "primary key (AdminId)"
                        + ")";

                st.execute(AdminTable);
                String ItemTable = "create table IF NOT EXISTS ItemTable ("
                        + "ProductId int(8) not null auto_increment,"
                        + "ProductName varchar(50) not null,"
                        + "QuantityAvailable int(25) not null,"
                        + "PricePerItem int(25) not null,"
                        + "primary key(ProductId)"
                        + ")";

                st.execute(ItemTable);
                String timerTable = "create table IF NOT EXISTS timertable ("
                        + "ID int(8) not null auto_increment,"
                        + "ipaddress varchar(50) not null,"
                        + "TicketID int(25) not null,"
                        + "minutes int(25) not null,"
                        + "seconds int(25) not null,"
                        + "dateCreated TIMESTAMP NOT NULL,"
                        + "uniquenumber int(25) not null,"
                        + "TimeLeft int(25),"
                        + "primary key(ID)"
                        + ")";

                st.execute(timerTable);

                String ticketTable = "create table IF NOT EXISTS TicketTable ("
                        + "TicketId int(8) not null auto_increment,"
                        + "TicketLogin int(25) not null,"
                        + "TicketPassword varchar(8)not null unique,"
                        + "TicketPeriod varchar(5) not null,"
                        + "TicketState text not null,"
                        + "dateCreated timestamp not null,"
                        + "TrafficMax int not null,"
                        + "Terminal text,"
                        + "dateExpired text,"
                        + "PreviousState varchar(25),"
                        + "Price decimal(18,2),"
                        + "isActive int not null DEFAULT '0',"
                        + "primary key(TicketId)"
                        + ");";
                st.execute(ticketTable);

                String CustomersTable = "create table IF NOT EXISTS CustomersTable ("
                        + "CustomersId int(8) not null auto_increment,"
                        + "CustomersName varchar(50) not null,"
                        + "CustomersLogin int not null,"
                        + "CustomersPassword varchar(25) not null,"
                        + "CustomersPaymentOttion text not null,"
                        + "CustomersNickName varchar(50) not null,"
                        + "Address text,"
                        + "Phone int(13), "
                        + "Service_Plan int(10),"
                        + "balance int(10),"
                        + "balance_min int(10),"
                        + "description text,"
                        + "user int(10),"
                        + "dob text,"
                        + "customer_type int(10),"
                        + "active varchar(1),"
                        + "ticket_value int(50),"
                        + "owner int(20),"
                        + "payment int(10),"
                        + "status int(50),"
                        + "expiry_date datetime,"
                        + "expiry_days int(10),"
                        + "min_balance varchar(1),"
                        + "promo varchar(1),"
                        + "terminal_type int(10),"
                        + "gender varchar(10),"
                        + "document text,"
                        + "traffic_balance int(50),"
                        + "traffic_max int(50),"
                        + "face_minute int(50),"
                        + "email varchar(50),"
                        + "minutes int(255),"
                        + "primary key(CustomersId)"
                        + ")";
                st.execute(CustomersTable);

                String TermainalTable = "create table IF NOT EXISTS TerminalTable("
                        + "Terminal_ID int(8) not null auto_increment,"
                        + "Terminal_Number int(255) not null,"
                        + "Terminal_Name Varchar(255),"
                        + "Terminal_IpAddress varchar(255) not null,"
                        + "Terminal_Port int (255) not null,"
                        + "primary key (Terminal_ID)"
                        + ")";
                st.execute(TermainalTable);

                String UsedTicketTable = "create table IF NOT EXISTS UsedTickettable("
                        + "ID int(8) not null auto_increment,"
                        + "Login int(255) not null,"
                        + "Date_Created varchar(225) not null,"
                        + "Date_Used Varchar(255),"
                        + "Date_Expired varchar(255) not null,"
                        + "TicketID int not null,"
                        + "primary key (ID)"
                        + ")";
                st.execute(UsedTicketTable);

                String messageTable = "create table IF NOT EXISTS messagetable("
                        + "ID int(8) not null auto_increment,"
                        + "Message text not null,"
                        + "Sender varchar(225) not null,"
                        + "UniqueID int not null,"
                        + "Port int unique not null,"
                        + "IPAddress varchar(100) not null,"
                        + "primary key (ID)"
                        + ")";
                st.execute(messageTable);

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
        }

    }
// Auto generate password algorithm.

    public String PasswordGenerator(int numberOfPassword) {
        List allAlph = new ArrayList();
        String result = "";
        String[] alph = {"a", "A", "b", "B", "c", "C", "d", "D", "e", "E", "f",
            "F", "g", "G", "h", "H", "i", "I", "j", "J", "k", "K", "l",
            "L", "n", "N", "m", "M", "o", "O", "p", "P", "l", "L", "q", "Q",
            "r", "R", "s", "S", "t", "T", "u", "U", "v", "V", "w", "W", "x",
            "X", "y", "X", "z", "Z"};
        int alphNum, numNum;
        Random r = new Random();
        int c = numberOfPassword;
        int nc = 0 - c;
        int c2 = c / 2;
        int nc2 = 0 - c2;
        int ncm = (nc + 1) / 2;
        if (c % 2 == 0) {
            for (int i = nc2; i <= 0; i++) {
                alphNum = r.nextInt(53);
                allAlph.add(alph[alphNum]);
                numNum = r.nextInt(10);
                allAlph.add(numNum);
            }
        } else {
            for (int i = ncm; i <= 0; i++) {
                alphNum = r.nextInt(53);
                allAlph.add(alph[alphNum]);
                numNum = r.nextInt(10);
                allAlph.add(numNum);
            }
        }
        Iterator it = allAlph.iterator();
        while (it.hasNext()) {
            result += it.next();
        }
        return result;
    }

    public static void main(String[] args) {
        new DatabaseClass(true);
    }

    public Vector DBdisplayTickets(String command) {
        ResultSet rs;
        Vector<Vector<String>> vect = new Vector<Vector<String>>();
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            switch (command) {
                case "(All)":
                    rs = st.executeQuery("select * from tickettable where TicketState = 'Created' or TicketState = 'Printed' or TicketState = 'Sold' or TicketState = 'In Use'");
                    break;
                case "In Use":
                    rs = st.executeQuery("select * from tickettable where TicketState = '" + command + "' AND isActive = '" + 1 + "'");
                    break;
                case "Sold":
                    rs = st.executeQuery("select * from tickettable where TicketState = 'In Use'");
                    break;
                default:
                    rs = st.executeQuery("select * from tickettable where TicketState = '" + command + "'");
                    break;
            }

            while (rs.next()) {
                Vector<String> employee = new Vector<String>();
                employee.add(rs.getString("TicketId"));
                employee.add(rs.getString("TicketState"));
                employee.add(rs.getString("TicketLogin"));
                employee.add(rs.getString("TicketPassword"));
                employee.add(rs.getString("TicketPeriod"));
                employee.add(rs.getString("Price"));
                employee.add("" + rs.getInt("TrafficMax"));
                employee.add(rs.getString("dateExpired"));
                employee.add(rs.getString("Terminal"));
                vect.add(employee);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return vect;

    }

    public int AutoLoginID(int numberOfTickets) {
        Random num = new Random();
        int id = 0;
        for (int counter = 1; counter <= numberOfTickets; counter++) {
            id = 9 + num.nextInt(90);

        }
        return id;
    }

    public void DBInsertCustomer(String name, String login, String pass, String expireDate, String payment, int rate, int balance, int credit, int traffic, int traffic_max, int min, String gender, String DOB, String email, String phone, String address, String document, String Description, int active, Image image) {
        try {

            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from Customerstable");
            rs.moveToInsertRow();
            rs.updateString("CustomersName", name);
            rs.updateString("CustomersLogin", login);
            rs.updateString("CustomersPassword", pass);
            rs.updateString("CustomersPaymentOption", payment);
            rs.updateString("CustomersNickName", name);
            rs.updateString("Address", address);
            rs.updateString("Phone", phone);
            rs.updateInt("Balance", balance);
            rs.updateString("description", Description);
            rs.updateString("dob", DOB);
            rs.updateInt("active", active);
            rs.updateInt("traffic_max", traffic_max);
            rs.updateString("email", email);
            rs.updateString("document", document);
            rs.updateInt("ticket_value", min);
            rs.updateString("gender", gender);
            rs.updateInt("Service_Plan", rate);
            rs.insertRow();
            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (SQLException e) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void setTerminal(String IpAddress, int Number, int port, int count) {
        String name;
        int i = 0;
        try {

            if (count > 2) {
                name = "Computer" + count;
            } else {
                name = "Computer" + count;
            }

            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from Terminaltable");
            rs.moveToInsertRow();
            rs.updateInt("Terminal_Number", Number);
            rs.updateString("Terminal_Name", name);
            rs.updateString("Terminal_IpAddress", IpAddress);
            rs.updateInt("Terminal_Port", port);
            rs.insertRow();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTem_terminal(String IpAddress, int Number, int port, int count) {
        String name;
        int i = 0;
        try {

            if (count > 2) {
                name = "Computer" + count;
            } else {
                name = "Computer" + count;
            }

            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from tem_terminal");
            rs.moveToInsertRow();
            rs.updateInt("number", Number);
            rs.updateString("name", name);
            rs.updateString("address", IpAddress);
            rs.updateInt("port", port);
            rs.insertRow();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getIpAddress(int port) {
        String Ipaddress = null;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select Terminal_IpAddress from Terminaltable where Terminal_Port = '" + port + "'");
            while (rs.next()) {
                Ipaddress = rs.getString("Terminal_IpAddress");

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        }
        return Ipaddress;
    }

    public static int getSession(int port) {
        int Session = 0;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select Terminal_Number from Terminaltable where Terminal_Port = '" + port + "'");
            while (rs.next()) {
                Session = rs.getInt("Terminal_Number");

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class
                    .getName()).log(Level.SEVERE, null, ex);

            return 0;
        }
        return Session;
    }

    public static int getPort(String name) {
        int Session = 0;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select Terminal_Port from Terminaltable where Terminal_Name = '" + name + "'");
            while (rs.next()) {
                Session = rs.getInt("Terminal_Port");

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class
                    .getName()).log(Level.SEVERE, null, ex);

            return 0;
        }
        return Session;
    }

    public Vector getTerminalName() {
        Vector<Vector<String>> TerminalNames = new Vector<>();
        ResultSet r;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            r = st.executeQuery("select Terminal_Name from Terminaltable");
            while (r.next()) {
                Vector<String> terminals = new Vector<String>();
                terminals.add(r.getString("Terminal_Name"));
                TerminalNames.add(terminals);
                //break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TerminalNames;
    }

    public static int getTimeLeft(int ID) {
        int timeLeft = -1;
        try {
            Connection con = Connection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select TimeLeft from timertable where TicketID = '" + ID + "'");
            if (rs.next()) {
                timeLeft = rs.getInt("TimeLeft");
            }
        } catch (SQLException ex) {

            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (timeLeft == 1) {
            return -1;
        }
        return timeLeft;
    }

    public void storeItems(String name, int quantity, double price) {

        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from itemtable");

            rs.moveToInsertRow();
            rs.updateString("ProductName", name);
            rs.updateInt("QuantityAvailable", quantity);
            rs.updateDouble("PricePerItem", price);
            rs.insertRow();

        } catch (SQLException ex) {

            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Vector getOrderItem() {
        Vector<Vector<String>> vect = new Vector<>();
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM ordertable WHERE `Status` = '" + 0 + "'");

            while (rs.next()) {
                Vector<String> order = new Vector<>();
                order.add(rs.getString("ID"));
                order.add(rs.getString("Time"));
                order.add(rs.getString("Name"));
                order.add(rs.getString("Items"));
                order.add(rs.getString("Terminal"));
                order.add(rs.getString("Terminal"));
                vect.add(order);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return vect;

    }

    public static Vector getQuickTicket() {
        String n;
        Vector<Vector<String>> vect = new Vector<>();
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from tickettable");

            while (rs.next()) {
                Vector<String> order = new Vector<>();
                order.add(rs.getString("TicketId"));
                order.add(rs.getString("TicketLogin"));
                order.add(rs.getString("Name"));
                order.add(rs.getString("TicketPeriod"));
                order.add(rs.getString("Terminal"));
                order.add(rs.getString("TrafficMax"));
                // order.add(rs.getString("Total"));
                vect.add(order);
                //break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return vect;

    }

    public static Vector getStoreItem() {
        String n;
        Vector<Vector<String>> vect = new Vector<>();
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from itemtable");

            while (rs.next()) {
                if (rs.getInt("QuantityAvailable") == 0) {
                    n = "unlim.";
                } else {
                    n = rs.getString("QuantityAvailable");
                }
                Vector<String> employee = new Vector<>();
                employee.add(rs.getString("ProductId"));
                employee.add(rs.getString("ProductName"));
                employee.add(n);
                employee.add(rs.getString("PricePerItem"));
                vect.add(employee);
                //break;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return vect;

    }

    public Vector getTerminalDetails(Object valueAt) {
        Vector<String> terminals = new Vector<String>();
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("select Terminal_IpAddress,Terminal_Port,Terminal_Number from Terminaltable where Terminal_Name = '" + valueAt + "'");
            while (r.next()) {
                terminals.add(r.getString("Terminal_IpAddress"));
                terminals.add(r.getString("Terminal_Port"));
                terminals.add(r.getString("Terminal_Number"));
                //break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return terminals;
    }

    public static boolean isTicketUsed(int Id) {
        int ticket = 0;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("select TicketID from Timertable where TicketID = '" + Id + "'");
            while (r.next()) {
                ticket = r.getInt("TicketID");
                //break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ticket >= 1;
    }

    public static int getUniqueTicketNumber(int Id) {
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("select uniquenumber from timertable where TicketID = '" + Id + "'");
            while (r.next()) {
                uniqueNumber = r.getInt("uniquenumber");
                //break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uniqueNumber;
    }

    public static void copyTicketToUsedUpTable(int Id, int i) {
        int TicketId = 0, TicketLogin = 0, TicketPeriod = 0;
        String dateExpired = null, dateCreated;

        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("select * from tickettable where TicketID = '" + Id + "'");
            while (r.next()) {
                TicketId = r.getInt("TicketId");
                TicketLogin = r.getInt("TicketLogin");
                TicketPeriod = r.getInt("TicketPeriod");
                dateExpired = r.getString("dateExpired");
                dateCreated = r.getString("dateCreated");
                //break;
            }
            setTicketExpiredDate(TicketId, TicketLogin, dateExpired);
            updateTicket("Used up", TicketId, i);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean hasTicketExpired() {
        String expireDate = null;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from UsedTickettable");
            while (rs.next()) {
                //expireDate = new Date(rs.getDate("Date_Expired", Calendar.getInstance()));
                expireDate = DateFormat.getDateInstance().format(rs.getString("Date_Expired"));
                //SimpleDateFormat d = new SimpleDateFormat();

                //break;
            }

            //  if (InternetTime.serverTime().before(Date.valueOf(expireDate))) {
            //   return true;
            // }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean isTicketUsedUp(int ID) {
        int ticketID = 0;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select count(TicketID) from timertable where TimeLeft = '" + 0 + "' AND TicketID = '" + ID + "'");
            while (rs.next()) {
                ticketID = rs.getRow();
                //break;
            }
            return ticketID >= 1;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static String getTimerDateCreated(int ID, int lo) {
        String ticketID = null;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select dateCreated from timertable where TimeLeft = '" + 0 + "' AND TicketID = '" + ID + "'");
            while (rs.next()) {
                ticketID = rs.getString("dateCreated");
                //break;
            }

            String dd = ticketID.split(" ")[0];
            String ti = ticketID.split(" ")[1];

            String y = dd.split("-")[0];
            String m = dd.split("-")[1];
            String d = dd.split("-")[2];
            ticketID = d + "/" + m + "/" + y;

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ticketID;
    }

    public static boolean isTicketDouble(int ID) {
        int ticketID = 0;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select count(Login) from UsedTickettable where Login = '" + ID + "'");
            while (rs.next()) {
                ticketID = rs.getRow();//.getInt("Login");
                //break;
            }
            return ticketID > 1;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void setTicketExpiredDate(int ticketid, int ticketLogin, String dateExpire) {
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from UsedTickettable");
            rs.moveToInsertRow();
            rs.updateInt("TicketID", ticketid);
            rs.updateInt("Login", ticketLogin);
            rs.updateString("Date_Used", getTimerDateCreated(ticketid, ticketLogin));
            rs.updateString("Date_Created", getTicketCreatedDate(ticketLogin));
            rs.updateString("Date_Expired", dateExpire);
            rs.insertRow();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getTicketCreatedDate(int Id) {
        String date = null;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("select dateCreated from Tickettable where TicketLogin = '" + Id + "'");
            while (r.next()) {
                date = r.getString("dateCreated");
                //break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    private static String getDate() {
        GregorianCalendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String date = "" + day + "/" + month + "/" + year + "";
        return date;
    }

    public static Vector getUsedUpTickets() {

        Vector<Vector<String>> UsedUpTickets = new Vector<>();
        ResultSet r;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            r = st.executeQuery("select * from UsedTickettable");
            while (r.next()) {

                // get all the :ogin etails where the Stsatus is equll to not Active
                Vector<String> tickets = new Vector<String>();
                tickets.add(r.getString("ID"));
                tickets.add(r.getString("Login"));
                tickets.add(r.getString("Date_Used"));
                tickets.add(r.getString("Date_Expired"));
                UsedUpTickets.add(tickets);
                //break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        return UsedUpTickets;
    }

    // Store the messages from clients
    public void storeMessage(String message1, int UniqueID1, String sender, String status) {
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("SELECT * FROM messagetable");
            r.moveToInsertRow();
            r.updateString("Message", message1);
            r.updateInt("UniqueID", UniqueID1);
            r.updateString("Sender", sender);
            r.updateString("Status", status);
            r.insertRow();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);

        }
        //return true;
    }

    public static void updateTicket(String command, int ID, int isActive) {
        try {
            Connection con = DatabaseClass.Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from tickettable where Ticketid = '" + ID + "'");
            while (rs.next()) {
                rs.moveToCurrentRow();
                rs.updateString("TicketState", command);
                rs.updateInt("isActive", isActive);
                rs.updateRow();
            }
        } catch (SQLException e) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    // Store the messages from clients
    public void updateMessageStatus(String newStatus, int UniqueID1) {
        try {

            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("SELECT * FROM messagetable WHERE UniqueID = '" + UniqueID1 + "'");
            while (r.next()) {
                r.moveToCurrentRow();
                r.updateString("Status", newStatus);
                r.updateRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // check if UniqueID exit in MessageTable Database
    public static boolean isIdExit(String DB, String col, int UniqueID1) {
        int exist = 0;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("SELECT COUNT(" + col + ") FROM " + DB + " WHERE " + col + " = " + UniqueID1 + "");
            while (r.next()) {
                exist = r.getRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist >= 1;
    }

    public static String getClientName(int session, int port) {
        String name = "";
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("select Terminal_Name from Terminaltable where Terminal_Number = '" + session + "' and Terminal_Port = '" + port + "'");
            while (r.next()) {
                name = r.getString("Terminal_Name");
                //break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    public static void deleteClientTerminal(final int session, final int port) {
        del = new Thread() {
            @Override
            public void run() {
                try {
                    Connection con = Connection();
                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    st.execute("delete from Terminaltable where Terminal_Number = '" + session + "' and Terminal_Port = '" + port + "'");
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
        del.start();

    }

    public static double getPricePerItem(int id) {
        double price = 0;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs1 = st.executeQuery("SELECT PricePerItem FROM itemtable WHERE ProductId = '" + id + "'");
            while (rs1.next()) {
                price = rs1.getDouble("PricePerItem");
                //break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;

    }

    public static int getNumberOfNewMessages() {
        int count = 0;
        String s;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs1 = st.executeQuery("SELECT `Status` FROM messagetable WHERE Status = 'unread'");
            //st.
            while (rs1.next()) {
                s = rs1.getString("Status");
                count++;
                //break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public static int getNumberOfNewOrders() {
        int count = 0;
        String s;
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = st.executeQuery("SELECT `Status` FROM ordertable WHERE Status = 0");
            while (rs1.next()) {
                s = rs1.getString("Status");
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public void updateOrder(int id) {
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = st.executeQuery("SELECT * FROM ordertable WHERE ID = '" + id + "'");
            while (rs1.next()) {
                rs1.moveToCurrentRow();
                rs1.updateInt("Status", 1);
                rs1.updateRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean execSQL(String sql) {
        try {
            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

        }
    }

    public static int getUniqueIDFromTem_terminal(int port) {
        int ID = 0;
        try {
            Connection con = Connection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT number FROM tem_terminal WHERE port = '" + port + "'");
            while (rs.next()) {
                ID = rs.getInt("number");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID;
    }

    public static void updateTem_terminalStatus(int UniqueID1) {
        try {

            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("SELECT * FROM tem_terminal WHERE number = '" + UniqueID1 + "'");
            while (r.next()) {
                r.moveToCurrentRow();
                r.updateInt("status", 1);
                r.updateRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getTerminalIDFromDB(int port) {
        int ids = 0;
        int count = 0;
        System.out.println(port);
        try {

            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("SELECT Terminal_ID FROM Terminaltable WHERE Terminal_Number = '" + port + "'");
            while (r.next()) {
                ids = r.getInt("Terminal_ID");
                count++;
                System.err.println(count);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

}
