/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

public class Test {

    public static void main(String[] args) {
        timee();
    }

    public static void timee() {
        try {
            String TIME_SERVER = "time-a.nist.gov";
            //time.nist.gov for all servers
            NTPUDPClient timeClient = new NTPUDPClient();
            InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);
            long returnTime = timeInfo.getReturnTime();
            Date time = new Date(returnTime);
            long systemtime = System.currentTimeMillis();
            timeInfo.computeDetails();
            Date realdate = new Date(systemtime + timeInfo.getOffset());
            //System.out.println("Time from " + TIME_SERVER + ": " + time);
            System.out.println("Time from " + TIME_SERVER + ": " + realdate);
            System.out.println("" + time.getTime());
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Please Connect to Internet " + ex.getMessage(), "Serve Time", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
