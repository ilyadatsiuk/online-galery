package com.ilya.onlinegalery.onlinegalery;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class OnlineGalery extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OnlineGalery.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setTitle("Online Galery");
        stage.setScene(scene);
        Controller controller = fxmlLoader.getController();
        controller.getMethodType().getItems().addAll("ftp", "ssh", "Option 3");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public static void startConnect(){
        String selectedMethod = Controller.getSelectedMethod();
        String ipAddress = Controller.getIpAddressValue();
        String ipPort = Controller.getIpPortValue();
        int ipPortInt = (ipPort != null && !ipPort.isEmpty()) ? Integer.parseInt(ipPort) : 0;
        String _user = "YOUR-USER";
        String _password = "YOUR-PASSWORD";

        System.out.print("Method: " + selectedMethod);
        System.out.print("IP: " + ipAddress);
        System.out.print("User: " + _user);
        System.out.print("Password: " + _password);


        ConnectToServer connect = new ConnectToServer(selectedMethod, ipAddress, ipPortInt, _user, _password);
        connect.start();
    }
}