package com.example.foodordersystem.PaymentSystem;

import java.time.LocalDate;
import java.util.Date;

//CONTAINS THE PAYMENT DATA ONLY NO FUNCTIONALITY//
public class Payment {
    //#Fields//
    private String userID;
    private String paymentMethod;
    private int transactionID; //Random [10000 - 90000] int
    private String status; //Paid || Refunded
    private final Date paymentDate = new Date();
    private final LocalDate OrderDate = LocalDate.now();
    private float subTotal;
    private float fees = 0.14f;


    //#Getters and setters//
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public int getTransactionID() {
        return transactionID;
    }
    public String getStatus() {
        return status;
    }
    public float getTotal() {
        return subTotal+(subTotal * fees);
    }
    public float getSubTotal() {
        return subTotal;
    }
    public float getFees() {
        return fees;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }
    public String getUserID() {
        return userID;
    }
    ///--------------------------------------------///
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
    public void setFees(float fees) {
        this.fees = fees;
    }

    //#Constructors chaining//
    public Payment(String userID){ //Default Values
        this.userID = userID;
        this.transactionID = (int)(Math.random()*(90000)+10000);
        this.paymentMethod = "Pay-on-Delivery";
        this.status = "Ongoing";
        this.subTotal = 0f;
        this.fees = 0.14f;
    }


    public void DisplayPaymentInfo(){
        System.out.printf(
                "Transaction ID: %d\n" +
                "Payment method: %s\n" +
                "Status: %s\n" +
                "Transaction Date: %s\n" +
                "SubTotal: $%.2f\n" +
                "Fees: %.2f%%\n" +
                "-------------\n" +
                "Total: $%.2f"
                ,transactionID,paymentMethod,status,paymentDate,subTotal,fees*100,getTotal());
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }
}
