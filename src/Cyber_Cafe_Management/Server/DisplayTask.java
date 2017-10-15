package Cyber_Cafe_Management.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DisplayTask {

    public static List listRunningProcesses(final String adr1) {
        String adr = "127.0.0.1";
        List<String> processes = new ArrayList<String>();
        try {
            String line;
            Process p = Runtime.getRuntime().exec("tasklist.exe  /s " + adr + " /fo \"table\" /fi \"status eq running\" ");
            try (BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                while ((line = input.readLine()) != null) {
                    processes.add(line.substring(0, line.length()));

                }
            }
        } catch (IOException err) {
            err.printStackTrace();
        }
        return processes;
    }

}
