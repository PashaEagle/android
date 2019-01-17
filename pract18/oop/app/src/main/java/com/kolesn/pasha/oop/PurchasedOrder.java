package com.kolesn.pasha.oop;

import java.io.Serializable;

public class PurchasedOrder extends Order implements Serializable {
    private Integer deliveryPrice;

    public PurchasedOrder(Integer deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public PurchasedOrder(String name, Integer deliveryPrice) {
        super(name);
        this.deliveryPrice = deliveryPrice;
    }

    public PurchasedOrder(String name, String address, Integer deliveryPrice) {
        super(name, address);
        this.deliveryPrice = deliveryPrice;
    }

    public PurchasedOrder(String name, String address, Double price, Integer deliveryPrice) {
        super(name, address, price);
        this.deliveryPrice = deliveryPrice;
    }

    public PurchasedOrder(String name, String address, Double price, Integer amount, Integer deliveryPrice) {
        super(name, address, price, amount);
        this.deliveryPrice = deliveryPrice;
    }

    public PurchasedOrder(String name, String address, Double price, Integer amount, String orderDate, Integer deliveryPrice) {
        super(name, address, price, amount, orderDate);
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public Double getPrice() {
        return price + deliveryPrice;
    }

    public Integer getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Integer deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }
}
