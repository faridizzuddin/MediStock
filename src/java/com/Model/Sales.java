package com.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nafiesa
 */


public class Sales {
    private int salesId;
    private String productName;
    private int quantity;
    private double price;
    private String date;

    public Sales () {}
    
    public Sales(int salesId, String productName, int quantity, double price, String date) {
        this.salesId = salesId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    // Getters and setters for each field
    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
}

