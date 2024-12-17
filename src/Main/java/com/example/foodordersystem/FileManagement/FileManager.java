package com.example.foodordersystem.FileManagement;

import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.Admin;
import com.example.foodordersystem.Accounts.User;
import com.example.foodordersystem.Restaurant.All_Restaurants;
import com.example.foodordersystem.Restaurant.Restaurant;
import com.example.foodordersystem.Restaurant.Review;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

class LocalDateAdapter implements JsonDeserializer<LocalDate>, JsonSerializer<LocalDate> {
    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString()); // Convert to ISO-8601 string (e.g., "2024-12-15")
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsString()); // Parse ISO-8601 string
    }
}
class YearMonthAdapter implements JsonDeserializer<YearMonth>, JsonSerializer<YearMonth> {
    @Override
    public JsonElement serialize(YearMonth src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString()); // Convert to "yyyy-MM" format
    }

    @Override
    public YearMonth deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return YearMonth.parse(json.getAsString()); // Parse "yyyy-MM" format
    }
}

public final class FileManager {
    private static final String usersFilePath = new File("src/Main/java/com/example/foodordersystem/FileManagement/Files/Users.json").getAbsolutePath();
    private static final String adminsFilePath = new File("src/Main/java/com/example/foodordersystem/FileManagement/Files/Admins.json").getAbsolutePath();
    private static final String restaurantsFilePath = new File("src/Main/java/com/example/foodordersystem/FileManagement/Files/Restaurants.json").getAbsolutePath();
    private static final String reviewsFilePath = new File("src/Main/java/com/example/foodordersystem/FileManagement/Files/Reviews.json").getAbsolutePath();
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(YearMonth.class, new YearMonthAdapter())

            .setPrettyPrinting().create();
    //-------------------------------------------------//
    // Reading:
    public static void readAllJSON(){
        AccountsManager.setUsers(readEachJSON(usersFilePath, new TypeToken<ArrayList<User>>() {}.getType()));
        AccountsManager.setAdmins(readEachJSON(adminsFilePath, new TypeToken<ArrayList<Admin>>() {}.getType()));
        All_Restaurants.setRestaurants(readEachJSON(restaurantsFilePath, new TypeToken<ArrayList<Restaurant>>() {}.getType()));
        All_Restaurants.setReviews(readEachJSON(reviewsFilePath, new TypeToken<ArrayList<Review>>() {}.getType()));
    }
    private static <T> ArrayList<T> readEachJSON(String filepath, Type type){
        try (FileReader reader = new FileReader(filepath)) {
            ArrayList<T> data = gson.fromJson(reader, type);
            return (data != null) ? data : new ArrayList<>();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    //-------------------------------------------------//
    // Writing:
    public static void writeAllJSON(){
        System.out.println("Writing all JSON files...");
        writeEachJSON(AccountsManager.getUsers(), usersFilePath);
        writeEachJSON(AccountsManager.getAdmins(), adminsFilePath);
        writeEachJSON(All_Restaurants.getRestaurants(), restaurantsFilePath);
        writeEachJSON(All_Restaurants.getReviews(), reviewsFilePath);
    }
    private static void writeEachJSON(Object data, String filepath){
        File file = new File(filepath);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
        try (FileWriter writer = new FileWriter(filepath)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void printRestaurantData() {
        ArrayList<Restaurant> restaurants = All_Restaurants.getRestaurants();
        for (Restaurant restaurant : restaurants) {
            System.out.println("Restaurant Name: " + restaurant.getName());
            System.out.println("Address: " + restaurant.getAddress());
            System.out.println("Phone: " + restaurant.getPhone());
            System.out.println("Rating: " + restaurant.getRating());
            System.out.println("-----------------------------------");
        }
    }
}