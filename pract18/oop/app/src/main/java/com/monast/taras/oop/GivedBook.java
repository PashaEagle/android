package com.monast.taras.oop;

import java.io.Serializable;

public class GivedBook extends Book implements Serializable {
    private String deadline; //Додаткове поле яке присутнє в усіх книжок GivedBook, але я його не відображаю

    public GivedBook(String deadline) {
        this.deadline = deadline;
    }

    public GivedBook(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    public GivedBook(String name, String author, String deadline) {
        super(name, author);
        this.deadline = deadline;
    }

    public GivedBook(String name, String author, Double pages, String deadline) {
        super(name, author, pages);
        this.deadline = deadline;
    }

    public GivedBook(String name, String author, Double pages, Integer year, String deadline) {
        super(name, author, pages, year);
        this.deadline = deadline;
    }

    public GivedBook(String name, String author, Double pages, Integer year, String state, String deadline) {
        super(name, author, pages, year, state);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
