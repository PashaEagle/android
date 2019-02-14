package com.eagles.ira.factory;

import java.io.Serializable;

public class PresentWorker extends Worker implements Serializable {

    public PresentWorker(String name, String position) {
        super(name, position);
    }

    public PresentWorker(String name, String position, Double number) {
        super(name, position, number);
    }

    public PresentWorker(String name, String position, Double number, Integer department) {
        super(name, position, number, department);
    }

    public PresentWorker(String name, String position, Double number, Integer department, String date) {
        super(name, position, number, department, date);
    }

    public PresentWorker(String name, String position, Double number, Integer department, Boolean isPresent, String date) {
        super(name, position, number, department, isPresent, date);
    }

}
