package com.example.foodordersystem.Resturants;

import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.Cart.Cart;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.Accounts.User;
import com.example.foodordersystem.Restaurant.Dish;
import com.example.foodordersystem.Restaurant.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class RestaurantDetailsController {

    @FXML
    private ScrollPane dishScrollPane;
    @FXML
    private VBox dishVBox1;

    @FXML
    private VBox dishVBox2;


    @FXML
    private Button backButton;
    @FXML
    private Label restaurantAddress;
    @FXML
    private Label restaurantName;
    @FXML
    private Label restaurantPhone;
    @FXML
    private Label restaurantRating;
    @FXML
    private ImageView restaurantImage;

    public void setRestaurantData(Restaurant restaurant) {
        restaurantName.setText(restaurant.getName());
        restaurantAddress.setText(restaurant.getAddress());
        restaurantPhone.setText(restaurant.getPhone());
        restaurantRating.setText(String.valueOf(restaurant.getRating()));
        //Image img = new Image(getClass().getResourceAsStream(restaurant.getImgSrc()));
        //restaurantImage.setImage(img);

        User currentUser = (User) AccountsManager.getSession();
        Cart userCart = currentUser.getCart();

        List<Dish> dishes = restaurant.getDishes();
        int count = 1;
        try {
            for (Dish dish : dishes) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/foodordersystem/Resturants/MenuItemCard.fxml"));
                Parent dishCard = fxmlLoader.load();

                MenuItemCardController menuItemCardController = fxmlLoader.getController();



                menuItemCardController.setData(dish);
                if (count == 1){
                    dishVBox1.getChildren().add(dishCard);
                    count++;
                }else {
                    dishVBox2.getChildren().add(dishCard);
                    count--;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBackButton() {
        try {
            URL url = getClass().getResource("/com/example/foodordersystem/Screen1.fxml");
            if (url == null) {
                throw new IOException("FXML file not found!");
            }
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            // Set the scene or stage with the loaded FXML
            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }
    }
}
