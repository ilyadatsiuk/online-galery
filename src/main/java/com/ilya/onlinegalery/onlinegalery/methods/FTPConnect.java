package com.ilya.onlinegalery.onlinegalery.methods;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.net.InetAddress;

public class FTPConnect {
    InetAddress ip_address;
    int ip_port;
    String user, password;

    public FTPConnect(InetAddress _ip_address, int _ip_port, String _user, String _password) {
        this.ip_address = _ip_address;
        this.ip_port = _ip_port;
        this.user = _user;
        this.password = _password;
    }

    public void connect() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.connect(ip_address, ip_port);

            if (ftpClient.login(user, password)) {
                System.out.println("Logged in!");
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                System.out.println("Current directory: " + ftpClient.printWorkingDirectory());
                ftpClient.enterLocalPassiveMode();

                listImagesRecursive(ftpClient, "/home/");

                ftpClient.logout();
                ftpClient.disconnect();
                System.out.println("Connection closed");
            } else {
                System.out.println("Login failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listImagesRecursive(FTPClient ftpClient, String directory) throws IOException {
        FTPFile[] files = ftpClient.listFiles(directory);

        if (files != null) {
            for (FTPFile file : files) {
                String fileName = file.getName();
                if (file.isDirectory()) {
                    listImagesRecursive(ftpClient, directory + "/" + fileName);
                } else {
                    if (isImageFile(fileName)) {
                        System.out.println(directory + "/" + fileName);
                    }
                }
            }
        } else {
            System.out.println("Failed to retrieve file list");
        }
    }
    private boolean isImageFile(String fileName) {
        String[] allowedExtensions = {"jpg", "jpeg", "png", "gif", "bmp"};
        for (String extension : allowedExtensions) {
            if (fileName.toLowerCase().endsWith("." + extension)) {
                return true;
            }
        }
        return false;
    }


}
