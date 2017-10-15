package Cyber_Cafe_Management.Server;

import Cyber_Cafe_Management.Server.TicketPackage.Ticket;
import Cyber_Cafe_Management.DatabaseClass;
import Cyber_Cafe_Management.Server.ChatDialog.ChatDialog;
import Cyber_Cafe_Management.Server.ChatDialog.MessageBox;
import Cyber_Cafe_Management.Server.CustomerPackage.CustomerClass;
import Cyber_Cafe_Management.Server.Goods_Services_Stock.Goods_Services_Stocks;
import Cyber_Cafe_Management.Server.PrintJobs.PrintJobs;
import Cyber_Cafe_Management.Server.Sale.Sale;
import Cyber_Cafe_Management.Server.Sale.SaleTo;
import Cyber_Cafe_Management.Server.Terminals.Terminals;
import java.awt.CardLayout;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kapersky
 */
public class Dashboard extends ServerRun {

//    private int Session;
    private int count = 0;
    private JLabel Computer;
    private JPanel compPanel;
    private ServerSocket server;

    /**
     *
     */
    public Socket socket;
    private Thread run, manage;
    private boolean running = false;
    static boolean t = false;
    private String result = "";

    private String IpAddress;

    /**
     *
     */
    public static int Port;//, min, sec;
    private int GSession;

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private final List<ServerClient> clients = new ArrayList();
    private final DatabaseClass DB = new DatabaseClass();
    HandleSession task;

    private CardLayout dashboardCard;

    /**
     *
     * @throws IOException
     */
    public Dashboard() throws IOException {
        initComponents();
        jPanel7.setVisible(false);
        dashboardCard = (CardLayout) dashCardLayout.getLayout();

        SwingUtilities.invokeLater(() -> {
            Connect();
            GetComputerDetails(Computer1.getName());
            DisplayTaskManager();
            displayCurrentTask();
            displayQuickTicket();

            setNotication("notifi", DatabaseClass.getNumberOfNewMessages());
            setNotication("order", DatabaseClass.getNumberOfNewOrders());
            setNotication("chat", DatabaseClass.getNumberOfNewMessages());
        });

        jTabbedPane1.addChangeListener((ChangeEvent e) -> {
            displayOrderItem();
        });

    }

    /**
     *
     * @param text
     */
    public Dashboard(String text) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        lblNotification = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        dashCardLayout = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        btnShutdown = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jSlider1 = new javax.swing.JSlider();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        Computer1 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        Computer2 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        Computer3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblPrepaid = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTimeLeft = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        clientsCount = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        Setup = new javax.swing.JPanel();
        Reports = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        chatMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationByPlatform(true);
        setName("frame"); // NOI18N

        jPanel16.setBackground(new java.awt.Color(153, 153, 153));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.setMinimumSize(new java.awt.Dimension(1310, 50));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("SETUP");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel37MousePressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("POS");
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel38MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel38MousePressed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("TICKETS");
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel39MousePressed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("REPORTS");
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel40MousePressed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("HOME");
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel41MousePressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("REGISTER");
        jLabel42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator16.setToolTipText("");

        lblNotification.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNotification.setForeground(new java.awt.Color(255, 193, 7));
        lblNotification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/Notification.png"))); // NOI18N
        lblNotification.setText("(0)");
        lblNotification.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblOrder.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblOrder.setForeground(new java.awt.Color(255, 255, 255));
        lblOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/Shopping_Cart.png"))); // NOI18N
        lblOrder.setText("(0)");
        lblOrder.setToolTipText("");
        lblOrder.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblMessage.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(49, 106, 197));
        lblMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/Message_Filled.png"))); // NOI18N
        lblMessage.setText("(0)");
        lblMessage.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 559, Short.MAX_VALUE)
                .addComponent(lblNotification)
                .addGap(18, 18, 18)
                .addComponent(lblOrder)
                .addGap(18, 18, 18)
                .addComponent(lblMessage)
                .addGap(74, 74, 74))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator14)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(lblNotification)
                        .addComponent(lblOrder)
                        .addComponent(lblMessage))
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator13)
                    .addComponent(jSeparator15, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator16))
                .addContainerGap())
        );

        getContentPane().add(jPanel16, java.awt.BorderLayout.NORTH);

        dashCardLayout.setLayout(new java.awt.CardLayout());

        Dashboard.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(51, 102, 0));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        jButton7.setText("New...");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Top-Up...");
        jButton8.setPreferredSize(new java.awt.Dimension(61, 23));

        jButton9.setText("Sell...");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Login", "Name", "Minutes", "Balance", "Traffic", "Max"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(240, 240, 240));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setMinWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(5).setMinWidth(50);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(6).setMinWidth(50);
        }

        jLabel32.setText("ID");

        jButton14.setText("Sell Ticket");

        jCheckBox1.setText("Print");

        jLabel21.setBackground(new java.awt.Color(204, 204, 204));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Shutdown All Terminals");
        jLabel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(204, 204, 204));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Message All Terminals");
        jLabel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.setOpaque(true);
        jLabel22.setPreferredSize(new java.awt.Dimension(112, 16));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel22MousePressed(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("jLabel25");
        jLabel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.setOpaque(true);
        jLabel25.setPreferredSize(new java.awt.Dimension(112, 16));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(84, 84, 84)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel6.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel6.setPreferredSize(new java.awt.Dimension(500, 600));
        jPanel6.setLayout(new java.awt.BorderLayout(50, 50));

        jSplitPane1.setDividerLocation(-5);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setToolTipText("");
        jSplitPane1.setContinuousLayout(true);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(0, 0));
        jSplitPane1.setOneTouchExpandable(true);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.setEnabled(false);
        jPanel3.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel3.setLayout(new java.awt.CardLayout());

        jTabbedPane1.setVisible(false);
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(200, 250));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 250));

        jPanel7.setMaximumSize(new java.awt.Dimension(200, 200));
        jPanel7.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel11.setMinimumSize(new java.awt.Dimension(200, 260));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 260));

        jButton19.setText("Refresh");

        jButton20.setText("Turn On");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        btnShutdown.setText("Shutdown");
        btnShutdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShutdownActionPerformed(evt);
            }
        });

        jButton26.setText("Restart");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("Sleep");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "100", "90", "80", "70", "60", "50", "40", "30", "20", "10", "0" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(56, 60));

        jSlider1.setMajorTickSpacing(4);
        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(100);

        jCheckBox2.setText("Mute");

        jLabel3.setText("Volume");

        jLabel4.setText("%");

        jLabel5.setText("%");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShutdown)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel4)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton20)
                        .addGap(18, 18, 18)
                        .addComponent(btnShutdown)
                        .addGap(18, 18, 18)
                        .addComponent(jButton27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton26)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setVisible(false);

        jPanel7.add(jPanel11, java.awt.BorderLayout.WEST);

        jPanel12.setPreferredSize(new java.awt.Dimension(200, 63));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jButton25.setText("Terminate");

        jButton2.setText("Start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(42, 42, 42)
                .addComponent(jButton25)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25)
                    .addComponent(jButton2))
                .addGap(2, 2, 2))
        );

        jPanel12.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Image Name", "PAID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setFillsViewportHeight(true);
        jTable4.setGridColor(new java.awt.Color(240, 240, 240));
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTable4);

        jPanel12.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jPanel12.setVisible(false);

        jPanel7.add(jPanel12, java.awt.BorderLayout.EAST);

        jPanel17.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel17ComponentShown(evt);
            }
        });
        jPanel17.setLayout(new java.awt.BorderLayout());
        jPanel17.setVisible(false);

        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jPanel17.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel7.setVisible(false);

        jTabbedPane1.addTab("Terminal", jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton11.setText("Accept");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Delete");

        jButton13.setText("Refresh");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton11)
                .addGap(37, 37, 37)
                .addComponent(jButton12)
                .addGap(33, 33, 33)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addGap(2, 2, 2))
        );

        jPanel8.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Time", "Name", "Item(s)", "Terminal", "Session"
            }
        ));
        jTable3.setFillsViewportHeight(true);
        jTable3.setGridColor(new java.awt.Color(240, 240, 240));
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setHeaderValue("Time");
            jTable3.getColumnModel().getColumn(1).setHeaderValue("Name");
            jTable3.getColumnModel().getColumn(2).setHeaderValue("Item(s)");
            jTable3.getColumnModel().getColumn(3).setHeaderValue("Terminal");
            jTable3.getColumnModel().getColumn(4).setHeaderValue("Session");
        }

        jPanel8.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Order", jPanel8);

        jPanel3.add(jTabbedPane1, "card2");

        jSplitPane1.setBottomComponent(jPanel3);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel15.setMinimumSize(new java.awt.Dimension(250, 125));
        jPanel15.setPreferredSize(new java.awt.Dimension(250, 300));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 10);
        flowLayout1.setAlignOnBaseline(true);
        jPanel21.setLayout(flowLayout1);

        jPanel22.setBackground(new java.awt.Color(204, 204, 204));
        jPanel22.setPreferredSize(new java.awt.Dimension(70, 70));

        Computer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Computer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/importblack.png"))); // NOI18N
        Computer1.setText("Computer 1");
        Computer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Computer1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/importblack.png"))); // NOI18N
        Computer1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Computer1.setName("Computer1"); // NOI18N
        Computer1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Computer1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Computer1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Computer1FocusLost(evt);
            }
        });
        Computer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Computer1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Computer1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Computer1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Computer1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Computer1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        Computer1.getAccessibleContext().setAccessibleName("");

        jPanel22.requestFocusInWindow();

        jPanel21.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(204, 204, 204));
        jPanel23.setPreferredSize(new java.awt.Dimension(70, 70));

        Computer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Computer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/importblack.png"))); // NOI18N
        Computer2.setText("Computer 2");
        Computer2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Computer2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Computer2.setName("Computer2"); // NOI18N
        Computer2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Computer2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Computer2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Computer2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Computer2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        Computer2.getAccessibleContext().setAccessibleName("");

        jPanel21.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(204, 204, 204));
        jPanel24.setPreferredSize(new java.awt.Dimension(70, 70));

        Computer3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Computer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/importblack.png"))); // NOI18N
        Computer3.setText("Computer 3");
        Computer3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Computer3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Computer3.setName("Computer3"); // NOI18N
        Computer3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Computer3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Computer3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Computer3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Computer3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        Computer3.getAccessibleContext().setAccessibleName("");

        jPanel21.add(jPanel24);

        jPanel15.add(jPanel21, java.awt.BorderLayout.CENTER);

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel14.setPreferredSize(new java.awt.Dimension(53, 53));

        jButton24.setText("jButton24");

        jButton28.setText("jButton28");

        jButton29.setText("Start");

        jButton30.setText("Add Time");

        jButton31.setText("Stop");

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/user.png"))); // NOI18N
        jLabel33.setText("Users");
        jLabel33.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240)));
        jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel33.setIconTextGap(1);
        jLabel33.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel33.setOpaque(true);
        jLabel33.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/print.png"))); // NOI18N
        jLabel34.setText("Print Manager");
        jLabel34.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240)));
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel34.setOpaque(true);
        jLabel34.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/site.png"))); // NOI18N
        jLabel35.setText("Track & Block Websites");
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240)));
        jLabel35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel35.setOpaque(true);
        jLabel35.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/setting.png"))); // NOI18N
        jLabel36.setText("Settings");
        jLabel36.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240)));
        jLabel36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel36.setIconTextGap(1);
        jLabel36.setOpaque(true);
        jLabel36.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addGap(27, 27, 27)
                .addComponent(jLabel35)
                .addGap(26, 26, 26)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator11)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel15.add(jPanel14, java.awt.BorderLayout.NORTH);

        jScrollPane7.setViewportView(jPanel15);

        jSplitPane1.setTopComponent(jScrollPane7);

        jPanel6.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        jLabel29.setText("Log-outs");

        jButton10.setText("Paid");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jSeparator10.setMinimumSize(new java.awt.Dimension(285, 251));
        jSeparator10.setPreferredSize(new java.awt.Dimension(285, 251));

        jPanel18.setVisible(false);
        jPanel18.setEnabled(false);
        jPanel18.setMinimumSize(new java.awt.Dimension(285, 251));

        jLabel19.setText("0");

        jLabel20.setText("0");

        jLabel17.setText("0");

        jLabel18.setText("0");

        jLabel10.setText("Total");

        jLabel15.setText("N 0000");

        jLabel24.setText("N 0000");

        jLabel26.setText("Balance");

        lblTime.setText("233 Min : 22 Sec");

        jLabel13.setText("N 0000");

        lblPrepaid.setText("N 100000");

        jLabel2.setText("Pre-Paid");

        jLabel27.setText("N 0000");

        jLabel6.setText("Time");

        jLabel9.setText("Rounding");

        jLabel14.setText("0000");

        jLabel16.setText("0000");

        jLabel23.setText("Tax");

        jLabel28.setForeground(new java.awt.Color(255, 51, 51));
        jLabel28.setText("0");

        jLabel7.setText("Traffic");

        jLabel8.setText("Others");

        lblTimeLeft.setBackground(new java.awt.Color(0, 0, 0));
        lblTimeLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimeLeft.setText("Time Left: 0 min");
        lblTimeLeft.setToolTipText("");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel26))
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrepaid))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel24)
                                .addComponent(jLabel15))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTime, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(29, 29, 29)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel28)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTimeLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel23)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addGap(15, 15, Short.MAX_VALUE)))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel13, jLabel14, jLabel15, jLabel16, jLabel2, jLabel23, jLabel26, jLabel6, jLabel7, jLabel8, jLabel9, lblPrepaid, lblTime});

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel17, jLabel18, jLabel19, jLabel20, jLabel28});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lblPrepaid))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel28))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(lblTime)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lblTimeLeft)
                .addContainerGap())
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(3, 3, 3)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel10)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel23)
                    .addGap(1, 1, 1)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(83, Short.MAX_VALUE)))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel13, jLabel14, jLabel15, jLabel16, jLabel2, jLabel23, jLabel26, jLabel6, jLabel7, jLabel8, jLabel9, lblPrepaid, lblTime});

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel17, jLabel18, jLabel19, jLabel20, jLabel28});

        jPanel19.setMinimumSize(new java.awt.Dimension(265, 223));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane2.setPreferredSize(new java.awt.Dimension(285, 251));

        jTable2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Name"
            }
        ));
        jTable2.setFillsViewportHeight(true);
        jTable2.setGridColor(new java.awt.Color(240, 240, 240));
        jTable2.setMaximumSize(new java.awt.Dimension(214, 16));
        jTable2.setPreferredSize(new java.awt.Dimension(70, 16));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jButton10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        jPanel5.add(jPanel4, java.awt.BorderLayout.LINE_END);

        Dashboard.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel20.setPreferredSize(new java.awt.Dimension(1310, 20));

        status.setText("testing");

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Online: 0");
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        clientsCount.setText("Clients: 0");

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator19.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(status)
                .addGap(288, 288, 288)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clientsCount)
                .addGap(249, 249, 249)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addContainerGap(599, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator18)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientsCount)
                    .addComponent(jLabel30)
                    .addComponent(status)))
            .addComponent(jSeparator19)
        );

        Dashboard.add(jPanel20, java.awt.BorderLayout.SOUTH);

        dashCardLayout.add(Dashboard, "card2");

        javax.swing.GroupLayout SetupLayout = new javax.swing.GroupLayout(Setup);
        Setup.setLayout(SetupLayout);
        SetupLayout.setHorizontalGroup(
            SetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
        );
        SetupLayout.setVerticalGroup(
            SetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );

        dashCardLayout.add(Setup, "card3");

        javax.swing.GroupLayout ReportsLayout = new javax.swing.GroupLayout(Reports);
        Reports.setLayout(ReportsLayout);
        ReportsLayout.setHorizontalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
        );
        ReportsLayout.setVerticalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );

        dashCardLayout.add(Reports, "card4");

        getContentPane().add(dashCardLayout, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(51, 0, 51));
        jMenuBar1.setForeground(new java.awt.Color(255, 102, 102));
        jMenuBar1.setBorderPainted(false);

        jMenu1.setText("SETUP");
        jMenu1.setMargin(new java.awt.Insets(3, 3, 3, 3));

        jMenuItem4.setText("Terminals");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("Tickets");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Goods.Services.Stocks");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        jMenuItem5.setText("Exit");
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("VIEW");
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu2.setMargin(new java.awt.Insets(3, 3, 3, 3));

        jMenuItem10.setText("Sales");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setText("Sessions");
        jMenu2.add(jMenuItem11);

        jMenuItem12.setText("Print Jobs");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("URL Log");
        jMenu2.add(jMenuItem13);

        jMenuItem14.setText("CD-Key reservations");
        jMenu2.add(jMenuItem14);

        jMenuItem15.setText("Inventory History");
        jMenu2.add(jMenuItem15);
        jMenu2.add(jSeparator4);

        jMenuItem16.setText("Daily Report");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("TASKS");
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setMargin(new java.awt.Insets(3, 3, 3, 3));

        jMenuItem1.setText("Message...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        chatMenu.setText("Chat...");
        chatMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chatMenuMousePressed(evt);
            }
        });
        chatMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatMenuActionPerformed(evt);
            }
        });
        jMenu3.add(chatMenu);
        jMenu3.add(jSeparator2);

        jMenuItem6.setText("Pause all Sessions");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Resume all Sessions");
        jMenu3.add(jMenuItem7);
        jMenu3.add(jSeparator3);

        jMenuItem8.setText("Shutdown Idle Terminals");
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Shutdown All Terminals");
        jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem9MousePressed(evt);
            }
        });
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("TOOLS");
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu4.setMargin(new java.awt.Insets(3, 3, 3, 3));
        jMenuBar1.add(jMenu4);

        jMenu5.setText("HELP");
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setMargin(new java.awt.Insets(3, 3, 3, 3));
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1326, 790));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel39MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MousePressed
        new Ticket().setVisible(true);
    }//GEN-LAST:event_jLabel39MousePressed

    private void chatMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatMenuActionPerformed
        new ChatDialog().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_chatMenuActionPerformed

    private void chatMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatMenuMousePressed
        //new ChatDialog().setVisible(true);
    }//GEN-LAST:event_chatMenuMousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        new Goods_Services_Stocks().setVisible(true);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Ticket().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new Terminals(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new MessageBox().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Sale sale = new Sale();
        sale.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new PrintJobs().setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jLabel41MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MousePressed
        dashboardCard.addLayoutComponent(Dashboard, "dashboard");
        dashboardCard.show(dashCardLayout, "dashboard");

    }//GEN-LAST:event_jLabel41MousePressed

    private void jLabel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MousePressed
        dashboardCard.addLayoutComponent(Setup, "setup");
        dashboardCard.show(dashCardLayout, "setup");
    }//GEN-LAST:event_jLabel37MousePressed

    private void jLabel40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MousePressed
        dashboardCard.addLayoutComponent(Reports, "Reports");
        dashboardCard.show(dashCardLayout, "Reports");
    }//GEN-LAST:event_jLabel40MousePressed

    private void jLabel38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MousePressed
        new SaleTo(this, true).setVisible(true);
    }//GEN-LAST:event_jLabel38MousePressed

    private void jLabel38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseEntered

    }//GEN-LAST:event_jLabel38MouseEntered

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String id = String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 0));
        int convertedNum = Integer.parseInt(id);
        DB.updateOrder(convertedNum);
        displayOrderItem();
        setNotication("order", DatabaseClass.getNumberOfNewOrders());

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jPanel17ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel17ComponentShown

    }//GEN-LAST:event_jPanel17ComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        DisplayShutdownOptions(GSession, "sleep");
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        DisplayShutdownOptions(GSession, "restart");
    }//GEN-LAST:event_jButton26ActionPerformed

    private void btnShutdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShutdownActionPerformed
        DisplayShutdownOptions(GSession, "shutdown");
    }//GEN-LAST:event_btnShutdownActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        DisplayShutdownOptions(GSession, "turnoff");
    }//GEN-LAST:event_jButton20ActionPerformed

    private void Computer3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Computer3MousePressed
        GetComputerDetails(Computer3.getName());
        DisplayCurrentTimer(socket.getLocalAddress().getHostAddress(), Port);
        DisplayTaskManager();
        DisplayCurrentStatus();
    }//GEN-LAST:event_Computer3MousePressed

    private void Computer2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Computer2MousePressed
        GetComputerDetails(Computer2.getName());
        DisplayCurrentTimer(socket.getLocalAddress().getHostAddress(), Port);
        DisplayTaskManager();
        DisplayCurrentStatus();
    }//GEN-LAST:event_Computer2MousePressed

    private void Computer1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Computer1MousePressed
        GetComputerDetails(Computer1.getName());
        DisplayCurrentTimer(socket.getLocalAddress().getHostAddress(), Port);
        DisplayTaskManager();
        DisplayCurrentStatus();
    }//GEN-LAST:event_Computer1MousePressed

    private void Computer1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Computer1MouseExited
        Computer1.setOpaque(false);
    }//GEN-LAST:event_Computer1MouseExited

    private void Computer1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Computer1MouseEntered
        Computer1.setOpaque(true);
    }//GEN-LAST:event_Computer1MouseEntered

    private void Computer1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Computer1FocusLost
        System.out.println("Focus Lost");
    }//GEN-LAST:event_Computer1FocusLost

    private void Computer1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Computer1FocusGained
        System.err.println("Focus gain");
    }//GEN-LAST:event_Computer1FocusGained

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new SaleTo(this, true).setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new CustomerClass(this, false).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MousePressed
        HandleSession.sendMessage(9080 + "/shut/" + "shutdown_all");
    }//GEN-LAST:event_jMenuItem9MousePressed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jLabel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MousePressed
        //new 
    }//GEN-LAST:event_jLabel22MousePressed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Computer1;
    public javax.swing.JLabel Computer2;
    public javax.swing.JLabel Computer3;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Reports;
    private javax.swing.JPanel Setup;
    private javax.swing.JButton btnShutdown;
    private javax.swing.JMenuItem chatMenu;
    private javax.swing.JLabel clientsCount;
    private javax.swing.JPanel dashCardLayout;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanel11;
    private static javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    public javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private static javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private static javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private static javax.swing.JLabel lblMessage;
    private static javax.swing.JLabel lblNotification;
    private static javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblPrepaid;
    private javax.swing.JLabel lblTime;
    private static javax.swing.JLabel lblTimeLeft;
    public javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void Connect() {
        run = new Thread("Connect") {
            @Override
            public void run() {
                running = true;
                try {
                    server = new ServerSocket(9080);
                    waitingForConnection();
                } catch (IOException ex) {
                    Logger.getLogger(Dashboard.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        run.start();
    }

    public void waitingForConnection() throws IOException {

        status.setText("Waiting for Connections");
        manage = new Thread("manage" + count) {
            @Override
            public void run() {
                while (running) {

                    try {
                        socket = server.accept();
                        count++;

                        DB.setTem_terminal(socket.getLocalAddress().getHostAddress(), UniqueSessionNumber.getUniqueIDs(), socket.getPort(), count);

                        int uniqueID = getUniqueIDFromTem_Terminal(socket.getPort());

                        task = new HandleSession(socket, socket.getPort(), uniqueID, count);

                        status.setText(socket.getLocalAddress().getHostAddress() + " Connected ");
                        clientsCount.setText("Clients: " + count);

                        int Terminals = HandleSession.getNoOfClient();
                        System.out.println(Terminals + " Terminal");
                        
                        if (Terminals == 1) {
                            Computer1.setIcon(new ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/imagesSac.png")));
                            Computer1.setText(socket.getRemoteSocketAddress().toString());
                        } else if (Terminals == 2) {
                            Computer2.setIcon(new ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/imagesSac.png")));
                            Computer2.setText(socket.getRemoteSocketAddress().toString());
                        } else if (Terminals == 3) {
                            Computer3.setIcon(new ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/imagesSac.png")));
                            Computer3.setText(socket.getRemoteSocketAddress().toString());
                        } else if (Terminals > 3) {
                            AddMore(socket.getRemoteSocketAddress().toString(), "Computer" + Terminals);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        };
        manage.start();

    }

    private void AddMore(String hostAddress, String string) {
        //Generated Panel Properties
        compPanel = new JPanel();
        compPanel.setUI(jPanel22.getUI());
        compPanel.setMinimumSize(jPanel22.getMaximumSize());
        compPanel.setMaximumSize(jPanel22.getMinimumSize());
        compPanel.setPreferredSize(jPanel22.getPreferredSize());
        compPanel.setSize(jPanel22.getSize());
        compPanel.setBackground(jPanel22.getBackground());

        // generated Label Properties
        Computer = new JLabel();
        Computer.setUI(Computer1.getUI());
        Computer.setName(string);
        Computer.setHorizontalTextPosition(SwingConstants.CENTER);
        Computer.setVerticalTextPosition(SwingConstants.BOTTOM);
        Computer.setText(hostAddress);
        Computer.setIcon(new ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Icons/imagesSac.png")));
        Computer.setIconTextGap(Computer1.getIconTextGap());
        Computer.setMinimumSize(Computer1.getMaximumSize());
        Computer.setMaximumSize(Computer1.getMinimumSize());
        Computer.setPreferredSize(Computer1.getPreferredSize());
        Computer.setSize(Computer1.getSize());
        Computer.setHorizontalAlignment(Computer1.getHorizontalAlignment());
        Computer.setVerticalAlignment(Computer1.getVerticalAlignment());

        // adding panel and Label to frame
        compPanel.add(Computer);
        jPanel21.add(compPanel);
        Computer.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                GetComputerDetails(Computer.getName());
                DisplayCurrentTimer(socket.getLocalAddress().getHostAddress(), Port);
                DisplayTaskManager();
                DisplayCurrentStatus();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Computer.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Computer.setOpaque(false);
            }

        });
    }

    private synchronized void closeDown() {
        try {
            output.close();
            input.close();

        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList getHeader() {
        ArrayList<String> header = new ArrayList();
        header.add("Image Name");
        header.add("PID");
        return header;
    }

    /**
     *
     */
    public void displayCurrentTask() {
        List data = DisplayTask.listRunningProcesses(IpAddress);
        Iterator<String> it = data.iterator();
        int i = 0;
        while (it.hasNext()) {
            result += it.next() + "\n";
            i++;
        }
        jTextArea1.setText(result);
    }

    /**
     *
     * @param name
     */
    public void GetComputerDetails(String name) {
        jPanel7.setVisible(true);
        jPanel18.setVisible(true);
        jPanel11.setVisible(true);
        jPanel12.setVisible(true);
        Port = DatabaseClass.getPort(name);
        IpAddress = DB.getIpAddress(Port);
        GSession = DatabaseClass.getSession(Port);

    }

    /**
     *
     * @param ID
     * @param cmd
     */
    public void DisplayShutdownOptions(int ID, String cmd) {
        //if shutdown send ID + shutdown
        HandleSession.sendMessage(ID + "/shut/" + cmd);

    }

    /**
     *
     */
    public void DisplayTaskManager() {
        jPanel12.setVisible(true);
    }

    /**
     *
     */
    public void DisplayCurrentStatus() {
        jPanel17.setVisible(true);
    }

    public void disconnect(String message, String clientName) {
        //  clientName
        jPanel7.setVisible(false);
        jPanel18.setVisible(false);
        jPanel11.setVisible(false);
        jPanel12.setVisible(false);

    }

    /**
     *
     * @param ipaddress
     * @param port
     */
    public void DisplayCurrentTimer(final String ipaddress, final int port) {
        int ticketID;
        try {
            Connection con = DatabaseClass.Connection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select TimeLeft, TicketID, minutes, seconds from timertable where ipaddress = '" + ipaddress + "' and uniquenumber = '" + port + "'");
            while (rs.next()) {
                lblTime.setText(rs.getInt("minutes") + " : " + rs.getInt("seconds"));
                lblTimeLeft.setText("Time Left : " + rs.getInt("TimeLeft") + " min");
                //min = rs.getInt("minutes");
                //sec = rs.getInt("seconds");
                ticketID = rs.getInt("TicketID");
                lblPrepaid.setText(task.getTicketPrice() + "");
            }
        } catch (SQLException ex) {

            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int getUniqueIDFromTem_Terminal(int port) {
        int ID = 0;
        try {
            Connection con = DatabaseClass.Connection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT number FROM tem_terminal WHERE port = '" + port + "'");
            while (rs.next()) {
                ID = rs.getInt("number");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID;
    }

    private void displayOrderItem() {
        Vector<String> header = new Vector<>();
        header.add("ID");
        header.add("Time");
        header.add("Name");
        header.add("Item(s)");
        header.add("Terminal");
        header.add("Session");
        jTable3.setModel(new DefaultTableModel(DatabaseClass.getOrderItem(), header));
    }

    private void displayQuickTicket() {
        Vector<String> header = new Vector<>();
        header.add("ID");
        header.add("Login");
        header.add("Name");
        header.add("Minutes");
        header.add("Balance");
        header.add("Traffic");
        header.add("Max");
        jTable1.setModel(new DefaultTableModel(DatabaseClass.getQuickTicket(), header));
    }

    static void setNotication(String type, int num) {
        if (type.startsWith("notif")) {
            lblNotification.setText("(" + num + ")");
        } else if (type.startsWith("order")) {
            lblOrder.setText("(" + num + ")");
        } else if (type.startsWith("chat")) {
            lblMessage.setText("(" + num + ")");
        }
    }
}
