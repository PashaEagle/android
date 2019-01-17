package com.kolesn.pasha.oop;

import java.io.Serializable;

public class SavedOrder extends Order implements Serializable {
    private String purchaseDeadline;

    public SavedOrder(String purchaseDeadline) {
        this.purchaseDeadline = purchaseDeadline;
    }

    public SavedOrder(String name, String purchaseDeadline) {
        super(name);
        this.purchaseDeadline = purchaseDeadline;
    }

    public SavedOrder(String name, String address, String purchaseDeadline) {
        super(name, address);
        this.purchaseDeadline = purchaseDeadline;
    }

    public SavedOrder(String name, String address, Double price, String purchaseDeadline) {
        super(name, address, price);
        this.purchaseDeadline = purchaseDeadline;
    }

    public SavedOrder(String name, String address, Double price, Integer amount, String purchaseDeadline) {
        super(name, address, price, amount);
        this.purchaseDeadline = purchaseDeadline;
    }

    public SavedOrder(String name, String address, Double price, Integer amount, String orderDate, String purchaseDeadline) {
        super(name, address, price, amount, orderDate);
        this.purchaseDeadline = purchaseDeadline;
    }

    public String getPurchaseDeadline() {
        return purchaseDeadline;
    }

    public void setPurchaseDeadline(String purchaseDeadline) {
        this.purchaseDeadline = purchaseDeadline;
    }
}
