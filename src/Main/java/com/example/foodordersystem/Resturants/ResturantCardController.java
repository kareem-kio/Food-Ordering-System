package com.example.foodordersystem.Resturants;

import com.example.foodordersystem.Restaurant.Restaurant;
import com.example.foodordersystem.MyListener;
import com.example.foodordersystem.Restaurant.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class ResturantCardController {

    @FXML
    private Label restaurantRate;

    @FXML
    private Label resturantLabel;

    @FXML
    private ImageView resturantPicture;

    private Restaurant restaurant;
    private MyListener myListener;

    public void setData(Restaurant restaurant, MyListener myListener) {
        this.restaurant = restaurant;
        this.myListener = myListener;
        resturantLabel.setText(restaurant.getName());
        restaurantRate.setText(String.valueOf(restaurant.getRating()));
//        Image fixedImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/badr.png")));
//        resturantPicture.setImage(fixedImage);



    }

    @FXML
    private void handleClick(MouseEvent event) {
        if (myListener != null) {
            myListener.onClickListener(restaurant);
        }
    }
}
