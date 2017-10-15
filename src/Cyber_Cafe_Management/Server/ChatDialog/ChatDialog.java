package Cyber_Cafe_Management.Server.ChatDialog;

import Cyber_Cafe_Management.DatabaseClass;
import static Cyber_Cafe_Management.DatabaseClass.Connection;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ChatDialog extends javax.swing.JFrame {

    chatServer chatserver;
    DatabaseClass db;
    private String terminalAddress;
    static Thread checkDetails;
    private int terminalNumber, terminalPort;
    Vector details;
    //static Timer time;
    private ListSelectionModel selectionModel = null;

    public ChatDialog() {
        initComponents();
        db = new DatabaseClass();
        chatserver = new chatServer();
//        time = new Timer(1000, ac);
        messageBox.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if (!messageBox.getText().isEmpty()) {
                    messageBox.setText(null);
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (!messageBox.getText().isEmpty()) {
                    messageBox.setText(null);
                }

            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (!messageBox.getText().isEmpty()) {
                    messageBox.setText(null);
                }
            }
        });

        Vector<String> header = new Vector<>();
        header.add("Terminal");
        jTable1.setModel(new DefaultTableModel(db.getTerminalName(), header));

        selectionModel = jTable1.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent lse) -> {
            typeBox.setEditable(true);

            checkDetails = new Thread("Chat Thread") {

                @Override
                public void run() {
                    details = db.getTerminalDetails(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    terminalAddress = (String) details.get(0);
                    terminalPort = Integer.parseInt(details.get(1).toString());
                    terminalNumber = Integer.parseInt(details.get(2).toString());
                    System.out.println(jTable1.getSelectedColumn() + "Col");
                    startChat();
//                    time.start();

                }
            };
            // if (!checkDetails.isAlive()) {
            checkDetails.start();
            //}
        });

    }
    ActionListener ac = (ActionEvent) -> {
        startChat();
    };

    private void startChat() {

        checkDetails();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageBox = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        typeBox = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 250));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(150, 540));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Terminal", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Terminal");
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("");
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.WEST);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Demo1");

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        messageBox.setColumns(20);
        messageBox.setRows(5);
        jScrollPane2.setViewportView(messageBox);

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        typeBox.setColumns(20);
        typeBox.setRows(5);
        typeBox.setFocusCycleRoot(true);
        jScrollPane3.setViewportView(typeBox);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // get terminal name and get socket, port and unique number from there.
        // query database to get socket IPadress and port from unique number
        // get the messgae to be sent
        // send the message to the socket, port using the unique number
        chatServer.setMessageDisplay(typeBox.getText());
        String message = typeBox.getText();
        System.out.println(terminalNumber + " Unique Number");
        chatserver.setMessage(message, /*getSenderName()*/ "Admin", terminalNumber);
//        time.stop();

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextArea messageBox;
    private javax.swing.JTextArea typeBox;
    // End of variables declaration//GEN-END:variables

    private void checkDetails() {
        String message = "";
        int uniqueID = Integer.parseInt(details.get(2).toString());
        try {
            String address = "";

            Connection con = Connection();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = st.executeQuery("SELECT * FROM messagetable where UniqueID = '" + uniqueID + "'");
            while (r.next()) {
                address = r.getString("Status");
                break;
            }
            if (address.equals("unread")) {
                while (r.next()) {
                    message = r.getString("Message");
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!message.equals("")) {
            chatServer.setMessageDisplay(message);
            db.updateMessageStatus("read", uniqueID);

            synchronized (checkDetails) {
                try {
                    checkDetails.wait(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ChatDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            time.stop();
        }
//        System.err.println(time.isRunning());

    }

    private Object getSenderName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void starTimer() {
//        time.start();
    }
}
