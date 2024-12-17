package com.example.foodordersystem.Accounts.Cart;


import com.example.foodordersystem.Restaurant.Dish;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> cart = new ArrayList<>();
    private double totalPrice;

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (CartItem item : cart) {
            totalPrice += item.getDish().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        if(totalPrice >= 0)
            this.totalPrice = totalPrice;
        else
            this.totalPrice = 0;
    }

    public ArrayList<CartItem> getCartItems() {
        return cart;
    }
    public void addToCart(Dish dish, int quantity, String customization) {
        CartItem cartItem = new CartItem(dish,quantity,customization);
        cart.add(cartItem);
        this.totalPrice += cartItem.getDish().getPrice()*cartItem.getQuantity();
    }

    public void addToCart(CartItem cartItem) {
        cart.add(cartItem);
        this.totalPrice += (cartItem.getDish().getPrice() * cartItem.getQuantity());
    }
    // here i used anyMatch because I wanted a boolean value to be returned to the helper method
    // in user class as being existing or not determines weither it will be added as
    // a new item or only updating an existing item
    public boolean addToCartSpecifically(CartItem item) {
        if(cart == null)
        {
            cart = new ArrayList<>();
            return false;
        }
        return ( cart.stream().anyMatch(cartItem -> {
            if (cartItem.getDish().getName().equals(item.getDish().getName()) &&
                    cartItem.getCustomization().equals(item.getCustomization())) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                float newTotalPrice = (float) (getTotalPrice()+(item.getDish().getPrice()* item.getQuantity()));
                setTotalPrice(newTotalPrice);
                return true;
            }
            return false;
        }));
    }

    public void removeFromCart(CartItem item) {
        cart.removeIf(cartItem -> {
            if (cartItem.equals(item))
            {
                this.totalPrice -= cartItem.getDish().getPrice();
                return true; // Remove this cart detail
            }
            return false; // Keep this cart detail
        });
    }
   // // identifer in dish needed
    //function to remove dishes from cart depending on it's quantity and name and customisation
    // dish is identical if it has same customisation and same name
    // Cartitems are removed based on quantity of the item entered to it
    // for example: if i have 4 pizzas and
    // item is from the same type and customisation of pizza with quantity to be removed is 3
    // then cart item will have finally only 1 pizza left!
    // used stream for practice only, i can use another simplified version that depends on
    // contains() method of Arraylist
    // return true when any removal happens otherwise returns false

    public void removeFromCartSpecifically(CartItem item)
    {
        if(cart == null)
        {
            cart = new ArrayList<>();
        }

        cart.stream()
                .filter(cartItem -> cartItem.getDish().getName().equals(item.getDish().getName()) &&
                        cartItem.getCustomization().equals(item.getCustomization()))
                .findFirst()
                .ifPresent(cartItem -> {
                    float newTotalPrice;
                    // actual quantity, maybe in negative
                    int quant = cartItem.getQuantity() - item.getQuantity();

                    if (quant >= 0) {
                        newTotalPrice = (float) (getTotalPrice() - (item.getDish().getPrice() * item.getQuantity()));
                    } else {
                        // we will remove the totalprice of this item men el a5er
                        newTotalPrice = (float) (getTotalPrice() - (cartItem.getDish().getPrice() * cartItem.getQuantity()));
                    }

                    cartItem.setQuantity(quant);
                    setTotalPrice(newTotalPrice);

                    if (cartItem.getQuantity() == 0) {
                        cart.remove(cartItem);
                    }
                });

    }

}
