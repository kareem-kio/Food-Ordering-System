package com.example.foodordersystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class UserController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Button toAdmin;

    @FXML
    private void handleLoginButtonAction() throws IOException {
        // Load the login FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User/UserLogin.fxml"));
        Scene loginScene = new Scene(loader.load());

        // Get the current stage (window) and set the new scene
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(loginScene);


        stage.setResizable(false); // Disable resizing

        stage.show();
    }

    @FXML
    private void handleSignupButtonAction() throws IOException {
        // Load the signup FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User/UserSignup.fxml"));
        Scene signupScene = new Scene(loader.load());

        // Get the current stage (window) and set the new scene
        Stage stage = (Stage) signupButton.getScene().getWindow();
        stage.setScene(signupScene);

        stage.setResizable(false); // Disable resizing

        stage.show();
    }

    @FXML
    private void handleToAdminButtonAction() throws IOException {
        // Load the login FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminStart.fxml"));
        Scene loginScene = new Scene(loader.load());

        // Get the current stage (window) and set the new scene
        Stage stage = (Stage) toAdmin.getScene().getWindow();
        stage.setScene(loginScene);


        stage.setResizable(false); // Disable resizing

        stage.show();
    }
}
