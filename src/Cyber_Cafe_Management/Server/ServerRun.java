package Cyber_Cafe_Management.Server;

import Cyber_Cafe_Management.DatabaseClass;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.opencv.core.Core;

public class ServerRun extends JFrame {

    public ServerRun() {

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Connection con = DatabaseClass.Connection();
                    Statement st = con.createStatement();
                    st.executeUpdate("truncate table terminaltable");

                } catch (SQLException ex) {
                    Logger.getLogger(ServerRun.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

    }

    public static void main(String args[]) {

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {

                    Dashboard d = new Dashboard();
                    d.setVisible(true);
                    CreateTerminalTable();
                    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                } catch (Exception ex) {
                    Logger.getLogger(ServerRun.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    protected static void CreateTerminalTable() {
        try {
            Connection con1 = DatabaseClass.Connection();
            Statement st = con1.createStatement();
            String create = " CREATE TABLE terminaltable ("
                    + "Terminal_ID int(11) PRIMARY KEY AUTO_INCREMENT,"
                    + "Terminal_Name varchar(30),"
                    + "Terminal_Number int(255) UNIQUE,"
                    + "Terminal_IpAddress varchar(30),"
                    + "Terminal_Port int(30)"
                    + ");";
            //  st.execute(create);
        } catch (SQLException ex) {
            Logger.getLogger(ServerRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
