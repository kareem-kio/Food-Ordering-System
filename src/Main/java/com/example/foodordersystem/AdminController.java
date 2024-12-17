package com.example.foodordersystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private AnchorPane toAdmin;

    @FXML
    private Button toUser;

    @FXML
    private void handleAdminLoginButtonAction() throws IOException {
        // Load the login FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin/AdminLogin.fxml"));
        Scene loginScene = new Scene(loader.load());

        // Get the current stage (window) and set the new scene
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(loginScene);


        stage.setResizable(false); // Disable resizing

        stage.show();
    }

    @FXML
    private void handleAdminSignupButtonAction()throws IOException {
        // Load the login FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin/AdminSignup.fxml"));
        Scene loginScene = new Scene(loader.load());

        // Get the current stage (window) and set the new scene
        Stage stage = (Stage) signupButton.getScene().getWindow();
        stage.setScene(loginScene);


        stage.setResizable(false); // Disable resizing

        stage.show();
    }

    @FXML
    private void handleToUserButtonAction() throws IOException {
        // Load the login FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserStart.fxml"));
        Scene loginScene = new Scene(loader.load());

        // Get the current stage (window) and set the new scene
        Stage stage = (Stage) toUser.getScene().getWindow();
        stage.setScene(loginScene);


        stage.setResizable(false); // Disable resizing

        stage.show();
    }

}
