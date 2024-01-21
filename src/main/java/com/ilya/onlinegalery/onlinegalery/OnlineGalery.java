package com.ilya.onlinegalery.onlinegalery;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OnlineGalery extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OnlineGalery.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setTitle("Online Galery");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        launch();
        Scanner _input = new Scanner(System.in);
        String _method = _input.next();
        String _ip_addres = _input.next();
        int _port = _input.nextInt();
        String _user = _input.next();
        String _password = _input.next();
        ConnectToServer connect = new ConnectToServer(_method, _ip_addres, _port, _user, _password);
    }
}