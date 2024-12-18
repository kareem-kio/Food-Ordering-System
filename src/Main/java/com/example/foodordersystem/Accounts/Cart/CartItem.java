package com.example.foodordersystem.Accounts.Cart;
import com.example.foodordersystem.Restaurant.Dish;
public class CartItem {
    private int quantity; //amount specified by user to order
    private String customization;
    // a wrapper for dish
    private Dish dish;
    // Constructor for CartItem
//    public CartItem(String name,int stock ,float price,int quantity, String customization) {
         // dish = new Dish()
//        this.quantity = quantity;
//        if (customization.isEmpty())                    // Customizations are optional so if there is no customization
//            this.customization = "None";               // it will be written as "None"
//        else
//            this.customization = customization;
//    }
    public CartItem(Dish dish, int quantity, String customization){
        this.dish = dish;
        setQuantity(quantity);
        this.customization = customization;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        if(quantity >= 0){
            this.quantity = quantity;
        }
        else
            quantity = 0;
    }

    public Dish getDish() {
        return dish;
    }

    // probably won't be used
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    // Getter for customization
    public String getCustomization() {
        return customization;
    }
    public double getTimeNeededforDelivery()
    {
        //random number
        return dish.getTimeNeededforCooking()*(Math.log(quantity+1)+0.8);
    }
//    public void updateCartItemStock(){
//        dish.setStock(dish.getStock() - this.quantity); //existing stock - ordered quantity = new stock
//    }
}
