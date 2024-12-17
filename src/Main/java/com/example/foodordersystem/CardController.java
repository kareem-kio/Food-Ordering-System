//package com.example.foodordersystem;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.HBox;
//
//import Model.old_Restaurant;
//
//public class CardController {
//
//
//
//    @FXML
//    private HBox Rbox;
//
//    @FXML
//    private Label Rdescription;
//
//    @FXML
//    private ImageView Rimg;
//
//    @FXML
//    private Label Rname;
//
//
//
//    public void setData(old_Restaurant resturant) {
//        // Default image path
//        String defaultImgPath = "../../../images/VP.jpg";
//
//        // Determine the image source
//        String imgPath = (resturant.getImgSrc() != null) ? resturant.getImgSrc() : defaultImgPath;
//
//        // Load the image
//        Image image = new Image(getClass().getResourceAsStream(imgPath));
//        Rimg.setImage(image);
//
//        // Set name and description
//        Rname.setText(resturant.getName());
//        Rdescription.setText(resturant.getDescription());
//    }
//
//
//
//
//
//
//
//}
