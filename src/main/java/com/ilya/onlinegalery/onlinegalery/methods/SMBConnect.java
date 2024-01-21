package com.ilya.onlinegalery.onlinegalery.methods;

import java.net.InetAddress;

public class SMBConnect {
    InetAddress ip_addres;
    int ip_port;
    String user, password;
    public SMBConnect(InetAddress _ip_addres, int _ip_port, String _user, String _password){
        ip_addres = _ip_addres;
        ip_port = _ip_port;
        this.user = _user;
        this.password = _password;
    }
    public void connect(){

    }
}
