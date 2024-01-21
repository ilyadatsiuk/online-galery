package com.ilya.onlinegalery.onlinegalery;
import com.ilya.onlinegalery.onlinegalery.methods.FTPConnect;
import com.ilya.onlinegalery.onlinegalery.methods.SMBConnect;
import com.ilya.onlinegalery.onlinegalery.methods.SSHConect;
import com.ilya.onlinegalery.onlinegalery.methods.WEBConnect;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class ConnectToServer {
    private String connect_method;
    private InetAddress ip_address;
    private int ip_port;
    private String user, password;
    public ConnectToServer(String _connect_method, String _ip_address, int _port, String _user, String _password) {
        // assignment of variables when called
        this.connect_method = _connect_method;
        try {
            this.ip_address = InetAddress.getByName(_ip_address);
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host: " + _ip_address);
            e.printStackTrace();
        }
        this.ip_port = _port;
        this.user = _user;
        this.password = _password;
    }

    private void main(){
        switch (connect_method) {
            case "ftp":
                ftp_connect(this.ip_address, this.ip_port, this.user, this.password);
            case "ssh":
                ssh_connect(this.ip_address, this.ip_port, this.user, this.password);
            case "web":
                web_connect(this.ip_address, this.ip_port);
            case "smb":
                smb_connect(this.ip_address, this.ip_port, this.user, this.password);

        }
    }


    private void ftp_connect(InetAddress _ip_address, int _ip_port, String _user, String _password){
        FTPConnect _server = new FTPConnect(_ip_address, _ip_port, _user, _password);
        _server.connect();
    }
    private void ssh_connect(InetAddress _ip_address, int _ip_port, String _user, String _password){
        SSHConect _server = new SSHConect(_ip_address, _ip_port, _user, _password);
        _server.connect();
    }
    private void web_connect(InetAddress _ip_address, int _ip_port){
        WEBConnect _server = new WEBConnect(_ip_address, _ip_port);
        _server.connect();
    }
    private void smb_connect(InetAddress _ip_address, int _ip_port, String _user, String _password){
        SMBConnect _server = new SMBConnect(_ip_address, _ip_port, _user, _password);
        _server.connect();
    }
}
