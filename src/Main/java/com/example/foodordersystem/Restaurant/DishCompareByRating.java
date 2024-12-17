package com.example.foodordersystem.Restaurant;

import java.util.Comparator;

public class DishCompareByRating implements Comparator<Dish> {
    public int compare(Dish d1, Dish d2) {
        return Double.compare(d2.getRating(), d1.getRating());
    }
}
