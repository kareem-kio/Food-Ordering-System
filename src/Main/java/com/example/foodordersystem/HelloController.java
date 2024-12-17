package com.example.foodordersystem;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.Restaurant.Dish;
import com.example.foodordersystem.Resturants.SearchedDishesController;
import com.example.foodordersystem.SearchFiltering.SearchEngine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Label;
//package com.example.foodordersystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


import static com.example.foodordersystem.Accounts.AccountsManager.getSession;

public class HelloController {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Label historyLabel;

    @FXML
    private Label homeLabel;

    @FXML
    private Label messages;

    @FXML
    private Label nameLabel;

    @FXML
    private Label profileName;

    @FXML
    private TextField searchText;

    @FXML
    private HBox searchbutton;

    @FXML
    private Label statistics;

    @FXML
    private HBox userProfile;





//    @FXML
//    public void handleSearch() throws IOException {
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("Resturants/SearchedDishes.fxml"));
////        Parent root = loader.load();
////        UserProfileController controller = loader.getController();
////        controller.userProfile();
////        Stage profileStage = new Stage();
////        profileStage.setTitle("User Profile");
////        profileStage.setScene(new Scene(root));
////        profileStage.show();
//    }



    public ArrayList<Dish> Search(String textfield) {
        return SearchEngine.searchOnDishes(textfield);
    }



    @FXML
    public void initialize() throws IOException {
        // Set the name label only once during initialization.
        handleHomeClick();
        setNameLabel();

    }

    @FXML
    void setNameLabel() {
        nameLabel.setText("Hello, " + getSession().getName());  // Set the current user’s name
        System.out.println("ACCOUNT NAME: " + getSession().getName());
        profileName.setText(getSession().getName());
    }

    // Method to load content dynamically
    public void loadContent(String fxmlFile) throws IOException {
        // Load the new sub-screen (content) inside contentPane
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        AnchorPane pane = loader.load();
        contentPane.getChildren().setAll(pane);
        //setNameLabel();

        // Don't call setNameLabel() here, because it will reset nameLabel
        // Let the main screen's initialization set the nameLabel only once
    }


    @FXML
    private void handleHomeClick() throws IOException {
        loadContent("Resturants/Resturants.fxml");
    }

    @FXML
    private void handleHistoryClick() throws IOException {
        loadContent("S1/MyCart.fxml");

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

    @FXML
    public void handleUserProfile() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("User/UserProfile.fxml"));
            Parent root = loader.load();
            UserProfileController controller = loader.getController();
            controller.userProfile();
            Stage profileStage = new Stage();
            profileStage.setTitle("User Profile");
            profileStage.setScene(new Scene(root));
            profileStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handleSearchButton() {
        System.out.println("Search button clicked");
        String searched = searchText.getText();
        //searched = "Urban";

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resturants/SearchedDishes.fxml"));
            Parent root = loader.load();

            SearchedDishesController controller = loader.getController(); // Get the controller instance

            // Pass the search results to the controller's displaySearch method
            controller.displaySearch(Search(searched));

            Stage profileStage = new Stage();
            profileStage.setTitle("Searched Dishes");
            profileStage.setScene(new Scene(root));
            profileStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
