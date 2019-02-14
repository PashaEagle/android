package com.eagles.ira.factory;

import java.io.Serializable;

public abstract class Worker implements Serializable { //Головний абстрактний клас, на основі нього ше два: AbsentWorker і PresentWorker
    //Поля
    protected String name;
    protected String position;
    protected Double number;
    protected Integer department;
    protected Boolean isPresent;
    protected String date;

    //Конструктори
    public Worker(){}
    public Worker(String name){this.name = name;}
    public Worker(String name, String position){this.name = name; this.position = position;}
    public Worker(String name, String position, Double number){this.name = name; this.position = position; this.number = number;}
    public Worker(String name, String position, Double number, Integer department){this.name = name; this.position = position; this.number = number; this.department = department;}
    public Worker(String name, String position, Double number, Integer department, String date){this.name = name; this.position = position; this.number = number; this.department = department; this.date = date;}
    public Worker(String name, String position, Double number, Integer department, Boolean isPresent, String date){this.name = name; this.position = position; this.number = number; this.department = department; this.isPresent = isPresent; this.date = date;}

    //Геттери, сеттери полів
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Double getNumber() {
        return number;
    }

    public Integer getDepartment() {
        return department;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPresent() { return isPresent; }

    public void setPresent(Boolean present) { isPresent = present; }

}
