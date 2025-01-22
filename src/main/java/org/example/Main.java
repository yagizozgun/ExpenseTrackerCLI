package org.example;

import org.example.business.ExpenseManager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ExpenseManager expenseManager = new ExpenseManager();

        switch (args[0])
        {
            case "add":
                String description = String.join(" ", Arrays.copyOfRange(args, 1, args.length-1));
                expenseManager.addExpense(description, Double.parseDouble(args[2]));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + args[0]);
        }
    }
}