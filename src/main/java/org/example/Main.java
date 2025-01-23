package org.example;

import org.example.business.ExpenseManager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ExpenseManager expenseManager = new ExpenseManager();

        switch (args[0]) {
            case "add":
                try {
                    if (args.length < 3) {
                        throw new IllegalArgumentException("Usage: add <description> <amount>");
                    }
                    String description = String.join(" ", Arrays.copyOfRange(args, 1, args.length - 1));
                    double amount = Double.parseDouble(args[args.length - 1]);
                    if (amount <= 0) {
                        throw new IllegalArgumentException("Amount must be greater than zero.");
                    }
                    expenseManager.addExpense(description, amount);
                    System.out.println("Expense added successfully.");
                } catch (NumberFormatException e) {
                    System.err.println("Error: Amount must be a valid number.");
                } catch (IllegalArgumentException e) {
                    System.err.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                }
                break;

            case "list":
                try {
                    System.out.println(expenseManager.getExpenses());
                } catch (Exception e) {
                    System.err.println("An error occurred while listing expenses: " + e.getMessage());
                }
                break;

            case "summary":
                try {
                    if (args.length == 1) {
                        System.out.println("Total expenses: " + expenseManager.getSummary());
                    } else {
                        int month = Integer.parseInt(args[1]);
                        if (month < 1 || month > 12) {
                            throw new IllegalArgumentException("Month must be between 1 and 12.");
                        }
                        System.out.println("Total expenses for " + expenseManager.getMonth(month) + ": " + expenseManager.getSummary(month));
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error: Month must be a valid number.");
                } catch (IllegalArgumentException e) {
                    System.err.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                }
                break;

            case "delete":
                try {
                    if (args.length != 2) {
                        throw new IllegalArgumentException("Usage: delete <id>");
                    }
                    int id = Integer.parseInt(args[1]);
                    expenseManager.deleteExpense(id);
                    System.out.println("Expense deleted successfully.");
                } catch (NumberFormatException e) {
                    System.err.println("Error: ID must be a valid number.");
                } catch (IllegalArgumentException e) {
                    System.err.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                }
                break;

            default:
                System.err.println("Error: Unexpected command '" + args[0] + "'. Available commands: add, list, summary, delete.");
        }
    }
}