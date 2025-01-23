package org.example.model;

import java.time.LocalDate;

public class Expense {
    private int id = 1;
    private LocalDate date = LocalDate.now();
    private String description;
    private double amount;

    public Expense() {};

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount()
    {
        return amount;
    }
}
