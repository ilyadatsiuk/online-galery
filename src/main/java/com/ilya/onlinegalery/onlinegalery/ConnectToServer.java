package com.ilya.onlinegalery.onlinegalery;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class ConnectToServer {
    private String connect_method;
    private InetAddress ip_address;
    private int ip_port;
    public ConnectToServer(String _connect_method, String _ip_address, int _port) {
        // assignment of variables when called
        this.connect_method = _connect_method;
        try {
            this.ip_address = InetAddress.getByName(_ip_address);
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host: " + _ip_address);
            e.printStackTrace();
        }
        this.ip_port = _port;
    }


}
