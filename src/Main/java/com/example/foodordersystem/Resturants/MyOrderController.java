package com.example.foodordersystem.Resturants;

import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.Accounts.User;
import com.example.foodordersystem.PaymentSystem.Payment;
import com.example.foodordersystem.PaymentSystem.PaymentsManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyOrderController {

    @FXML
    private VBox orderVBOX;

    @FXML
    private ScrollPane resturantScroll;


    @FXML
    public void initialize() {
        // Assuming 'payments' is a list of all payments
        ArrayList<Payment> matchingPayments = new ArrayList<>();

        User currentUser = (User) AccountsManager.getSession();
        String targetUserId = currentUser.getID();  // Assuming User has a method getUserId()

        // Loop through all payments and find matching ones
        for (Payment payment : PaymentsManager.ReturnPayments()) {
            if (payment.getUserID().equals(targetUserId)) {
                matchingPayments.add(payment); // Add payment to the list if userId matches
                break;
            }
        }

        // Now that we have matching payments, we can display them in the VBox
        displayOrders(matchingPayments);
    }


    public void displayOrders(ArrayList<Payment> matchingPayments) {
        try {

            for (Payment payment : matchingPayments) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/foodordersystem/Resturants/OrderCard.fxml"));
                Parent orderCard = fxmlLoader.load();
                OrderCardController orderCardController = fxmlLoader.getController();
                orderCardController.setorderData(payment); // Set the order data (including payment method)
                orderVBOX.getChildren().add(orderCard);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}