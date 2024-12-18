package com.example.foodordersystem.PaymentSystem;

import java.util.Date;

public class OrderTracker {
    private Date startDate;
    private Date endDate;
    private String orderID;
    private String orderStatus;
    public OrderTracker(Date startDate, Date endDate, String orderID, String orderStatus){
        this.startDate = startDate;
        this.endDate = endDate;
        this.orderID = orderID;
        this.orderStatus = orderStatus;
    }
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public String getOrderID() {
        return orderID;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void updateOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    public void DisplayOrderTracker(){
        System.out.printf("Order ID: %s\n" +
                "Order Status: %s\n" +
                "Placing order time: %s\n" +
                "Estimated Delivery time: %s\n",orderID,orderStatus,startDate,endDate);
    }

    // a status determination based on time going on between startdate and enddate
// these statuses are: "Order confirmed", "Preparing order", "On delivery", "Order is here"
    
    public void updateOrderStatus() {
        Date currentTime = new Date(); // Get the current time
        long totalDuration = endDate.getTime() - startDate.getTime(); // Calculate the total duration of the order (endDate - startDate)
        long elapsedDuration = currentTime.getTime() - startDate.getTime(); // Calculate the elapsed duration since the order started (currentTime - startDate)
    
        // If the elapsed duration is less than or equal to 0, the order is just confirmed
        if (elapsedDuration <= 0) {
            this.orderStatus = "Order confirmed";
        }
        // If the elapsed duration is within the first third of the total duration, the order is being prepared
        else if (elapsedDuration <= totalDuration / 3) {
            this.orderStatus = "Preparing order";
        }
        // If the elapsed duration is between one-third and two-thirds of the total duration, the order is on delivery
        else if (elapsedDuration <= (2 * totalDuration) / 3) {
            this.orderStatus = "On delivery";
        }
        // If the elapsed duration is within the last third of the total duration, the order has arrived
        else if (elapsedDuration <= totalDuration) {
            this.orderStatus = "Order is here";
        }
        // If the elapsed duration exceeds the total duration, the delivery is complete
        else {
            this.orderStatus = "Delivered";
        }
    }
    
    
    

}
