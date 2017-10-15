package Cyber_Cafe_Management.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

public class InternetTime {

    public static Date serverTime() {
        Date realdate = null;
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
            realdate = new Date(systemtime + timeInfo.getOffset());
            // Break the time down here....
        } catch (UnknownHostException ex) {
            //JOptionPane.showMessageDialog(null, "Please Connect to Internet " + ex.getMessage(), "Serve Time", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(InternetTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        return realdate;

    }
}
