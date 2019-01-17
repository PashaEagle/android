package com.kolesn.pasha.oop;

import java.io.Serializable;

public abstract class Order implements Serializable {
    protected String name;
    protected String address;
    protected Double price;
    protected Integer amount;
    protected String orderDate;

    public Order(){}
    public Order(String name){this.name = name;}
    public Order(String name, String address){this.name = name; this.address = address;}
    public Order(String name, String address, Double price){this.name = name; this.address = address; this.price = price;}
    public Order(String name, String address, Double price, Integer amount){this.name = name; this.address = address; this.price = price; this.amount = amount;}
    public Order(String name, String address, Double price, Integer amount, String orderDate){this.name = name; this.address = address; this.price = price; this.amount = amount; this.orderDate = orderDate;}

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}
