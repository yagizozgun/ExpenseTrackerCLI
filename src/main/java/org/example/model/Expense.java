package org.example.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {
    private int id = 1;
    private String date;
    private String description;
    private double amount;

    public Expense() {};

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date = LocalDate.now().format(formatter);
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
        this.date = date;
    }

    public String getDate()
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
