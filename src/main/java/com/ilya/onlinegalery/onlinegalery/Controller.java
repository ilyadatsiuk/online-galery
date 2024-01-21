package com.ilya.onlinegalery.onlinegalery;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private ChoiceBox<String> methodType;

    @FXML
    private TextField ipAddress;

    @FXML
    private TextField ipPort;

    @FXML
    private Button goConnect;



    private static String selectedMethod;
    private static String ipAddressValue;
    private static String ipPortValue;

    // Other methods and logic

    public ChoiceBox<String> getMethodType() {
        return methodType;
    }
    public String getIpAddress() {
        return ipAddress.getText();
    }

    public String getIpPort() {
        return ipPort.getText();
    }
    public static String getSelectedMethod() {
        return selectedMethod;
    }
    public static String getIpAddressValue() {
        return ipAddressValue;
    }

    public static String getIpPortValue() {
        return ipPortValue;
    }
    @FXML
    private void handleGoConnect(ActionEvent event) {
        updateValues();
        OnlineGalery.startConnect();
    }
    public void updateValues() {
        selectedMethod = methodType.getValue();
        ipAddressValue = getIpAddress();
        ipPortValue = getIpPort();
    }
}
