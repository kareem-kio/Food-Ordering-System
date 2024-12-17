package com.example.foodordersystem.PaymentSystem;

import java.util.ArrayList;

//FUNCTION FOR MANAGING PENDING PAYMENTS//
public class PaymentsManager {
    private static ArrayList<Payment> payments = new ArrayList<>();
    static void AddPayment(Payment p){
        payments.add(p);
    }
    public static boolean RemovePayment(Payment p){
        return payments.remove(p);
    }

    public static ArrayList<Payment> ReturnPayments(){return payments;}
}
