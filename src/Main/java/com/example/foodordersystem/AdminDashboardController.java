package com.example.foodordersystem;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static com.example.foodordersystem.Accounts.AccountsManager.getSession;

public class AdminDashboardController {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Label historyLabel;

    @FXML
    private Label messages;

    @FXML
    private Label nameLabel;

    @FXML
    private ImageView restaurantimageField;

    @FXML
    private Label statistics;

    // Set the current user’s name
    @FXML
    void setNameLabel() {
        nameLabel.setText("Hello, " + getSession().getName());  // Set the current user’s name
        System.out.println("ACCOUNT NAME: " + getSession().getName());
    }

    // Method to load content dynamically
    public void loadContent(String fxmlFile) throws IOException {
        // Load the new sub-screen (content) inside contentPane
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        AnchorPane pane = loader.load();
        contentPane.getChildren().setAll(pane);
    }

    @FXML
    public void initialize() throws IOException {
        // Set the name label only once during initialization.
        setNameLabel();
        //handleHistoryClick();
    }

    @FXML
    private void handleHomeClick() throws IOException {
        loadContent("Resturants/Resturants.fxml");
    }

    @FXML
    private void handleHistoryClick() throws IOException {
        loadContent("Admin/AdminDashBoardPages/S1Admin/ManageDishes.fxml");
    }

    @FXML
    private void handleMessagesClick() throws IOException {
        loadContent("S1/Orders.fxml");
    }

    @FXML
    private void handleStatisticsClick() throws IOException {
        loadContent("S1/Reviews.fxml");
    }

    @FXML
    private void handleLogout() {
        Platform.exit();
    }
}
