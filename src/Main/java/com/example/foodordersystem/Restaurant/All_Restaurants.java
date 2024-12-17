package com.example.foodordersystem.Restaurant;

import java.util.ArrayList;

public class All_Restaurants {
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();
    private static ArrayList<Review> reviews = new ArrayList<>();

    public static Restaurant restaurantExists(String ID) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getID().equals(ID)) {
                return restaurant;
            }
        }
        return null;
    }
    public static void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }


    public static Review reviewExists(String ID) {
        for (Review review : reviews) {
            if (review.getReviewID().equals(ID)) {
                return review;
            }
        }
        return null;
    }

    public static void addReview(Review review) {
        reviews.add(review);
    }

    public static void deleteReview(Review review) {
        reviews.remove(review);
    }

    public static void setRestaurants(ArrayList<Restaurant> restaurants) {
        All_Restaurants.restaurants = restaurants;
    }

    public static void setReviews(ArrayList<Review> reviews) {
        All_Restaurants.reviews = reviews;
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static ArrayList<Review> getReviews() {
        return reviews;
    }
}
