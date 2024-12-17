package com.example.foodordersystem.Accounts;

import com.example.foodordersystem.Restaurant.Restaurant;

import java.util.List;

public class Admin extends Account implements DashBoard {
    private Restaurant restaurant;
    private ReportGenerator reports;
    public Admin(String name, String username, String password, String email, String phone, String address) {
        super(name,username,password,email,phone,address);
        reports = new ReportGenerator(getID());
    }
    public boolean Login(String username, String password) {
        Admin foundAdmin = AccountsManager.authSearchAdmins(username, password);
        if (foundAdmin!=null){
            AccountsManager.setSession(foundAdmin);
            return true;
        }
        return false;
    }

    @Override
    public List<Double> getDailyNetProfit() {
        return reports.getDailyNetProfit();
    }

    @Override
    public List<Double> getMonthlyNetProfit() {
        return reports.getMonthlyNetProfit();
    }

    @Override
    public List<Double> getYearlyNetProfit() {
        return reports.getYearlyNetProfit();
    }

    @Override
    public List<Double> getDailyGrossProfit() {
        return reports.getDailyGrossProfit();
    }

    @Override
    public List<Double> getMonthlyGrossProfit() {
        return reports.getMonthlyGrossProfit();
    }

    @Override
    public List<Double> getYearlyGrossProfit() {
        return reports.getYearlyGrossProfit();
    }

    @Override
    public List<Double> getDailyNetAverage() {
        return reports.getDailyNetAverage();
    }

    @Override
    public List<Double> getMonthlyNetAverage() {
        return reports.getMonthlyNetAverage();
    }

    @Override
    public List<Double> getYearlyNetAverage() {
        return reports.getYearlyNetAverage();
    }

    @Override
    public List<Double> getDailyGrossAverage() {
        return reports.getDailyGrossAverage();
    }

    @Override
    public List<Double> getMonthlyGrossAverage() {
        return reports.getMonthlyGrossAverage();
    }

    @Override
    public List<Double> getYearlyGrossAverage() {
        return reports.getYearlyGrossAverage();
    }

    @Override
    public double getTotalNetProfit() {
        return reports.getTotalNetProfit();
    }

    @Override
    public double getTotalGrossProfit() {
        return reports.getTotalGrossProfit();
    }

    @Override
    public double getAverageNetProfit() {
        return reports.getAverageNetProfit();
    }

    @Override
    public double getAverageGrossProfit() {
        return reports.getAverageGrossProfit();
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
//   public boolean Register(String name, String username, String password, String email, String phone, String address) {
//        if (AccountsManager.SearchGuyNotFound(username, "username") && AccountsManager.SearchGuyNotFound(email, "email") && AccountsManager.SearchGuyNotFound(phone, "phone")) {
//            AccountsManager.AddAdmin(name, username, password, email, phone, address);
//            return true;
//        }
//        return false;
//    }
}

