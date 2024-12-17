package com.example.foodordersystem.Restaurant;
import com.example.foodordersystem.Accounts.User;

import java.util.ArrayList;
import java.util.Random;

public class Review {

    final double RATINGMIN = 0.0, RATINGMAX = 5.0;
    //ID's
    private String userID;
    private String restaurantID;
    private String reviewID;
    //review
    private String reviewTitle;
    private String reviewContent;
    private double rating;
    // you either review a dish in a restaurant (need both dishID, restaurantID), or you add a review to a restaurant only (need restaurant ID, dishID = "\\")
    public Review(String userID, String restaurantID, String reviewTitle, String reviewContent, double rating) {
        this.userID = userID;
        this.restaurantID = restaurantID;
        this.reviewContent = reviewContent;
        this.reviewTitle = reviewTitle;
        this.rating = rating;
        setReviewID();
    }

    public void setRating(double rating){
        if(RATINGMIN <= rating && rating <= RATINGMAX )
            this.rating = rating;

    }
    public double getRating() { return rating; }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUserID() { return userID; }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }
    public String getRestaurantID() { return restaurantID; }

    private void setReviewID() {
        while(true){
            String ID = String.format("%04d", new Random().nextInt(1000000));
            if(All_Restaurants.restaurantExists(ID)==null){ // if the current ID doesn't exist, create a new one
                this.reviewID = ID;
                All_Restaurants.addReview(this);
                break;
            }
        }
    }
    public String getReviewID() { return reviewID; }
    public String getRestaurant() { return restaurantID; }

    public void setReviewTitle(String reviewTitle) {
        if(!reviewTitle.isEmpty())
            this.reviewTitle = reviewTitle;
    }
    public String getReviewTitle() { return reviewTitle; }

    public void setReviewContent(String reviewContent) {
        if(!reviewContent.isEmpty())
            this.reviewContent = reviewContent;
    }
    public String getReviewContent() { return reviewContent; }

    // edit (string new_description, double rating)
    // to edit u need review id only
    private Review findReviewByID(String reviewID) {
         Review review =  All_Restaurants.reviewExists(reviewID);
         if(review == null)
             System.out.println("Review does not exist");
         return review;
    }

    public void editReviewTitle(String reviewID, String reviewTitle) {
        Review review = findReviewByID(reviewID);
        if(review!=null)
            review.setReviewTitle(reviewTitle);
    }

    public void editReviewContent(String reviewID, String reviewContent) {
        Review review = findReviewByID(reviewID);
        if(review!=null)
            review.setReviewContent(reviewContent);
    }

    public void editReviewRating(String reviewID, double rating) {
        Review review = findReviewByID(reviewID);
        if(review!=null)
            review.setRating(rating);
    }

    public void deleteReview(String reviewID) {
        Review review = findReviewByID(reviewID);
        if(review != null) // then it exists
            All_Restaurants.deleteReview(review);
    }

}
