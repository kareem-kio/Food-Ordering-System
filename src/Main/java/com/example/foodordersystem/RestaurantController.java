//package com.example.foodordersystem;
//
//import Model.old_Restaurant;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.layout.HBox;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class RestaurantController implements Initializable {
//    @FXML
//    private HBox cardLayout;
//    private List<old_Restaurant> recentlyAdded;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        recentlyAdded = new ArrayList<>(recentlyAdded());
//        try {
//            for (old_Restaurant resturant : recentlyAdded) {
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("/com/example/foodordersystem/card.fxml"));
//                HBox cardBox = fxmlLoader.load();
//
//                CardController cardController = fxmlLoader.getController();
//                cardController.setData(resturant);
//
//                cardLayout.getChildren().add(cardBox);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private List<old_Restaurant> recentlyAdded() {
//        List<old_Restaurant> ls = new ArrayList<>();
//
//        ls.add(new old_Restaurant("KAREEM EL HOT", "Does the gui in the app", "/images/VP.jpg"));
//        ls.add(new old_Restaurant("EL WALTER", "EL KHYAT ENZL YA METZALA3", "/images/khyat.png"));
//        ls.add(new old_Restaurant("JOUDY A WOMAN", "SHE IS A..... CAT?!", "/images/joudy.png"));
//        ls.add(new old_Restaurant("FADY GITHUB LOVER", "LOVE GITHUB AND CATS VERY MUCH", "/images/fady.png"));
//        ls.add(new old_Restaurant("AZAD EL 2ASAD", "LOVE SYRIA NEWS AND LISTEN TO.... WELL...", "/images/azad.png"));
//        ls.add(new old_Restaurant("SAMURANIUM", "SWEATY PROBLEM SOLVER TOO SWEATY", "/images/badr.png"));
//
//        return ls;
//    }
//}
