package com.example.foodordersystem.Order_Folder;

import com.example.foodordersystem.Accounts.AccountsManager;
import com.example.foodordersystem.Accounts.Cart.Cart;
import com.example.foodordersystem.Accounts.Cart.CartItem;
import com.example.foodordersystem.Accounts.User;
import com.example.foodordersystem.Restaurant.*;

import java.util.ArrayList;
import java.util.Scanner;

class Order {
    User user;
    //Changes from DISH -> CART ITEM
    public void OrderItem(Dish item, User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("- " + item.getName());
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than 0. Try again.");
            }
//            if (quantity > item.getStock()) {
//                System.out.println("Adding this quantity exceeds stock for item: " + item.getName() + ". Available stock: " + item.getStock() +
//                        ", Current in cart: " + quantity);
//            }
            String customization = handleCustomizations(scanner);
            System.out.println(item.getName() + " x" + quantity + " added to your cart with Add-ons: " + customization);
            //Adds dish to cart
            user.getCart().addToCart(new CartItem(item, quantity, customization));
    }

    private String handleCustomizations(Scanner scanner) {
        StringBuilder customization = new StringBuilder();
        boolean doneAdding = false;

        // Customization options
        String[] options = {"Extra Fries", "Extra Cheese", "Spicy"};
        boolean[] selected = {false, false, false}; // To track selected options

        System.out.println("Do you want to add customizations? (yes/no)");
        String addCustomization = scanner.nextLine();

        if (addCustomization.equalsIgnoreCase("yes")) {
            while (!doneAdding) {
                // Display only available (unselected) customizations
                System.out.println("Choose customizations: ");
                for (int i = 0; i < options.length; i++) {
                    if (!selected[i]) {
                        System.out.println((i + 1) + ". " + options[i]);
                    }
                }
                System.out.println("5. Done adding customizations");

                System.out.print("Enter the number for your customization: ");
                String input = scanner.nextLine();

                if (input.trim().isEmpty()) {
                    continue;
                }

                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice. Please enter a valid number.");
                    continue;
                }

                if (choice == 5) {
                    break;
                }

                if (choice >= 1 && choice <= options.length && !selected[choice - 1]) {

                    selected[choice - 1] = true;
                    if (!customization.isEmpty()) customization.append(", ");
                    customization.append(options[choice - 1]);
                } else {
                    System.out.println("Invalid choice or option already selected.");
                }

                // 25tar kolo??
                boolean allSelected = true;
                for (boolean optionSelected : selected) {
                    if (!optionSelected) {
                        allSelected = false;
                        break;
                    }
                }
                if (allSelected) {
                    doneAdding = true;
                }
            }
        }

        // mesh m3ah floos lel add ons
        if (customization.isEmpty()) {
            customization.append("No Customization");
        }

        return customization.toString();
    }
}
