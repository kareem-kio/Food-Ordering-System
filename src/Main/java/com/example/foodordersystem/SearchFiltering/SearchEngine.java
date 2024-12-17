package com.example.foodordersystem.SearchFiltering;

import com.example.foodordersystem.Restaurant.All_Restaurants;
import com.example.foodordersystem.Restaurant.Dish;
import com.example.foodordersystem.Restaurant.Restaurant;

import java.util.ArrayList;
// two functions to sort from high to low and vice versa (filtering)
// function to search on rest. and another for dishes
// I want the user to search on a dish, if found then has a list of restaurants that have it
// or search on a restaurant, if found then click on it will put you on the restaurant page
public class SearchEngine {
    // Key: Name of Dish, value: list of resturants have this dish
    public static ArrayList<Dish> searchOnDishes(String dish)
    {
        ArrayList<Dish> dishes = new ArrayList<>();
        for(Restaurant r : All_Restaurants.getRestaurants())
        {
            for (Dish d : r.getDishes())
            {
                boolean exist = d.getName().contains(dish);
                if(exist)
                    dishes.add(d);
            }
        }
        return dishes;
    }
    public static ArrayList<Restaurant> searchOnRestaurants(String rest)
    {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        for(Restaurant r : All_Restaurants.getRestaurants())
        {
            boolean exist = r.getName().contains(rest);
            if(exist)
                restaurants.add(r);
        }
        return restaurants;
    }

}
