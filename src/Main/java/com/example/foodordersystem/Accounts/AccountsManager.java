package com.example.foodordersystem.Accounts;

import java.util.ArrayList;

public final class AccountsManager {
    //---------------------------------------------------------//
    // Needed Fields:
    private static Account session;
    private static ArrayList<User> users;
    private static ArrayList<Admin> admins;
    public AccountsManager() {
        users = new ArrayList<>();
        admins = new ArrayList<>();
    }
    //---------------------------------------------------------//
    // Search engine for authentication
    //---------------------------------------------------------//
    // User Related:
    public static ArrayList<User> getUsers() {
        return users;
    }
    public static void setUsers(ArrayList<User> users) {
        AccountsManager.users = users;
    }




    public static User authSearchUsers(String username, String password) {
        if (users == null) {
            System.out.println("Users list is null!");
            users = new ArrayList<>();
        }

        System.out.println("checking user array");
        for (User user : users) {
            System.out.println("Checking user: " + user.getUsername());
            if (username.equals(user.getUsername())) {
                System.out.println("User found:  " + user.getUsername());
//                if (password.equals(user.getPassword())){
//                    System.out.println("Password correct: "+user.getPassword());
//
//                   }

                return user;
            }
        }
//&& password.equals(user.getPassword())
        System.out.println("User not found!");
        return null;
    }




    public static void AddUser(String name, String username, String password, String email, String phone, String address){
        AccountsManager.users.add(new User(name, username, password, email, phone, address));
    }
    public static void AddUser(User user){
        if(users == null) users = new ArrayList<>();
        AccountsManager.users.add(user);
    }

    //---------------------------------------------------------//
    // Admin Related:
    public static ArrayList<Admin> getAdmins() {
        return admins;
    }
    public static void setAdmins(ArrayList<Admin> admins) {
        AccountsManager.admins = admins;
    }
    public static Admin authSearchAdmins(String username, String password){
        for(Admin admin: AccountsManager.admins) {
            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                return admin;
            }
        }
        return null;
    }
    public static void AddAdmin(String name, String username, String password, String email, String phone, String address){
        AccountsManager.admins.add(new Admin(name, username, password, email, phone, address));
    }
    public static void AddAdmin(Admin admin){
        AccountsManager.admins.add(admin);
    }

    //---------------------------------------------------------//
    // Session:
    public static void setSession(Account acc)
    {
        AccountsManager.session = acc;
        // don't forget downcasting in the future implementations
    }
    //---------------------------------------------------------//
    // Search method for searching on existing attributes
    // attribute: thing you want to search on
    // type: type of the attribute to be searched
    static boolean SearchGuyNotFound(String attribute, String type) {
        if(AccountsManager.users != null){
            for (Account account : AccountsManager.users) {
                if(helperForSearchGuyNotFound(account,attribute, type))
                    return false;
            }
        }
        if(AccountsManager.admins != null){
            for(Account account: AccountsManager.admins) {
                if (helperForSearchGuyNotFound(account, attribute, type))
                    return false;
            }
        }
        return true;
    }
    private static boolean helperForSearchGuyNotFound(Account acc, String attribute, String type) {
        switch (type) {
            case "username":
                return acc.getUsername() != null && acc.getUsername().equals(attribute);
            case "email":
                return acc.getEmail() != null && acc.getEmail().equals(attribute);
            case "phone":
                return acc.getPhone() != null && acc.getPhone().equals(attribute);
            case "ID":
                return acc.getID() != null && acc.getID().equals(attribute);
            default:
                return false;
        }
    }


    public static Account getSession() {
        return session;
    }
}
