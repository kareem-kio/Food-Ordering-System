module com.example.foodordersystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;


    opens com.example.foodordersystem to javafx.fxml;
    opens com.example.foodordersystem.Accounts to com.google.gson;
    exports com.example.foodordersystem;
    exports com.example.foodordersystem.Resturants;
    opens com.example.foodordersystem.Resturants to javafx.fxml;
}
