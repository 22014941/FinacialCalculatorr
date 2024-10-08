Input their monthly gross income and expenses.
Select whether they want to rent or buy a property and calculate the related costs.
Decide if they want to purchase a car with cash or through a loan, or if they prefer other transport options.
Calculate remaining income after handling all expenses.
Here’s an overview of the structure and features:

Features:
Income and Expense Input:

The user inputs their gross monthly income and various living costs (groceries, utilities, travel, etc.).
Tax Calculation:

Based on the user's income range, taxes are calculated and deducted from the gross income using predefined percentages for different income brackets.
Accommodation:

The user chooses whether to rent or buy a property.
If renting, the monthly rental amount is input.
If buying, the program calculates the monthly mortgage payment based on the property price, deposit, interest rate, and repayment period.
Vehicle Purchase:

The user decides whether to buy a car and selects a payment method (cash or contract).
If purchasing via a contract, the loan repayment and insurance premiums are calculated.
Remaining Income Calculation:

The remaining income after expenses, accommodation costs, and transport or car-related costs are displayed.
Key Methods:
getValidDoubleInput(): Ensures valid numeric input for expenses, income, etc.
getValidIntInput(): Ensures valid input for integers within a specific range.
getValidChoice(): Ensures the user selects between two valid options (e.g., rent/buy or yes/no).
getStringInput(): Handles simple string input, such as car model or brand names.
Suggestions for Improvement:
Error Handling: Improve the catch blocks by offering more specific feedback about invalid entries, e.g., catching InputMismatchException explicitly.
Financial Calculations: Ensure that the monthly expense and savings after each section (accommodation, transport) are consistently computed based on the correct tax bracket used for final calculations.
Would you like help with adding more features or testing specific aspects of this project?
