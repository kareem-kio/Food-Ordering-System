package com.example.foodordersystem.Accounts;

import com.example.foodordersystem.Restaurant.Restaurant;
import com.example.foodordersystem.Restaurant.Dish;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator implements DashBoard {
    private String AdminID;
    private Restaurant restaurant;
    public ReportGenerator(String AdminID) {
       this.AdminID = AdminID;
       restaurant = AccountsManager.getAdmins().stream()
               .filter(admin -> admin.getID().equals(AdminID))
               .findFirst().get().getRestaurant();
    }
    @Override
    public List<Double> getDailyNetProfit() {
        ArrayList<Double> result = new ArrayList<>();
        LocalDate day;
        double profit = 0;
        if(restaurant == null)
            return List.of();
        for(LocalDate d : restaurant.getDay())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer sold = dish.getSoldDaily(d);
                if(sold != null)
                    profit +=  (dish.getPrice()*sold) - (dish.getCost()*sold);
            }
            result.add(profit);
            profit = 0;
        }
        return result;
    }

    @Override
    public List<Double> getMonthlyNetProfit() {
        ArrayList<Double> result = new ArrayList<>();
        double profit = 0;
        if(restaurant == null)
            return List.of();
        for(YearMonth d : restaurant.getMonths())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer sold = dish.getSoldMonthly(d);
                if(sold != null)
                    profit +=  (dish.getPrice()*sold) - (dish.getCost()*sold);
            }
            result.add(profit);
            profit = 0;
        }
        return result;
    }

    @Override
    public List<Double> getYearlyNetProfit() {
        ArrayList<Double> result = new ArrayList<>();
        double profit = 0;
        if(restaurant == null)
            return List.of();
        for(Integer d : restaurant.getYear())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer sold = dish.getSoldYearly(d);
                if(sold != null)
                    profit +=  (dish.getPrice()*sold) - (dish.getCost()*sold);
            }
            result.add(profit);
            profit = 0;
        }
        return result;
    }

    @Override
    public List<Double> getDailyGrossProfit() {
        ArrayList<Double> result = new ArrayList<>();
        double profit = 0;
        if(restaurant == null)
            return List.of();
        for(LocalDate d : restaurant.getDay())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer sold = dish.getSoldDaily(d);
                if(sold != null)
                    profit +=  (dish.getPrice()*sold);
            }
            result.add(profit);
            profit = 0;
        }
        return result;
    }

    @Override
    public List<Double> getMonthlyGrossProfit() {
        ArrayList<Double> result = new ArrayList<>();
        double profit = 0;
        if(restaurant == null)
            return List.of();
        for(YearMonth d : restaurant.getMonths())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer sold = dish.getSoldMonthly(d);
                if(sold != null)
                    profit +=  (dish.getPrice()*sold) - (dish.getCost()*sold);
            }
            result.add(profit);
            profit = 0;
        }
        return result;
    }

    @Override
    public List<Double> getYearlyGrossProfit() {
        ArrayList<Double> result = new ArrayList<>();
        double profit = 0;
        if(restaurant == null)
            return List.of();
        for(Integer d : restaurant.getYear())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer sold = dish.getSoldYearly(d);
                if(sold != null)
                    profit +=  (dish.getPrice()*sold);
            }
            result.add(profit);
            profit = 0;
        }
        return result;
    }

    @Override
    public List<Double> getDailyNetAverage() {
        ArrayList<Double> result = new ArrayList<>(getDailyNetProfit());
        ArrayList<Integer> solds = new ArrayList<>();
        ArrayList<Double> avgProfits = new ArrayList<>();
        Integer sold = 0;
        LocalDate day;
        double profit = 0;
        if(restaurant == null)
            return List.of();
        // in everyday , no. of dishes sold
        for(LocalDate d : restaurant.getDay())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer s = dish.getSoldDaily(d);
                if(s!= null)
                    sold += s;
            }
            solds.add(sold);
            sold = 0;
        }
        for(int i = 0; i < solds.size(); i++)
        {
            if(solds.get(i) != 0 && solds.get(i) != null)
            {
                 avgProfits.add(result.get(i)/solds.get(i));
            }
            else
            {
                avgProfits.add(0.0);
            }
        }
        return avgProfits;
    }

    @Override
    public List<Double> getMonthlyNetAverage() {
        ArrayList<Double> result = new ArrayList<>(getMonthlyNetProfit());
        ArrayList<Integer> solds = new ArrayList<>();
        ArrayList<Double> avgProfits = new ArrayList<>();
        Integer sold = 0;
        LocalDate day;
        double profit = 0;
        if(restaurant == null)
            return List.of();
        // in everyday , no. of dishes sold
        for(YearMonth d : restaurant.getMonths())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer s = dish.getSoldMonthly(d);
                if(s!= null)
                    sold += s;
            }
            solds.add(sold);
            sold = 0;
        }
        for(int i = 0; i < solds.size(); i++)
        {
            if(solds.get(i) != 0 && solds.get(i) != null)
            {
                avgProfits.add(result.get(i)/solds.get(i));
            }
            else
            {
                avgProfits.add(0.0);
            }
        }
        return avgProfits;
    }

    @Override
    public List<Double> getYearlyNetAverage() {
        ArrayList<Double> result = new ArrayList<>(getYearlyNetProfit());
        ArrayList<Integer> solds = new ArrayList<>();
        ArrayList<Double> avgProfits = new ArrayList<>();
        Integer sold = 0;
        LocalDate day;
        double profit = 0;
        if(restaurant == null)
            return List.of();
        // in everyday , no. of dishes sold
        for(Integer d : restaurant.getYear())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer s = dish.getSoldYearly(d);
                if(s!= null)
                    sold += s;
            }
            solds.add(sold);
            sold = 0;
        }
        for(int i = 0; i < solds.size(); i++)
        {
            if(solds.get(i) != 0 && solds.get(i) != null)
            {
                avgProfits.add(result.get(i)/solds.get(i));
            }
            else
            {
                avgProfits.add(0.0);
            }
        }
        return avgProfits;
    }

    @Override
    public List<Double> getDailyGrossAverage() {
        ArrayList<Double> result = new ArrayList<>(getDailyGrossProfit());
        ArrayList<Integer> solds = new ArrayList<>();
        ArrayList<Double> avgProfits = new ArrayList<>();
        Integer sold = 0;
        LocalDate day;
        double profit = 0;
        if(restaurant == null)
            return List.of();
        // in everyday , no. of dishes sold
        for(LocalDate d : restaurant.getDay())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer s = dish.getSoldDaily(d);
                if(s!= null)
                    sold += s;
            }
            solds.add(sold);
            sold = 0;
        }
        for(int i = 0; i < solds.size(); i++)
        {
            if(solds.get(i) != 0 && solds.get(i) != null)
            {
                avgProfits.add(result.get(i)/solds.get(i));
            }
            else
            {
                avgProfits.add(0.0);
            }
        }
        return avgProfits;
    }

    @Override
    public List<Double> getMonthlyGrossAverage() {
        ArrayList<Double> result = new ArrayList<>(getMonthlyGrossProfit());
        ArrayList<Integer> solds = new ArrayList<>();
        ArrayList<Double> avgProfits = new ArrayList<>();
        Integer sold = 0;
        LocalDate day;
        double profit = 0;
        if(restaurant == null)
            return List.of();
        // in everyday , no. of dishes sold
        for(YearMonth d : restaurant.getMonths())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer s = dish.getSoldMonthly(d);
                if(s!= null)
                    sold += s;
            }
            solds.add(sold);
            sold = 0;
        }
        for(int i = 0; i < solds.size(); i++)
        {
            if(solds.get(i) != 0 && solds.get(i) != null)
            {
                avgProfits.add(result.get(i)/solds.get(i));
            }
            else
            {
                avgProfits.add(0.0);
            }
        }
        return avgProfits;
    }

    @Override
    public List<Double> getYearlyGrossAverage() {
        ArrayList<Double> result = new ArrayList<>(getYearlyGrossProfit());
        ArrayList<Integer> solds = new ArrayList<>();
        ArrayList<Double> avgProfits = new ArrayList<>();
        Integer sold = 0;
        LocalDate day;
        double profit = 0;
        if(restaurant == null)
            return List.of();
        // in everyday , no. of dishes sold
        for(Integer d : restaurant.getYear())
        {
            for(Dish dish : restaurant.getDishes())
            {
                Integer s = dish.getSoldYearly(d);
                if(s!= null)
                    sold += s;
            }
            solds.add(sold);
            sold = 0;
        }
        for(int i = 0; i < solds.size(); i++)
        {
            if(solds.get(i) != 0 && solds.get(i) != null)
            {
                avgProfits.add(result.get(i)/solds.get(i));
            }
            else
            {
                avgProfits.add(0.0);
            }
        }
        return avgProfits;
    }

    @Override
    public double getTotalNetProfit() {
        double totalprofit = 0;
        List<Double> netProfit = getYearlyNetProfit();
        totalprofit = netProfit.stream().reduce(0.0, Double::sum);
        return totalprofit;
    }


    @Override
    public double getTotalGrossProfit() {
        double totalprofit = 0;
        List<Double> grossProfit = getYearlyGrossProfit();
        totalprofit = grossProfit.stream().reduce(0.0, Double::sum);
        return totalprofit;
    }

    // by day
    @Override
    public double getAverageNetProfit() {
       double avg = getTotalNetProfit();
       if(restaurant.getDay().isEmpty())
           return -1;
       avg = avg/restaurant.getDay().size();
       return avg;
    }

    @Override
    public double getAverageGrossProfit() {
        double avg = getTotalGrossProfit();
        if(restaurant.getDay().isEmpty())
            return -1;
        avg = avg/restaurant.getDay().size();
        return avg;
    }
}
