package Cyber_Cafe_Management.Server;

import java.net.InetAddress;

public class ServerClient {

    public String name;
    public InetAddress address;
    public int port;
    public int ID = 0;
    public int attempt = 0;
    public int min = 0;
	public sec = 0;

    public ServerClient() {

    }

    public ServerClient(String name, InetAddress address, int port, final int ID) {
        this.name = name;
        this.address = address;
        this.port = port;
        this.ID = ID;

    }

    public ServerClient(String name, int min, int sec) {
        this.name = name;
        this.min = min;
        this.sec = sec;

    }

    public int getID() {
        return ID;
    }

    public int getPort() {
        return port;
    }

    public String getAddress() {
        return address.getHostAddress();
    }

}
