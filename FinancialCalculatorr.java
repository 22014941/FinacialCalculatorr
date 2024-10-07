
package com.mycompany.finacialcalculatorr;

/**
 *
 * @groupk 
 */
import java.util.*;

public class FinancialCalculatorr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseWarning warning = new ExpenseNotifier();
        List<Expense> expenses = new ArrayList<>(); 
        
        System.out.println("Enter your gross monthly income(after tax):");
        double grossIncome = scanner.nextDouble();
        
        expenses.add(new GeneralExpense("Groceries", promptForExpense(scanner, "Groceries")));
        expenses.add(new GeneralExpense("Water and Lights", promptForExpense(scanner, "Water and Lights")));
        expenses.add(new GeneralExpense("Travel costs", promptForExpense(scanner, "Travel costs")));
        expenses.add(new GeneralExpense("Cell phone and telephone", promptForExpense(scanner, "Cell phone and telephone")));
        expenses.add(new GeneralExpense("Other expenses", promptForExpense(scanner, "Other expenses")));

       
        System.out.println("Do you want to rent or buy property? (Enter 1 for Rent, 2 for Buy)");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Enter the monthly rental amount:");
            double rent = scanner.nextDouble();
            expenses.add(new GeneralExpense("Rent", rent));
        } else if (choice == 2) {
            HomeLoan homeLoan = getHomeLoanDetails(scanner);
            expenses.add(homeLoan);
            if (homeLoan.calculateExpense() > grossIncome / 3) {
                System.out.println("Warning: Home loan repayment is more than a third of your income. Approval is unlikely.");
            }
        }

     
        System.out.println("Do you want to buy a vehicle? (yes/no)");
        String buyVehicle = scanner.next();
        if (buyVehicle.equalsIgnoreCase("yes")) {
            VehicleLoan vehicleLoan = getVehicleDetails(scanner);
            expenses.add(vehicleLoan);
        }


        double totalExpenses = calculateTotalExpenses(expenses);
        warning.notifyUser(totalExpenses, grossIncome);

        
        expenses.sort(Comparator.comparingDouble(Expense::calculateExpense).reversed());
        System.out.println("Expenses in descending order:");
        for (Expense expense : expenses) {
            System.out.println(expense.name + ": " + expense.calculateExpense());
        }

      
        
        double availableMoney = grossIncome - totalExpenses;
        System.out.println("Your available monthly money after deductions is: " + availableMoney);

        scanner.close();
    }

  
    public static double promptForExpense(Scanner scanner, String expenseName) {
        System.out.println("Enter estimated monthly " + expenseName + " expense:");
        return scanner.nextDouble();
    }

    // Method to get home loan details from the user
    public static HomeLoan getHomeLoanDetails(Scanner scanner) {
        System.out.println("Enter the purchase price of the property:");
        double purchasePrice = scanner.nextDouble();
        
        System.out.println("Enter the total deposit:");
        double deposit = scanner.nextDouble();
        
        System.out.println("Enter the interest rate:");
        double interestRate = scanner.nextDouble();
        
        System.out.println("Enter the number of months to repay (between 240 and 360):");
        int months = scanner.nextInt();
        
        return new HomeLoan(purchasePrice, deposit, interestRate, months);
    }

   
    public static VehicleLoan getVehicleDetails(Scanner scanner) {
        System.out.println("Enter vehicle model and make:");
        String model = scanner.next();
        
        System.out.println("Enter vehicle purchase price:");
        double purchasePrice = scanner.nextDouble();
        
        System.out.println("Enter total deposit:");
        double deposit = scanner.nextDouble();
        
        System.out.println("Enter interest rate:");
        double interestRate = scanner.nextDouble();
        
        System.out.println("Enter estimated insurance premium:");
        double insurancePremium = scanner.nextDouble();
        
        return new VehicleLoan(model, purchasePrice, deposit, interestRate, insurancePremium);
    }

    
    public static double calculateTotalExpenses(List<Expense> expenses) {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.calculateExpense();
        }
        return total;
    }
}
