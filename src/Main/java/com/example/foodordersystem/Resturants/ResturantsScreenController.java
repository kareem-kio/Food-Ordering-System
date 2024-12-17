package com.example.foodordersystem.Resturants;

//import Model.Restaurant;
import com.example.foodordersystem.Restaurant.All_Restaurants;
import com.example.foodordersystem.Restaurant.Dish;
import com.example.foodordersystem.Restaurant.Restaurant;
import com.example.foodordersystem.MyListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ResturantsScreenController implements Initializable, MyListener {

    @FXML
    private GridPane resturantGrid;

    @FXML
    private ScrollPane resturantScroll;

    private List<Restaurant> Restaurants = All_Restaurants.getRestaurants();

    private List<Restaurant> getData() {
        return All_Restaurants.getRestaurants();
    }


    private void switchToRestaurantDetails(Restaurant restaurant, Node sourceNode) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/foodordersystem/Resturants/ResturantDetails.fxml"));
            Scene detailsScene = new Scene(loader.load());
            RestaurantDetailsController detailsController = loader.getController();
            detailsController.setRestaurantData(restaurant);

            // Get the current stage and set the new scene
            Stage stage = (Stage) sourceNode.getScene().getWindow();
            stage.setScene(detailsScene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Restaurants.addAll(getData());
        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i < Restaurants.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/foodordersystem/Resturants/ResturantCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ResturantCardController resturantCardController = fxmlLoader.getController();
                resturantCardController.setData(Restaurants.get(i), restaurant -> switchToRestaurantDetails(restaurant, resturantGrid));  // Pass this as the listener

                if (column == 3) {
                    column = 0;
                    row++;
                }
                resturantGrid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20));  // Add margin for spacing
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ensure GridPane fits its content width
        resturantGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
        resturantGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
        resturantGrid.setMaxWidth(Region.USE_PREF_SIZE);

        // Ensure ScrollPane fits its content width
        resturantScroll.setFitToWidth(true);
    }

    @Override
    public void onClickListener(com.example.foodordersystem.Restaurant.Restaurant restaurant) {

    }
}
