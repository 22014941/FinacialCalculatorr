/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finacialcalculatorr;

/**
 *
 * @author USER
 */
// Abstract class for all expenses
abstract class Expense {
    protected String name;
    protected double amount;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public abstract double calculateExpense();
}

// Class for general expenses like groceries, rent, etc.
class GeneralExpense extends Expense {
    public GeneralExpense(String name, double amount) {
        super(name, amount);
    }

    @Override
    public double calculateExpense() {
        return amount;
    }
}

// Class for home loan calculations
class HomeLoan extends Expense {
    private double purchasePrice;
    private double deposit;
    private double interestRate;
    private int monthsToRepay;

    public HomeLoan(double purchasePrice, double deposit, double interestRate, int monthsToRepay) {
        super("Home Loan", 0);
        this.purchasePrice = purchasePrice;
        this.deposit = deposit;
        this.interestRate = interestRate;
        this.monthsToRepay = monthsToRepay;
    }

    @Override
    public double calculateExpense() {
        double loanAmount = purchasePrice - deposit;
        double monthlyInterestRate = (interestRate / 100) / 12;
        return loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -monthsToRepay));
    }
}

// Class for vehicle loan calculations
class VehicleLoan extends Expense {
    private double purchasePrice;
    private double deposit;
    private double interestRate;
    private double insurancePremium;
    private final int loanTermMonths = 60; // 5 years

    public VehicleLoan(String model, double purchasePrice, double deposit, double interestRate, double insurancePremium) {
        super("Vehicle Loan", 0);
        this.purchasePrice = purchasePrice;
        this.deposit = deposit;
        this.interestRate = interestRate;
        this.insurancePremium = insurancePremium;
    }

    @Override
    public double calculateExpense() {
        double loanAmount = purchasePrice - deposit;
        double monthlyInterestRate = (interestRate / 100) / 12;
        double monthlyRepayment = loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -loanTermMonths));
        return monthlyRepayment + insurancePremium;
    }
}

// Interface for notifying the user about expense warnings
interface ExpenseWarning {
    void notifyUser(double totalExpenses, double income);
}

// Class to handle expense warnings when total exceeds 75% of income
class ExpenseNotifier implements ExpenseWarning {
    @Override
    public void notifyUser(double totalExpenses, double income) {
        if (totalExpenses > income * 0.75) {
            System.out.println("Warning: Your total expenses exceed 75% of your income!");
        }
    }
}
