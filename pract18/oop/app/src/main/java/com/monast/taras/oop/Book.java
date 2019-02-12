package com.monast.taras.oop;

import java.io.Serializable;

public abstract class Book implements Serializable { //Головний абстрактний клас, на основі нього ше два: GivedBook і InStockBook
    //Поля
    protected String name;
    protected String author;
    protected Double pages;
    protected Integer year;
    protected String state;

    //Конструктори
    public Book(){}
    public Book(String name){this.name = name;}
    public Book(String name, String author){this.name = name; this.author = author;}
    public Book(String name, String author, Double pages){this.name = name; this.author = author; this.pages = pages;}
    public Book(String name, String author, Double pages, Integer year){this.name = name; this.author = author; this.pages = pages; this.year = year;}
    public Book(String name, String author, Double pages, Integer year, String state){this.name = name; this.author = author; this.pages = pages; this.year = year; this.state = state;}

    //Геттери, сеттери полів
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPages() {
        return pages;
    }

    public Integer getYear() {
        return year;
    }

    public String getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(Double pages) {
        this.pages = pages;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setState(String state) {
        this.state = state;
    }

}
