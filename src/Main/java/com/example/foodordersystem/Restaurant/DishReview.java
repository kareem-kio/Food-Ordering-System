package com.example.foodordersystem.Restaurant;

public class DishReview extends Review {
    private String dishID;
    public DishReview(String userID, String restaurantID, String reviewTitle, String reviewContent, double rating, String dishID) {
        super(userID,restaurantID,reviewTitle,reviewContent, rating);
        this.dishID = dishID;
    }
    public String getDishID() {
        return dishID;
    }
    public void setDishID(String dishID) {
        this.dishID = dishID;
    }
}
