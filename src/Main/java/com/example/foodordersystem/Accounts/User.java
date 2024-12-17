package com.example.foodordersystem.Accounts;

import com.example.foodordersystem.Accounts.Cart.Cart;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.PaymentSystem.Payment;
import com.example.foodordersystem.PaymentSystem.PaymentGateway;
import com.example.foodordersystem.Restaurant.Dish;

import java.util.Objects;

public class User extends Account {
    private Cart cart;
    private float balance;
    private float totalOfOrders;
    public PaymentGateway PG;
    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public User(String name, String username, String password, String email, String phone, String address) {
        super(name,username,password,email,phone,address);
        System.out.println("USER IS CREATED");
        this.cart = new Cart();
        PG = new PaymentGateway(this.getID());
    }
    public boolean Login(String username, String password) {
        User foundUser = AccountsManager.authSearchUsers(username, password);
        if (foundUser!=null){
            AccountsManager.setSession(foundUser);
            return true;
        }
        return false;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void checkOut() {
        PG.Checkout();
    }
    //    public boolean Register(String name, String username, String password, String email, String phone, String address) {
//        User foundUser = AccountsManager.SearchGuyNotFound(username, "username"); //to be changed
//        if (foundUser!=null){
//            AccountsManager.AddUser(name, username, password, email, phone, address);
//            return true;
//        }
//        return false;
//    }
    public boolean Register(String name, String username, String password, String email, String phone, String address) {
        if (AccountsManager.SearchGuyNotFound(username, "username")){
            AccountsManager.AddUser(name, username, password, email, phone, address);
            return true;
        }
        return false;
    }
    // it will add the item without any specifications later
    public void addToUserCartNormal(CartItem item)
    {
        // to be implemented
        helperAddToCart(item);

    }
    public void addToUserCartNotNormal(Dish dish, int quantity, String customization)
    {
        // to be implemented
        CartItem item = new CartItem(dish,quantity,customization);
        helperAddToCart(item);
    }

    private void helperAddToCart(CartItem item) {
        if(cart == null)
            cart = new Cart();

        boolean existing = cart.addToCartSpecifically(item);

        if (!existing) {
            cart.addToCart(item);
        }
    }
    private void helperRemoveFromCart(CartItem item) {
        if(cart == null)
            cart = new Cart();
        cart.removeFromCartSpecifically(item);
    }

    // it removes the item without any specification on it's quantity
    public void removeFromUserCartNormal(CartItem item)
    {
        helperRemoveFromCart(item);
    }
    public void removeFromUserCartNormal(Dish dish, int quantity, String customization)
    {
        CartItem item = new CartItem(dish,quantity,customization);
        helperRemoveFromCart(item);

    }
    // rest of review, restaurants (menus, order)
//    public void refund(Payment p)
//    {
//        PG.Refund(p);
//    }
}
