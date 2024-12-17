package com.example.foodordersystem.Restaurant;

import java.util.Comparator;

public class DishCompareByPrice implements Comparator<Dish> {
    @Override
    public int compare(Dish o1, Dish o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
