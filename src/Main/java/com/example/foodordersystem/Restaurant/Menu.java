package com.example.foodordersystem.Restaurant;

import com.example.foodordersystem.Accounts.Cart.CartItem;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Dish> dishes;

    public Menu(ArrayList<Dish> dishes) {
        System.out.println("Menu is created");
        this.dishes = dishes;
    }

    public ArrayList<Dish> getDishes() { return dishes; }
    public void setDishes(ArrayList<Dish> dishes) { this.dishes = dishes; }

    public void displayMenu() {
        System.out.println("Menu:");
        for (Dish dish : dishes) {

            System.out.println(dish.getName() + " - $" + dish.getPrice() + ": " + dish.getDescription());

        }
    }
    public void addToMenu(Dish dish) {
        dishes.add(dish);
    }
    public void removeFromMenu(Dish dish) {
        dishes.removeIf(d -> d.equals(dish));
    }
}
