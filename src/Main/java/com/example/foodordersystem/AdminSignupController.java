package com.example.foodordersystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminSignupController {

    @FXML
    private Button ResturantSignupButton;

    @FXML
    private TextField addressField;

    @FXML
    private ImageView backToAdminButton;

    @FXML
    private TextField locationField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;


    @FXML
    private void handleBackButton() throws IOException {
        // Go back to the main screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminStart.fxml"));
        Scene startScene = new Scene(loader.load());
        Stage stage = (Stage) backToAdminButton.getScene().getWindow();
        stage.setScene(startScene);
        stage.show();
    }




}