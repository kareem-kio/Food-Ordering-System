package com.example.foodordersystem.Resturants;

import com.example.foodordersystem.Restaurant.Dish;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SearchedDishesController {

    @FXML
    private VBox vb1;

    @FXML
    private VBox vb2;

    // This method will be called to display the search results
    public void displaySearch(List<Dish> searchedDishes) {
        int count = 1;

        try {
            // Loop through the searched dishes and create their corresponding dish cards
            for (Dish dish : searchedDishes) {
                // Load the dish card FXML file for each dish
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/foodordersystem/Resturants/MenuItemCard.fxml"));
                Parent dishCard = fxmlLoader.load();

                // Get the controller for the dish card and set the dish data
                MenuItemCardController menuItemCardController = fxmlLoader.getController();
                menuItemCardController.setData(dish);

                // Alternate between adding the dish cards to the two VBox elements
                if (count == 1) {
                    vb1.getChildren().add(dishCard);
                    count++;
                } else {
                    vb2.getChildren().add(dishCard);
                    count--;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
