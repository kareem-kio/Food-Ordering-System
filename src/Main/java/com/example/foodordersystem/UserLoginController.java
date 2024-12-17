package com.example.foodordersystem;


import com.example.foodordersystem.Accounts.Account;
import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLoginController {

    @FXML
    private ImageView backButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    //private DataManager dataManager;

    @FXML
    private void initialize() {
        // Initialize DataManager instance
        //dataManager = new DataManager(); // It will already have a static list of users
    }

    @FXML
    private void handleBackButton() throws IOException {
        // Go back to the main screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserStart.fxml"));
        Scene startScene = new Scene(loader.load());
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(startScene);
        stage.show();
    }

    @FXML
    private void handleLoginButton() throws IOException {
        // Get the username and password entered by the user
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();


        User user = AccountsManager.authSearchUsers(username,password); // Implement this method or modify to suit your context
//        System.out.println(user.getName()); //can't run those if the user is null
//        System.out.println(user.getPassword());
        // Check if the username exists and if the password is correct using the Login method
        System.out.println("user exist");
        if (user != null) {
            // Login successful, load the next screen
            AccountsManager.setSession(user);
            System.out.println();
            System.out.println(AccountsManager.getSession().getName());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen1.fxml"));
            Scene dashboardScene = new Scene(loader.load());
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(dashboardScene);
            stage.show();
        } else {
            // Invalid login, show an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Username or Password");
            alert.setContentText("Please check your username and password and try again.");
            alert.showAndWait();  // This will display the alert and wait for the user to close it
        }
    }

}
