package com.example.foodordersystem.Resturants;

import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.Cart.Cart;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.Accounts.User;
import com.example.foodordersystem.PaymentSystem.Payment;
import com.example.foodordersystem.PaymentSystem.PaymentGateway;
import com.example.foodordersystem.PaymentSystem.PaymentsManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MyCartController {

    @FXML
    private VBox cartVbox;

    @FXML
    private Label feesField;

    @FXML
    private Label subtotalField;

    @FXML
    private Label totalField;

    @FXML
    private Button checkoutButton;

    @FXML
    private ComboBox<String> payMethod;


    @FXML
    public void handlecheckoutButton() {
        // Get the current user and their cart
        User currentUser = (User) AccountsManager.getSession();
        Cart userCart = currentUser.getCart();

        // Retrieve the selected payment method from the ComboBox
        String selectedPaymentMethod = payMethod.getSelectionModel().getSelectedItem();

        // Set the selected payment method to the Payment object
        currentUser.PG.getPayment().setPaymentMethod(selectedPaymentMethod);

        // Process the checkout and clear the cart
        currentUser.checkOut();
        userCart.getCartItems().clear();

        // Refresh the cart UI
        refreshCart();
    }



    public void initialize() {
        refreshCart();
        payMethod.getItems().addAll(
                "Credit Card",
                "PayPal",
                "Cash on Delivery",
                "Bank Transfer"
        );



        // Optionally, you can set a default selection
        payMethod.getSelectionModel().selectFirst();

    }

    public void refreshCart() {
        User currentUser = (User) AccountsManager.getSession();
        Cart userCart = currentUser.getCart();


        cartVbox.getChildren().clear(); // Clear the current items

        try {
            for (CartItem item : userCart.getCartItems()) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/foodordersystem/Resturants/CartItemCard.fxml"));
                Parent dishCard = fxmlLoader.load();

                CartItemController menuItemCardController = fxmlLoader.getController();
                menuItemCardController.setData(item);
                menuItemCardController.setMyCartController(this); // Pass the MyCartController to the CartItemController
                cartVbox.getChildren().add(dishCard);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        updatePriceFields();
    }

    public void updatePriceFields() {
        User currentUser = (User) AccountsManager.getSession();
        Cart userCart = currentUser.getCart();




        double sub = currentUser.getCart().getTotalPrice();
        System.out.println(sub);
        // Get the subtotal
        String Sub = String.format("%.2f", sub);
        subtotalField.setText(Sub + "$");

        double fees = sub * 0.14; // Calculate 14% fees
        String Fees = String.format("%.2f", fees);
        feesField.setText(Fees + "$");

        double total = sub + fees; // Calculate total (subtotal + fees)
        String Total = String.format("%.2f", total);
        totalField.setText(Total + "$");
    }



}
