package com.example.foodordersystem;

import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Restaurant.All_Restaurants;
import com.example.foodordersystem.Restaurant.Dish;
import com.example.foodordersystem.Restaurant.Restaurant;
import com.example.foodordersystem.Resturants.ManageDishCardController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class ManageDishesController {

    @FXML
    private VBox cartItem2Field;

    @FXML
    private VBox dishesVbox;

    private Restaurant currentRestaurant;

    public void initialize() {
        // Locate the restaurant associated with the logged-in admin
        for (Restaurant r : All_Restaurants.getRestaurants()) {
            if (AccountsManager.getSession().getName().equals(r.getName())) {
                currentRestaurant = r;
                System.out.println("MY RESTAURANT IS: " + currentRestaurant.getName());
                System.out.println("Restaurant ID: " + currentRestaurant.getID());
                break;
            }
        }

        if (currentRestaurant != null) {
            loadDishes();
        }
    }

    private void loadDishes() {
        List<Dish> dishes = currentRestaurant.getDishes();

        // Clear the VBox to avoid duplications
        dishesVbox.getChildren().clear();

        int count = 1;
        try {
            for (Dish dish : dishes) {
                System.out.println(dish.getName());
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Admin/AdminDashBoardPages/ManageDishCard.fxml"));
                Parent dishCard = fxmlLoader.load();

                ManageDishCardController manageDishCardController = fxmlLoader.getController();
                manageDishCardController.setData(dish);
                manageDishCardController.setManageDishesController(this); // Set the controller

                if (count == 1) {
                    cartItem2Field.getChildren().add(dishCard);
                    count++;
                } else {
                    dishesVbox.getChildren().add(dishCard);
                    count--;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshDishes() {
        loadDishes();
    }

    public Restaurant getCurrentRestaurant() {
        return currentRestaurant;
    }
}
