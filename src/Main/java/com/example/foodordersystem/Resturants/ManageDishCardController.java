package com.example.foodordersystem.Resturants;

import com.example.foodordersystem.ManageDishesController;
import com.example.foodordersystem.Restaurant.All_Restaurants;
import com.example.foodordersystem.Restaurant.Dish;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ManageDishCardController {

    @FXML
    private Label dishnameField;

    @FXML
    private Label dishpriceField;

    @FXML
    private TextField newpriceField;

    @FXML
    private Button priceButton;

    @FXML
    private Button removedishButton;

    private Dish dish;
    private ManageDishesController manageDishesController;

    public void setData(Dish dish) {
        this.dish = dish;
        dishnameField.setText(dish.getName());
        dishpriceField.setText(String.format("%.2f", dish.getPrice()));
    }

    public void setManageDishesController(ManageDishesController controller) {
        this.manageDishesController = controller;
    }

    @FXML
    private void handleUpdatePrice() {
        try {
            double newPrice = Double.parseDouble(newpriceField.getText());
            dish.setPrice(newPrice);
            dishpriceField.setText(String.format("%.2f", newPrice));
            newpriceField.clear();
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format");
        }
    }

    @FXML
    private void handleRemoveDish() {
        if (dish != null) {
            manageDishesController.getCurrentRestaurant().getDishes().remove(dish);
            manageDishesController.refreshDishes();
        } else {
            System.out.println("Dish is null, cannot remove.");
        }
    }
}
