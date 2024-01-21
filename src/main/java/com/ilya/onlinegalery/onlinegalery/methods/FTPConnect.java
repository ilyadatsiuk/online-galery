package com.ilya.onlinegalery.onlinegalery.methods;
import java.net.InetAddress;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPConnect {
    InetAddress ip_addres;
    int ip_port;
    String user, password;
    public FTPConnect(InetAddress _ip_addres, int _ip_port, String _user, String _password){
        this.ip_addres = _ip_addres;
        this.ip_port = _ip_port;
        this.user = _user;
        this.password = _password;
    }
    public void connect(){
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.connect(ip_addres, ip_port);
            if(ftpClient.login(user, password)){
                System.out.println("Logged in!");
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                System.out.println("Current directory: " + ftpClient.printWorkingDirectory());
                ftpClient.enterLocalPassiveMode();
                String[] files = ftpClient.listNames();
                if(files != null){
                    System.out.print("Files in the current directory:");
                    for (String file :   files) {
                        System.out.println(file);
                    }
                } else {
                    System.out.println("Failed to retrieve file list");
                }
                ftpClient.logout();
                ftpClient.disconnect();
                System.out.println("Connection closed");
            } else {
                System.out.println("Login failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
