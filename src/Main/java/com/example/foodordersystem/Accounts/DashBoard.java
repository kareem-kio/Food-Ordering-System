package com.example.foodordersystem.Accounts;

import java.util.List;

public interface DashBoard {
    // all dishes
    public List<Double> getDailyNetProfit();
    public List<Double> getMonthlyNetProfit();
    public List<Double> getYearlyNetProfit();
    public List<Double> getDailyGrossProfit();
    public List<Double> getMonthlyGrossProfit();
    public List<Double> getYearlyGrossProfit();
    public List<Double> getDailyNetAverage();
    public List<Double> getMonthlyNetAverage();
    public List<Double> getYearlyNetAverage();
    public List<Double> getDailyGrossAverage();
    public List<Double> getMonthlyGrossAverage();
    public List<Double> getYearlyGrossAverage();
    public double getTotalNetProfit();
    public double getTotalGrossProfit();
    public double getAverageNetProfit();
    public double getAverageGrossProfit();
    // single-Dish

}
