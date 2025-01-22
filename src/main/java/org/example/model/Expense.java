package org.example.model;

import java.util.Date;

public class Expense {
    private int id = 1;
    private long date;
    private String description;
    private double amount;

    public Expense() {};

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.date =new Date().getTime();
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getDate()
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
