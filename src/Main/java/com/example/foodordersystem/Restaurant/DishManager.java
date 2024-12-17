//package com.example.foodordersystem.Restaurant;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class DishManager {
//    private static DishManager instance;
//    private Map<String, Dish> dishes;
//
//    private DishManager() {
//        dishes = new HashMap<>();
//    }
//
//    public static DishManager getInstance() {
//        if (instance == null) {
//            instance = new DishManager();
//        }
//        return instance;
//    }
//
//    public void addDish(Dish dish) {
//        dishes.put(dish.getName(), dish);
//    }
//
//    public Dish getDish(String name) {
//        return dishes.get(name);
//    }
//
//    public void updateDish(Dish dish) {
//        dishes.put(dish.getName(), dish);
//    }
//}
