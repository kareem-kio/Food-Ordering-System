package com.example.foodordersystem.PaymentSystem;
import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.User;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.Restaurant.All_Restaurants;
import com.example.foodordersystem.Restaurant.Dish;
import com.example.foodordersystem.Restaurant.Restaurant;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Objects;

public class PaymentGateway {

    //CONTAINS FUNCTIONALITY OF MAKING A PAYMENT//
    //EACH GATEWAY CONTAINS ONE PERMANENT PAYMENT CLASS AS FIELD//
    //IT CAN RETURN PAYMENT OBJECT//
    //MAIN INTERFACE//
    private String userID;
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    //#Constructor//

    //Instantiating a gateway will instantiate a PaymentSystem.Payment object instantly
    public PaymentGateway(String ID){
        payment = new Payment(ID); //Constructor values set to default (Use payment setters to change)
        this.userID = ID; //identifies the owner of this gateway (the user who instantiated it)
    }
    public void Checkout(){
        float total = 0;
        User user = AccountsManager.getUsers().stream().filter(u -> u.getID().equals(userID)).findFirst().get();
        //Cases:
        //Incorrect or Incomplete payment data

        //Insufficient balance
//        if(Account.balance < food.price){
//            System.out.println("Broke");
//            return;
//        }
        for(CartItem item: user.getCart().getCartItems()){
            System.out.println("Entered cart item: " + item.getDish().getName());
//            item.updateCartItemStock(); //Subtracts the ordered quantity from main stock for this dish
            total += (float) (item.getDish().getPrice() * item.getQuantity());
        }
        payment.setSubTotal(total); //Sets total $$ for this payment (all orders)
        Pay(); //pays all items in cart
    }
    private void Pay() {
        PaymentsManager.AddPayment(payment);
        User user = AccountsManager.getUsers().stream().filter(u -> u.getID().equals(userID)).findFirst().get();
        payment.setStatus("Paid");
        //PaymentsManager.AddPayment(payment);
        for(CartItem CI: user.getCart().getCartItems()){
            System.out.println("Checked out: " + CI.getDish().getName() + " \nPrice: " + (CI.getDish().getPrice() * CI.getQuantity()) + "| " +CI.getDish().getPrice() +
                    "\nQuantity: x" + CI.getQuantity() + "\nPayment Method: " + payment.getPaymentMethod() + "\n-----------------------");

            //helperForPay(CI);
        }

        double fees = payment.getSubTotal() * 0.14;
        double total = payment.getSubTotal() + fees;

        System.out.println("Order ID: " + payment.getTransactionID()
                + " \nSubTotal: " + payment.getSubTotal()
                + "\t| Fees: " + fees
                + "\t| Total: " + total);

        user.setBalance(user.getBalance() - payment.getTotal());
        user.getCart().getCartItems().clear();
    }
//    public void Refund(Payment p, CartItem cartItem){
//        if(PaymentsManager.RemovePayment(p)) System.out.println("Removed Successfully");
//        else System.out.println("Couldn't remove");
//        User user = AccountsManager.getUsers().stream().filter(u -> u.getID().equals(userID)).findFirst().get();
//        user.setBalance(user.getBalance() + payment.getTotal());
//        helperForRefund(user,cartItem);
//    }
//    // for creating data for dishes
//    private void helperForPay(CartItem CI){
//        //LocalDate d = CI.getDate();
//        Dish dish = CI.getDish();
//        helperForBoth(dish,payment.getOrderDate(),CI.getQuantity(),1);
//    }
//    private void helperForRefund(User user,CartItem CI){
//
//        Dish dish = user.getCart().getCartItems().stream()
//             .filter(c -> c.getDish().equals(CI.getDish()))
//                .findFirst().get().getDish();
//        //LocalDate d = CI.getDate();
//        helperForBoth(dish,payment.getOrderDate(),CI.getQuantity(),-1);
//    }
//    // RorP: -1=Refund 1=Pay any value: nothing
//    private void helperForBoth(Dish dish, LocalDate d,int q ,int RorP)
//    {
//        if(RorP != -1 && RorP != 1)
//            return;
//
//        Integer soldDaily = dish.getSoldDaily(d);
//        Integer soldMonthly = dish.getSoldMonthly(YearMonth.from(d));
//        Integer soldYearly = dish.getSoldYearly(d.getYear());
//        Integer quantity = q;
//
//        if(soldDaily == null) {
//            dish.setSoldDaily(d, (RorP * quantity));
//            Objects.requireNonNull(All_Restaurants.restaurantExists(dish.getRestaurantID())).getDay().add(payment.getOrderDate());
//        }
//        else {
//            dish.setSoldDaily(d, soldDaily + (RorP * quantity));
//            Objects.requireNonNull(All_Restaurants.restaurantExists(dish.getRestaurantID())).getDay().add(payment.getOrderDate());
//        }
//
//        if(soldMonthly == null)
//        {
//            dish.setSoldMonthly(YearMonth.from(d), RorP*quantity);
//            Objects.requireNonNull(All_Restaurants.restaurantExists(dish.getRestaurantID())).getMonths().add(YearMonth.from(payment.getOrderDate()));
//        }
//        else {
//            dish.setSoldMonthly(YearMonth.from(d), soldMonthly + (RorP * quantity));
//            Objects.requireNonNull(All_Restaurants.restaurantExists(dish.getRestaurantID())).getMonths().add(YearMonth.from(payment.getOrderDate()));
//        }
//
//        if(soldYearly == null) {
//            dish.setSoldYearly(d.getYear(), (RorP * quantity));
//            Objects.requireNonNull(All_Restaurants.restaurantExists(dish.getRestaurantID())).getYear().add(payment.getOrderDate().getYear());
//        }
//        else {
//            dish.setSoldYearly(d.getYear(), soldYearly + (RorP * quantity));
//            Objects.requireNonNull(All_Restaurants.restaurantExists(dish.getRestaurantID())).getYear().add(payment.getOrderDate().getYear());
//        }
//    }

}

