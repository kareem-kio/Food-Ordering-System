package com.example.foodordersystem.Resturants;

import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.Cart.Cart;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.Accounts.User;
import com.example.foodordersystem.Restaurant.Dish;
import com.example.foodordersystem.Restaurant.Restaurant;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MenuItemCardController {

    @FXML
    private Button addreviewButton;

    @FXML
    private Button addtocartButton;

    @FXML
    private Label dishdescriptionField;

    @FXML
    private Label dishnameField;

    @FXML
    private Label dishpriceField;

    @FXML
    private ImageView dishimgField;

    @FXML
    private HBox menuitemField;

    private Dish dish;
    private Restaurant restaurant;

    public void setData(Dish dish, boolean incart, Restaurant restaurant) {
        this.dish = dish;
        this.restaurant = restaurant;
        dishnameField.setText(dish.getName());
        dishpriceField.setText(String.valueOf(dish.getPrice()));
        dishdescriptionField.setText(dish.getDescription());

        try {
            Image image = new Image(dish.getImage());
            dishimgField.setImage(image);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid URL or resource not found: " + dish.getImage());
            // Optionally, set a default image or handle the error appropriately
        }

        if (incart) {
            addtocartButton.setDisable(true); // Disable the button if the item is in the cart
        } else {
            addtocartButton.setDisable(false); // Enable the button if the item is not in the cart
        }
    }

    @FXML
    public void handleaddtocartButton() {
        // Check if the session is valid and of type User
        if (AccountsManager.getSession() instanceof User) {
            User currentUser = (User) AccountsManager.getSession();

            // Get the cart from the current user
            Cart userCart = currentUser.getCart();

            // Add the current dish to the cart




//                    boolean incart = false;
//                    for (CartItem c : userCart.getCartItems()){
//                        if (c.getDish().equals(dish)){
//                            break;
//                        }
//                    }
                    userCart.addToCart(dish, 1, ""); // Add the dish if not in the cart
                    System.out.println("Dish added to cart: " + dish.getName());


        }
    }

    public void setData(Dish dish) {
        this.dish = dish;
        dishnameField.setText(dish.getName());
        dishpriceField.setText(String.valueOf(dish.getPrice()));
        dishdescriptionField.setText(dish.getDescription());
        try {
            Image image = new Image(dish.getImage());
            dishimgField.setImage(image);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid URL or resource not found: " + dish.getImage());
            // Optionally, set a default image or handle the error appropriately
        }

    }

    public Dish getDish() {
        return dish; // Provide access to the Dish object
    }
}
