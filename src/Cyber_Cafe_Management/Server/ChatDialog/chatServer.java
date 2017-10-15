package Cyber_Cafe_Management.Server.ChatDialog;

import Cyber_Cafe_Management.DatabaseClass;
import Cyber_Cafe_Management.Server.HandleSession;

public class chatServer {

    private int port = 0;

    private Thread manage;
    public String message, address;
    Object sender;
    DatabaseClass db = new DatabaseClass();

    public chatServer() {

    }

    public chatServer(Object message, Object sender, int port, String address) {
        this.message = message.toString().split("/")[1].trim();
        int UniqueID = Integer.parseInt(sender.toString().split("/")[1].trim());
        db.storeMessage(this.message, UniqueID, "solomon", "unread");
        ChatDialog.starTimer();

    }

    public void setMessage(Object message, Object sender, int sen) {
        this.message = message.toString().trim();
        //this.address = address;
        this.sender = sender;
        manageClients(sen);
    }

    private void manageClients(final int ID) {
        manage = new Thread("manageClients") {
            @Override
            public void run() {
                // manage cleints code here
                //check clients details
                // sent message to clients but have a prefix to detect a pertcular client
                HandleSession.sendMessage(ID + "/chat/" + getMessage());
            }
        };
        manage.start();

    }

    public String getMessage() {
        return message;
    }

    public int getPort() {
        return port;
    }

    static void setMessageDisplay(String message) {
        ChatDialog.messageBox.append(message + "\n");
    }

}
