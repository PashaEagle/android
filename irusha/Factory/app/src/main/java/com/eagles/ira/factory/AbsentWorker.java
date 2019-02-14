package com.eagles.ira.factory;

import java.io.Serializable;

public class AbsentWorker extends Worker implements Serializable {


    public AbsentWorker(String name) {
        super(name);
    }

    public AbsentWorker(String name, String position) {
        super(name, position);
    }

    public AbsentWorker(String name, String position, Double number) {
        super(name, position, number);
    }

    public AbsentWorker(String name, String position, Double number, Integer department) {
        super(name, position, number, department);
    }

    public AbsentWorker(String name, String position, Double number, Integer department, String date) {
        super(name, position, number, department, date);
    }

    public AbsentWorker(String name, String position, Double number, Integer department, Boolean isPresent,  String date) {
        super(name, position, number, department, isPresent, date);
    }
}
