package com.example.foodordersystem;


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
import java.util.List;

public class UserSignupController {

    @FXML
    private TextField addressField;

    @FXML
    private ImageView backButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameField;


//    private DataManager dataManager;

    public UserSignupController() {
        // Initialize DataManager instance
//        dataManager = new DataManager();
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
    private void handleSignUpButton() throws IOException {
        // Get the username, email, and password entered by the user
        String name = nameField.getText();
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();

//        // Check if the username or email already exists
//        User user = dataManager.findUserByUsername(username);
//        User useremail = dataManager.findUserByEmail(email);

        // Validate the input fields
        if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            // Show alert if fields are empty
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sign Up Error");
            alert.setHeaderText("Please fill the required fields");
            alert.showAndWait();
        }
        //else if (user != null) {

//            // Show alert if username already exists
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Sign Up Error");
//            alert.setHeaderText("Username already exists");
//            alert.showAndWait();
//        } else if (useremail != null) {
//            // Show alert if email is already used
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Sign Up Error");
//            alert.setHeaderText("Email already used");
//            alert.showAndWait();
//        }
        else {
            // Create new user and add to the list
            User user1 = new User(name, username, password, email, phone, address);
            AccountsManager.AddUser(user1);
            System.out.println("User created");
            System.out.println("Users after signup:");
            for (User user : AccountsManager.getUsers()) {
                System.out.println("User: " + user.getUsername());
            }
            // Optional: Show a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sign Up Success");
            alert.setHeaderText("User successfully created");
            alert.showAndWait();
        }
    }

}
