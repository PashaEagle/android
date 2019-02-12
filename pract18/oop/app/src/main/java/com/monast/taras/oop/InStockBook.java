package com.monast.taras.oop;

import java.io.Serializable;

public class InStockBook extends Book implements Serializable {
    private Integer amount; //Додаткове поле яке присутнє в усіх книжок InStockBook, але я його не відображаю

    public InStockBook(Integer amount) {
        this.amount = amount;
    }

    public InStockBook(String name, Integer amount) {
        super(name);
        this.amount = amount;
    }

    public InStockBook(String name, String author, Integer year) {
        super(name, author);
        this.amount = year;
    }

    public InStockBook(String name, String author, Double pages, Integer year) {
        super(name, author, pages);
        this.amount = year;
    }

    public InStockBook(String name, String author, Double pages, Integer year, Integer amount) {
        super(name, author, pages, year);
        this.amount = amount;
    }

    public InStockBook(String name, String author, Double pages, Integer year, String state, Integer amount) {
        super(name, author, pages, year, state);
        this.amount = amount;
    }

    @Override
    public Double getPages() {
        return pages + amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
