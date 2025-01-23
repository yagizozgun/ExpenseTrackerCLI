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
                double amount = Double.parseDouble(args[args.length - 1]);
                expenseManager.addExpense(description, amount);
                break;

            case "list":
                System.out.println(expenseManager.getExpenses());
                break;

            case "summary":
                if (args.length == 1) {
                    System.out.println("Total expenses: " + expenseManager.getSummary());
                }
                else {
                    System.out.println("Total expenses for " + expenseManager.getMonth(Integer.parseInt(args[1])) + ": " + expenseManager.getSummary(Integer.parseInt(args[1])));
                }
                break;

            case "delete":
                expenseManager.deleteExpense(Integer.parseInt(args[1]));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + args[0]);
        }
    }
}