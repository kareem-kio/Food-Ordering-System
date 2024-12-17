package com.example.foodordersystem.Resturants;

import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.PaymentSystem.Payment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.text.SimpleDateFormat;

public class OrderCardController {

    @FXML
    private Label orderidField;

    @FXML
    private Label paymentmethodField;

    @FXML
    private Label revieweditemField;

    @FXML
    private Label statusField;

    @FXML
    private Label statusField1;

    @FXML
    private Label totalField;


    public void setorderData(Payment payment) {

        orderidField.setText(String.valueOf(payment.getTransactionID()));
        paymentmethodField.setText(payment.getPaymentMethod());
        statusField.setText(payment.getStatus());
        //statusField1.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(payment.getOrderDate()));
        totalField.setText(String.valueOf(payment.getTotal() + payment.getTotal()*0.14f));
        revieweditemField.setText("---");
    }




}