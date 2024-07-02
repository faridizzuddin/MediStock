/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Model;

/**
 *
 * @author aqila
 */

public class Order {
    private int orderId;
    private int custId;
    private String orderDate;
    private double totalAmount;
    private String productName;

    public Order(){}
    // Constructor for inserting a new order
    public Order(int custId, String orderDate, double totalAmount, String productName) {
        this.custId = custId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.productName = productName;
    }

    // Constructor for updating an existing order
    public Order(int orderId, int custId, String orderDate, double totalAmount, String productName) {
        this.orderId = orderId;
        this.custId = custId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.productName = productName;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

