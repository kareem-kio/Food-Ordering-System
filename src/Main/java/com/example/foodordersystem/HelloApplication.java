package com.example.foodordersystem;
import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.Accounts.User;
import com.example.foodordersystem.FileManagement.FileManager;

import com.example.foodordersystem.FileManagement.FileManager;
import com.example.foodordersystem.Restaurant.Dish;
import com.example.foodordersystem.Restaurant.Restaurant;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UserStart.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.setTitle("Food Ordering System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        FileManager.readAllJSON();
        FileManager.printRestaurantData();
        launch();
        FileManager.writeAllJSON();








    }
}