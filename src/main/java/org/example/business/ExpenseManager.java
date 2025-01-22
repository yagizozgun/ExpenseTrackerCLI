package org.example.business;

import org.example.model.Expense;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExpenseManager {

    ExpenseUtil expenseUtil = new ExpenseUtil();
    File expenseFile = new File("expenses.json");

    public void addExpense(String description, double amount)
    {
        try
        {
            List<Expense> expenseList = expenseUtil.getExpenseList(expenseFile);
            Expense expense = new Expense(description, amount);
            if (expenseList.size() > 1)
            {
                expense.setId(expenseUtil.getLastId(expenseList)+1);
            }
            expenseList.add(expense);
            expenseUtil.writeExpenseList(expenseFile, expenseList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
