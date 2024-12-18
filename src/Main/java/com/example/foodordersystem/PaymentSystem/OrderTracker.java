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

}
