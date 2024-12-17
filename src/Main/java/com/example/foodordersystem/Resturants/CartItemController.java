package com.example.foodordersystem.Resturants;

import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.Cart.Cart;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.Accounts.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CartItemController {

    @FXML
    private ImageView cartimgField;

    @FXML
    private Label cartitempriceField;

    @FXML
    private Label customizationField;

    @FXML
    private Label ordernameField;

    @FXML
    private Label quantityField;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    private CartItem cartItem;
    private MyCartController myCartController; // Reference to MyCartController
    User currentUser = (User) AccountsManager.getSession();
    Cart userCart = currentUser.getCart();

    public void setData(CartItem cartItem) {
        this.cartItem = cartItem;
        ordernameField.setText(cartItem.getDish().getName());
        customizationField.setText(cartItem.getCustomization());
        double price = cartItem.getDish().getPrice();
        String priceString = String.format("%.2f", price); // Format to 2 decimal places
        cartitempriceField.setText(priceString);
        String quantity = String.valueOf(cartItem.getQuantity());
        quantityField.setText("X" + quantity);

//        double totalForItem = price * cartItem.getQuantity(); // Calculate total price for this item
//        // Assuming you have a label to show the total per item
//        totalForItemField.setText(String.format("%.2f", totalForItem));

        try {
            Image image = new Image(cartItem.getDish().getImage());
            cartimgField.setImage(image);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid URL or resource not found: " + cartItem.getDish().getImage());
            // Optionally, set a default image or handle the error appropriately
        }
    }


    public void setMyCartController(MyCartController myCartController) {
        this.myCartController = myCartController;
    }

    @FXML
    public void handleaddButton() {

        System.out.println(cartItem.getQuantity());

        System.out.println(userCart.getCartItems());;

        System.out.println(currentUser.getCart().getTotalPrice());

        cartItem.setQuantity(cartItem.getQuantity() + 1);
        myCartController.refreshCart(); // Refresh the cart view
        myCartController.updatePriceFields(); // Recalculate and display the updated price
    }

    @FXML
    public void handleremoveButton() {
        int initial = cartItem.getQuantity();
        if (initial == 1) {
            User currentUser = (User) AccountsManager.getSession();
            Cart userCart = currentUser.getCart();
            userCart.removeFromCartSpecifically(cartItem); // Remove the item if quantity is 1
        } else {
            cartItem.setQuantity(cartItem.getQuantity() - 1); // Correctly decrement the quantity
            //userCart.calcPrice();
        }
        myCartController.refreshCart(); // Refresh the cart view
        myCartController.updatePriceFields(); // Recalculate and display the updated price
    }


}
