package com.example.foodordersystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import static com.example.foodordersystem.Accounts.AccountsManager.getSession;

public class UserProfileController {

    @FXML
    private Label addressField;

    @FXML
    private Label emailField;

    @FXML
    private Label nameField;

    @FXML
    private Label passwordField;

    @FXML
    private Label phoneField;

    @FXML
    private Label usernameField;

    @FXML
    private Button loadButton;


    @FXML
    public void handleLoad(){

        userProfile();
    }

    @FXML
    public void userProfile() {
        usernameField.setText(getSession().getUsername());
        nameField.setText(getSession().getName());
        emailField.setText(getSession().getEmail());
        passwordField.setText(getSession().getPassword());
        phoneField.setText(getSession().getPhone());
        addressField.setText(getSession().getAddress());
    }

}