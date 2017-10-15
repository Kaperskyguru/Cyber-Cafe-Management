package Cyber_Cafe_Management.Server.CustomerPackage;

import Cyber_Cafe_Management.DatabaseClass;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CustomerClass extends JDialog {

    String p;
    DatabaseClass DB = new DatabaseClass();

    public CustomerClass(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public CustomerClass(String path) {
        ImageIcon icon = new ImageIcon(path);
        PicDisplay.setIcon(icon);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanelMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboActive = new javax.swing.JCheckBox();
        txtLogin = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtExpiryDate = new javax.swing.JTextField();
        PicDisplay = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        cboPayment = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cboRate = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCredit = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTraffic = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        chkCredit = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        txtMax = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        paneRate = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtMinutes = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        PanelPersonal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtrDescription = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtrAddress = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtrDocument = new javax.swing.JTextArea();
        panelAccess = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jCheckBox14 = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        chkGenerateUnlockingCode = new javax.swing.JCheckBox();
        chkExtendSession = new javax.swing.JCheckBox();
        chkStartSession = new javax.swing.JCheckBox();
        chkTopupCustomerAcc = new javax.swing.JCheckBox();
        chkChangeTime_MoneyValue = new javax.swing.JCheckBox();
        chkChangeAmtPaid = new javax.swing.JCheckBox();
        chkRefunds = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jCheckBox29 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cboTerminal = new javax.swing.JComboBox();
        cboSalesReport = new javax.swing.JComboBox();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(5, 5), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(5, 5), new java.awt.Dimension(0, 32767));
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new java.awt.BorderLayout(2, 2));

        jLabel1.setText(" Login");

        jLabel2.setText("Name");

        cboActive.setText("Enabled");
        cboActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboActiveActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jButton1.setText("Password...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Member");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Webcam");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 225)));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jButton2.setText("Photo...");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Expiry date");

        PicDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PicDisplay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cyber_Cafe_Management/Server/CustomerPackage/icons/Add-Male-User-icon.png"))); // NOI18N
        PicDisplay.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        PicDisplay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PicDisplay.setIconTextGap(0);

        jLabel7.setText("Payment");

        cboPayment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prepaid", "Postpaid" }));
        cboPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPaymentActionPerformed(evt);
            }
        });

        jLabel8.setText("Rates");

        cboRate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Package", "Employee", "Student", " " }));
        cboRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRateActionPerformed(evt);
            }
        });

        jLabel9.setText("Minutes");

        jLabel10.setText("0 min");

        jLabel11.setText("Balance");

        jLabel12.setText("$");

        jLabel14.setText("Traffic");

        jLabel15.setText("$");

        jLabel16.setText("Mb");

        chkCredit.setText("Credit");
        chkCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCreditActionPerformed(evt);
            }
        });

        jLabel13.setText("Max");

        jLabel17.setText("Mb");

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel18.setText("+ Minutes");

        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setText("History");
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));

        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("Select Rates");

        paneRate.setBackground(new java.awt.Color(255, 153, 153));
        paneRate.setVisible(false);

        jButton3.setText("+60 Min");
        jButton3.setOpaque(false);

        jButton7.setText("+30 Min");
        jButton7.setOpaque(false);

        jButton8.setText("+20 Min");
        jButton8.setOpaque(false);

        jButton9.setText("+10 Min");
        jButton9.setOpaque(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setText("M");

        jLabel23.setText("Minutes");

        javax.swing.GroupLayout paneRateLayout = new javax.swing.GroupLayout(paneRate);
        paneRate.setLayout(paneRateLayout);
        paneRateLayout.setHorizontalGroup(
            paneRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneRateLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(paneRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMinutes)
                    .addGroup(paneRateLayout.createSequentialGroup()
                        .addGroup(paneRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel23))
                .addGap(24, 24, 24))
            .addGroup(paneRateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneRateLayout.setVerticalGroup(
            paneRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addGroup(paneRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelMainLayout.createSequentialGroup()
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(57, 57, 57)
                                                .addComponent(txtExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                                        .addComponent(cboActive)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3)
                                                        .addGap(53, 53, 53))
                                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                                        .addGap(0, 55, Short.MAX_VALUE)
                                                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jButton1)))))
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(PicDisplay, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator5)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel14)
                                            .addComponent(chkCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cboPayment, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboRate, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                                                        .addComponent(jLabel10)
                                                        .addGap(91, 91, 91))
                                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(txtMax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                            .addComponent(txtTraffic, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtCredit, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtBalance, javax.swing.GroupLayout.Alignment.LEADING))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel16)
                                                            .addComponent(jLabel17)
                                                            .addComponent(jLabel12)
                                                            .addComponent(jLabel15))
                                                        .addGap(18, 18, 18)))
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel19)
                                        .addGap(9, 9, 9))
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(paneRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboActive)
                            .addComponent(jLabel3))
                        .addGap(6, 6, 6)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PicDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(11, 11, 11)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboRate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(chkCredit))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtTraffic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addComponent(paneRate, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addComponent(jSeparator4)))
        );

        jTabbedPane5.addTab("Main", jPanelMain);

        txtrDescription.setColumns(20);
        txtrDescription.setLineWrap(true);
        txtrDescription.setRows(5);
        txtrDescription.setToolTipText("Description");
        txtrDescription.setWrapStyleWord(true);
        txtrDescription.setPreferredSize(new java.awt.Dimension(164, 60));
        jScrollPane1.setViewportView(txtrDescription);

        jLabel21.setText("Description:");

        jLabel24.setText("Gender");

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Male");

        jRadioButton2.setText("Female");

        jLabel25.setText("Date Of Birth");

        jLabel26.setText("Email");

        jLabel27.setText("Phone");

        jLabel28.setText("Address");

        txtrAddress.setColumns(20);
        txtrAddress.setLineWrap(true);
        txtrAddress.setRows(5);
        txtrAddress.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtrAddress);

        jLabel29.setText("Document");

        txtrDocument.setColumns(20);
        txtrDocument.setLineWrap(true);
        txtrDocument.setRows(5);
        txtrDocument.setWrapStyleWord(true);
        txtrDocument.setPreferredSize(new java.awt.Dimension(164, 60));
        jScrollPane3.setViewportView(txtrDocument);

        javax.swing.GroupLayout PanelPersonalLayout = new javax.swing.GroupLayout(PanelPersonal);
        PanelPersonal.setLayout(PanelPersonalLayout);
        PanelPersonalLayout.setHorizontalGroup(
            PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPersonalLayout.createSequentialGroup()
                        .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPersonalLayout.createSequentialGroup()
                                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25))
                                .addGap(53, 53, 53)
                                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)
                                    .addGroup(PanelPersonalLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PanelPersonalLayout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel28)
                            .addGroup(PanelPersonalLayout.createSequentialGroup()
                                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29))
                                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelPersonalLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPersonalLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel26))
                        .addContainerGap(119, Short.MAX_VALUE))
                    .addGroup(PanelPersonalLayout.createSequentialGroup()
                        .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelPersonalLayout.createSequentialGroup()
                                    .addGap(117, 117, 117)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel27)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelPersonalLayout.setVerticalGroup(
            PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPersonalLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel28))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPersonalLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPersonalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane5.addTab("Personal", PanelPersonal);

        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel38.setMinimumSize(new java.awt.Dimension(290, 255));

        jLabel154.setText("Customer");

        jLabel158.setText("Ticket");

        jLabel164.setText("Service");

        jLabel165.setText("Terminal");

        jLabel166.setText("Create");

        jLabel167.setText("Edit");

        jLabel168.setText("Delete");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel164)
                            .addComponent(jLabel165))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jCheckBox8)
                                .addGap(147, 147, 147)
                                .addComponent(jCheckBox9))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(jCheckBox11)
                                .addGap(149, 149, 149)
                                .addComponent(jCheckBox13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                                .addComponent(jCheckBox12)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                                .addComponent(jCheckBox10)
                                .addGap(16, 16, 16))))
                    .addComponent(jSeparator15)
                    .addComponent(jSeparator16)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel166)
                        .addGap(136, 136, 136)
                        .addComponent(jLabel167)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel168)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(jLabel158)
                                .addGap(73, 73, 73)
                                .addComponent(jCheckBox5)
                                .addGap(147, 147, 147)
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox7))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(jLabel154)
                                .addGap(54, 54, 54)
                                .addComponent(jCheckBox2)
                                .addGap(148, 148, 148)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox4)))
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel167)
                    .addComponent(jLabel168)
                    .addComponent(jLabel166))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBox4)
                        .addComponent(jCheckBox3))
                    .addComponent(jLabel154)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jCheckBox5)
                        .addComponent(jCheckBox6)
                        .addComponent(jLabel158, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox10)
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jCheckBox8)
                        .addComponent(jCheckBox9)
                        .addComponent(jLabel164, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jCheckBox11)
                        .addComponent(jLabel165, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCheckBox14.setText("Logon");

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jCheckBox15.setText("Can Sell Tickets");

        jCheckBox16.setText("Can Sell Items");

        jCheckBox17.setText("User Access Administration");

        jCheckBox18.setText("Application");

        jCheckBox19.setText("Terminal Screenshot");

        jCheckBox20.setText("BlasterCafe Clent Management");

        chkGenerateUnlockingCode.setSelected(true);
        chkGenerateUnlockingCode.setText("Generate Unlocking Code");

        chkExtendSession.setSelected(true);
        chkExtendSession.setText("Extend Session");

        chkStartSession.setSelected(true);
        chkStartSession.setText("Start Session");

        chkTopupCustomerAcc.setSelected(true);
        chkTopupCustomerAcc.setText("Top-up Customer Account");

        chkChangeTime_MoneyValue.setSelected(true);
        chkChangeTime_MoneyValue.setText("Change Time/Money Values");

        chkChangeAmtPaid.setSelected(true);
        chkChangeAmtPaid.setText("Change Paid Amount");
        chkChangeAmtPaid.setName("chkChangeAmtPaid"); // NOI18N

        chkRefunds.setText("Refunds");

        jCheckBox28.setText("Inventory Administrator");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox15)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox17)
                    .addComponent(jCheckBox18)
                    .addComponent(jCheckBox19)
                    .addComponent(jCheckBox20)
                    .addComponent(chkGenerateUnlockingCode)
                    .addComponent(chkExtendSession)
                    .addComponent(chkStartSession)
                    .addComponent(chkTopupCustomerAcc)
                    .addComponent(chkChangeTime_MoneyValue)
                    .addComponent(chkChangeAmtPaid)
                    .addComponent(chkRefunds)
                    .addComponent(jCheckBox28))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkRefunds)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkChangeAmtPaid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkGenerateUnlockingCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkExtendSession)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkChangeTime_MoneyValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkStartSession)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkTopupCustomerAcc)
                .addGap(0, 0, 0))
        );

        jScrollPane4.setViewportView(jPanel1);

        jCheckBox29.setText("Reports");

        jLabel30.setText("Terminal");

        jLabel31.setText("Sale's reports access");

        cboTerminal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboSalesReport.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSalesReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSalesReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAccessLayout = new javax.swing.GroupLayout(panelAccess);
        panelAccess.setLayout(panelAccessLayout);
        panelAccessLayout.setHorizontalGroup(
            panelAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAccessLayout.createSequentialGroup()
                        .addGroup(panelAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelAccessLayout.createSequentialGroup()
                                .addComponent(jCheckBox14)
                                .addGap(125, 125, 125)
                                .addComponent(jCheckBox29)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelAccessLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addGap(100, 100, 100))
                    .addGroup(panelAccessLayout.createSequentialGroup()
                        .addComponent(cboTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                        .addComponent(cboSalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        panelAccessLayout.setVerticalGroup(
            panelAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox14)
                    .addComponent(jCheckBox29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(panelAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane5.addTab("Access", panelAccess);

        getContentPane().add(jTabbedPane5, java.awt.BorderLayout.CENTER);
        getContentPane().add(filler1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(filler2, java.awt.BorderLayout.WEST);

        jButton4.setText("History...");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btnOK)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void chkCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCreditActionPerformed
        if (chkCredit.isSelected()) {
            txtCredit.setEditable(true);
        } else {
            txtCredit.setEditable(false);
        }
    }//GEN-LAST:event_chkCreditActionPerformed

    private void cboRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRateActionPerformed
        if (cboRate.getSelectedIndex() == 0) {
            paneRate.setVisible(false);
        } else {
            paneRate.setVisible(true);
        }
    }//GEN-LAST:event_cboRateActionPerformed

    private void cboPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPaymentActionPerformed
        int t = 0;
        if (cboPayment.getSelectedIndex() == 0) {
            chkCredit.setEnabled(false);
            txtCredit.setEditable(false);
            //t = 0;

        } else {
            chkCredit.setEnabled(true);
            //t = 1;

            t = 0;
            //txtCredit.setEditable(true);+1`*
        }
    }//GEN-LAST:event_cboPaymentActionPerformed

    private void cboActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboActiveActionPerformed

    private void cboSalesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSalesReportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSalesReportActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JFileChooser d = new JFileChooser();
        if (d.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String img = d.getSelectedFile().getAbsolutePath();
            ImageIcon icon = new ImageIcon(img);
            PicDisplay.setIcon(ReizeImage(icon));

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String name = txtName.getText();
        String login = txtLogin.getText();
        String expiryDate = txtExpiryDate.getText();
        String payment = cboPayment.getSelectedItem().toString();
        int rate = cboRate.getSelectedIndex();
        int balance = Integer.parseInt(txtBalance.getText());
        int traffic = Integer.parseInt(txtTraffic.getText());
        int max = Integer.parseInt(txtMax.getText());
        int minute = Integer.parseInt(txtMinutes.getText());
        String DOB = txtDOB.getText();
        String document = txtrDocument.getText();
        String description = txtrDescription.getText();
        String terminal = cboTerminal.getSelectedItem().toString();
        String salesReport = cboSalesReport.getSelectedItem().toString();
        ImageIcon image = ReizeImage((ImageIcon) PicDisplay.getIcon());

        int credit;
        if (txtCredit.getText().isEmpty() || !txtCredit.isEnabled()) {
            credit = 0;
        } else {
            credit = Integer.parseInt(txtCredit.getText());
        }

        int active;
        if (cboActive.isSelected()) {
            active = 1;
        } else {
            active = 0;
        }
        String gender;
        if (jRadioButton1.isSelected()) {
            gender = jRadioButton1.getActionCommand();
        } else {
            gender = jRadioButton2.getActionCommand();
        }
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String address = txtrAddress.getText();
        DB.DBInsertCustomer(name, login, p, expiryDate, payment, rate, balance, credit, traffic, max, minute, gender, DOB, email, phone, address, document, description, active, image.getImage());
    }//GEN-LAST:event_btnOKActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PasswordField passwordField = new PasswordField(new JFrame(), false);
        passwordField.setVisible(true);
        p = passwordField.getPass();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed

        Webcam dialog = new Webcam(new JFrame(), true);
        dialog.setVisible(true);

    }//GEN-LAST:event_jLabel4MousePressed

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CustomerClass dialog = new CustomerClass(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPersonal;
    public static javax.swing.JLabel PicDisplay;
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox cboActive;
    private javax.swing.JComboBox cboPayment;
    private javax.swing.JComboBox cboRate;
    private javax.swing.JComboBox cboSalesReport;
    private javax.swing.JComboBox cboTerminal;
    private javax.swing.JCheckBox chkChangeAmtPaid;
    private javax.swing.JCheckBox chkChangeTime_MoneyValue;
    private javax.swing.JCheckBox chkCredit;
    private javax.swing.JCheckBox chkExtendSession;
    private javax.swing.JCheckBox chkGenerateUnlockingCode;
    private javax.swing.JCheckBox chkRefunds;
    private javax.swing.JCheckBox chkStartSession;
    private javax.swing.JCheckBox chkTopupCustomerAcc;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JPanel paneRate;
    private javax.swing.JPanel panelAccess;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCredit;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtExpiryDate;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtMinutes;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtTraffic;
    private javax.swing.JTextArea txtrAddress;
    private javax.swing.JTextArea txtrDescription;
    private javax.swing.JTextArea txtrDocument;
    // End of variables declaration//GEN-END:variables

    private static ImageIcon ReizeImage(ImageIcon icon1) {
        Image image = icon1.getImage();
        Image image1 = image.getScaledInstance(PicDisplay.getWidth(), PicDisplay.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image1);
        return icon;

    }

    public static void setImageIconPicture(ImageIcon icon) {
        PicDisplay.setIcon(ReizeImage(icon));
    }

}
