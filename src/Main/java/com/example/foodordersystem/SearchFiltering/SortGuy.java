package com.example.foodordersystem.SearchFiltering;

import com.example.foodordersystem.Restaurant.Dish;
import com.example.foodordersystem.Restaurant.DishCompareByPrice;
import com.example.foodordersystem.Restaurant.DishCompareByRating;
import com.example.foodordersystem.Restaurant.Restaurant;

import java.util.ArrayList;
import java.util.Collections;

public class SortGuy {
    public static ArrayList<Dish> sortDishesByPrice(ArrayList<Dish> dishes){
        ArrayList<Dish> newDishes = new ArrayList<>(dishes);
        newDishes.sort(new DishCompareByPrice());
        return newDishes;
    }
    public static ArrayList<Dish> sortDishesByRating(ArrayList<Dish> dishes){
        ArrayList<Dish> newDishes = new ArrayList<>(dishes);
        newDishes.sort(new DishCompareByRating());
        return newDishes;
    }
    public static ArrayList<Dish> sortDishesByBoth(ArrayList<Dish> dishes){
        ArrayList<Dish> newDishes = new ArrayList<>(dishes);
        newDishes.sort(new DishCompareByRating());
        newDishes.sort(new DishCompareByPrice());
        return newDishes;
    }
    public static ArrayList<Restaurant> sortRestaurants(ArrayList<Restaurant> restaurants){
        ArrayList<Restaurant> newRestaurants = new ArrayList<>(restaurants);
        Collections.sort(newRestaurants);
        return newRestaurants;
    }
}
