package com.example.foodordersystem.Accounts;

import java.util.Random;

public abstract class Account {
    // access modifiers are modified
    private String ID;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    public Account(String name, String username, String password, String email, String phone, String address){
        this.name = name;
        setID();
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setPhone(phone);
        this.address = address;
    }
    public boolean Register(String name, String username, String password, String email, String phone, String address)
    {
        if (AccountsManager.SearchGuyNotFound(username, "username")){
          //  AccountsManager.AddUser(name, username, password, email, phone, address);
            return true;
        }
        return false;
    }
    public abstract boolean Login(String username, String password);
    // getters

    public String getID() {
        return ID;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public String getName()
    {
        return name;
    }

    // Setters
    public void setID() {
        while(true){
            String ID = String.format("%04d", new Random().nextInt(10000));
            if(AccountsManager.SearchGuyNotFound(ID , "ID")){
                this.ID = ID;
                break;
            }
        }
    }
    public void setUsername(String username)
    {
        if(AccountsManager.SearchGuyNotFound(username, "username")) //ERROR IS HERE
            this.username = username;
    }
    // for entering old password authentication
    // gui :
    // old password:
    // new password:
    // retype new password:
    public boolean ChangePassword(String oldPassword, String newPassword, String confirmPassword) {
        if(oldPassword.equals(this.password) && newPassword.equals(confirmPassword) &&
                newPassword.length() >= 8)
        {
            this.password = newPassword;
            return true;
        }
        return false;
    }
    public void setPassword(String password) {
        if(password.length() >= 8)
            this.password = password;
    }
    public void setEmail(String email) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if(email.matches(regexPattern) && AccountsManager.SearchGuyNotFound(email, "email")) //ERROR IS HERE
            this.email = email;
    }
    public void setPhone(String phone) {
        String regexPattern = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$";
        if(phone.matches(regexPattern) && AccountsManager.SearchGuyNotFound(phone, "phone")) //ERROR IS HERE
            this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

}
