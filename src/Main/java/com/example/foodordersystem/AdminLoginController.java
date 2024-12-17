package com.example.foodordersystem;

import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.Admin;
import com.example.foodordersystem.Accounts.User;
import com.example.foodordersystem.Restaurant.All_Restaurants;
import com.example.foodordersystem.Restaurant.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginController {

    @FXML
    private Button ResturantLoginButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private ImageView backToAdminButton;




    @FXML
    private void handleLoginButton() throws IOException {
        // Get the username and password entered by the user
        String username = usernameField.getText();
        String password = passwordField.getText();


        Admin admin = AccountsManager.authSearchAdmins(username,password);
        System.out.println("user exist");
        if (admin != null) {
            // Login successful, load the next screen
            AccountsManager.setSession(admin);


            Restaurant currentRestaurant ;
            for(Restaurant r : All_Restaurants.getRestaurants()){
                if(AccountsManager.getSession().getName().equals(r.getName())){
                    currentRestaurant = r;
                    System.out.println("MY RESTUURANNNT IS "+currentRestaurant.getName());
                    System.out.println(currentRestaurant.getID());
                    break;
                }
            }




            System.out.println(AccountsManager.getSession().getName());
            System.out.println();
            System.out.println(AccountsManager.getSession().getName());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin/AdminDashboard.fxml"));
            Scene dashboardScene = new Scene(loader.load());
            Stage stage = (Stage) ResturantLoginButton.getScene().getWindow();
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