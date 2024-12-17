package com.example.foodordersystem.Restaurant;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Dish{
    private String restaurantID;
    private String name;
    private String ID;
    private double price;
    private double cost;
    private String description;
    private String image;
    private double rating = 0.0;
    private HashMap<LocalDate, Integer> SoldDaily;
    private HashMap<YearMonth,Integer> SoldMonthly;
    private HashMap<Integer,Integer> SoldYearly;
    private ArrayList<DishReview> reviews;
    public Dish(String name, double price, String description, String image, double cost) {
        this(name, price);
        this.description = description;
        this.image = image;
        this.cost = cost;
        this.restaurantID = ID;
        reviews = new ArrayList<>();
        SoldDaily = new HashMap<>();
        SoldMonthly = new HashMap<>();
        SoldYearly = new HashMap<>();
    }
    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
        this.description = "No Description";
        this.image = "C:/";
        setID();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public double getRating() {
        calculateRating();
        return rating;
    }
    public void setRating(double rating) { this.rating = rating; }

    private void setID() {
        Restaurant restaurant = null;
        for(Restaurant r : All_Restaurants.getRestaurants()) {
            if(r.getID().equals(restaurantID)) {
                restaurant = r;
            }
        }
        if(restaurant!=null) {
            while(true){
                String ID = String.format("%04d", new Random().nextInt(10000));
                if(!restaurant.dishExists(ID)){ // if the current ID doesn't exist, create a new one
                    this.ID = ID;
                    break;
                }
            }
        }
    }

    public String getID() {
        return ID;
    }

    public void customize(String description) { this.description = description;}

    private void calculateRating() {
        double newRating = 0.0;
        for(Review review : reviews) {
            newRating += review.getRating();
        }
        this.rating = (!reviews.isEmpty()) ? newRating / reviews.size() : 0;
    }

    public void addReview(DishReview review) {
        this.reviews.add(review);
        calculateRating();
    }

    public void removeReview(DishReview review) {
        this.reviews.remove(review);
        calculateRating();
    }
    public ArrayList<DishReview> getReviews() { return reviews; }

    public Integer getSoldDaily(LocalDate date) {
        if(SoldDaily.containsKey(date))
            return SoldDaily.get(date);
        return null;
    }
    public void setSoldDaily(LocalDate date,int sold) {
        if(SoldDaily == null)
            SoldDaily = new HashMap<>();
        SoldDaily.put(date, Math.max(sold, 0));
    }
    public Integer getSoldMonthly(YearMonth date) {
        if(SoldMonthly.containsKey(date)) {
            return SoldMonthly.get(date);
        }
        return null;
    }
    public void setSoldMonthly(YearMonth date, int sold) {
        if(SoldMonthly == null)
            SoldMonthly = new HashMap<>();
        SoldMonthly.put(date, Math.max(sold, 0));
    }
    public Integer getSoldYearly(int date) {
        if(SoldYearly.containsKey(date))
            return SoldYearly.get(date);
        return null;
    }
    public void setSoldYearly(int date,int sold) {
        if(SoldYearly == null)
            SoldYearly = new HashMap<>();
        SoldYearly.put(date, Math.max(sold, 0));
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public HashMap<Integer, Integer> getSoldYearly() {
        if(SoldYearly == null)
            return new HashMap<>();
        return SoldYearly;
    }

    public HashMap<LocalDate, Integer> getSoldDaily() {
        if(SoldDaily == null)
            return new HashMap<>();
        return SoldDaily;
    }
    public HashMap<YearMonth, Integer> getSoldMonthly() {
        if(SoldMonthly == null)
            return new HashMap<>();
        return SoldMonthly;
    }

    public boolean equals(Object dish) {
        if(!(dish instanceof Dish other))
            return false;
        else
        {
            return this.ID.equals(other.getID());
        }
    }

    public String getRestaurantID() {
        return restaurantID;
    }
}
