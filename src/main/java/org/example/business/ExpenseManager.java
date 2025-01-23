package org.example.business;

import org.example.model.Expense;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ExpenseManager {

    ExpenseUtil expenseUtil = new ExpenseUtil();
    File expenseFile = new File("expenses.json");

    public void addExpense(String description, double amount)
    {
        try
        {
            List<Expense> expenseList = expenseUtil.getExpenseList(expenseFile);
            Expense expense = new Expense(description, amount);
            if (!expenseList.isEmpty())
            {
                expense.setId(expenseUtil.getLastId(expenseList)+1);
            }
            expenseList.add(expense);
            expenseUtil.writeExpenseList(expenseFile, expenseList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Expense> getExpenses()
    {
        try
        {
            return expenseUtil.getExpenseList(expenseFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double getSummary()
    {
        double total = 0;
        try
        {
            List<Expense> expenseList = expenseUtil.getExpenseList(expenseFile);
            for (Expense expense : expenseList)
            {
                total += expense.getAmount();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return total;
    }

    public double getSummary(int month)
    {
        double total = 0;
        try {
            List<Expense> expenseList = expenseUtil.getExpenseList(expenseFile);
            for (Expense expense : expenseList) {
                if (Objects.equals(expense.getDate().getMonth().getValue(), month)) { // hangi ay oldugunu almam gerek
                    total += expense.getAmount();
                }
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return total;
    }

    public String getMonth(int month) {
        try {
            List<Expense> expenseList = expenseUtil.getExpenseList(expenseFile);

            for (Expense expense : expenseList) {
                if (expense.getDate().getMonthValue() == month) { // Ay değeri eşit mi?
                    return expense.getDate().getMonth().toString(); // Ay ismini döndür
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void deleteExpense(int id)
    {
        try
        {
            List<Expense> expenseList = expenseUtil.getExpenseList(expenseFile);
            if (id > 0) {
                expenseList.remove(id-1);
                expenseUtil.writeExpenseList(expenseFile, expenseList);
            }
            else {
                System.out.println("Gecersiz ID!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
