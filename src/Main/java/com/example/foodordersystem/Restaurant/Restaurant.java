package com.example.foodordersystem.Restaurant;

import com.example.foodordersystem.Accounts.Account;
import com.example.foodordersystem.Accounts.AccountsManager;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Restaurant implements  Comparable<Restaurant> {

    private String ID;
    private String name;
    private String address;
    private String phone; // contact info
    private double rating = 0.0;
    private Menu menu;

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    private String imgSrc;
    private ArrayList<Review> reviews;
//    private ArrayList<Dish> dishes;
    private HashSet<YearMonth> months;
    private HashSet<LocalDate> day;
    private HashSet<Integer> year;
    public Restaurant(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        calculateRating();
        this.menu = new Menu(new ArrayList<>());
        setID();
        this.reviews = new ArrayList<>();
        this.months = new HashSet<>();
        this.year = new HashSet<>();
        this.day = new HashSet<>();
    }
    public boolean dishExists (String ID){
        for(Dish dish : menu.getDishes()){
            if(dish.getID().equals(ID)){
                return true;
            }
        }
        return false;
    }
    public String getID() {
        return ID;
    }
    private void setID() {
        while(true){
            String ID = String.format("%04d", new Random().nextInt(10000));
            if(All_Restaurants.restaurantExists(ID)==null){ // if the current ID doesn't exist, create a new one
                this.ID = ID;
                All_Restaurants.addRestaurant(this);
                break;
            }
        }
    }

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public double getRating() {
        calculateRating();
        return rating;
    }
    public void setRating(double rating) { this.rating = rating; }

    public ArrayList<Review> getReviews() { return reviews; }
    public void setReviews(ArrayList<Review> reviews) { this.reviews = reviews; }
    // calc mean of ratings
    // Don't forget to calculate the mean of the dishes rating too :)
    private void calculateRating() {
        double newRating = 0.0;
        if(reviews==null) this.reviews = new ArrayList<>();
        for(Review review : reviews) {
            newRating += review.getRating();
        }
        this.rating = (!reviews.isEmpty()) ? newRating / reviews.size() : 0;
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
        calculateRating();
    }

    public void displayInfo() { System.out.println(name + " " + address + " " + phone + " " + rating); }

    public void displayMenu() {
        System.out.println("Menu for " + name + ":");
        if (menu != null) menu.displayMenu();
        else System.out.println("No menu available.");
    }
    public void addDish(Dish dish) {
        if(menu.getDishes() == null) menu.setDishes(new ArrayList<>());
        if(!menu.getDishes().contains(dish))
            this.menu.getDishes().add(dish);
    }
    public void removeDish(Dish dish) {
        if(menu.getDishes() == null) menu.setDishes(new ArrayList<>());
        this.menu.getDishes().remove(dish);
    }
    public void removeDish(String dishName) {
        if(menu.getDishes() == null) return;
        this.menu.getDishes().removeIf(dish -> dish.getName().equals(dishName));
    }
    public ArrayList<Dish> getDishes()
    {
        if(menu.getDishes() == null)
            return new ArrayList<>();
        return menu.getDishes();
    }
    public void setDishes(ArrayList<Dish>  dishes) { this.menu.setDishes(dishes); }

    public HashSet<Integer> getYear() {
        if(year == null)
            year = new HashSet<>();
        return year;
    }

    public HashSet<LocalDate> getDay() {
        if(day == null)
            day = new HashSet<>();
        return day;
    }

    public HashSet<YearMonth> getMonths() {
        if(months == null)
            months = new HashSet<>();
        return months;
    }

    // form high rating to low rating
    @Override
    public int compareTo(Restaurant o) {
        return Double.compare(o.rating, this.rating);
    }
}
