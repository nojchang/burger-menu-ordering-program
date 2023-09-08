# Menu-Driven Burger Ordering System
This is menu-driven program for ordering burgers. It allows users to select burgers from a menu, specify quantities, calculate the bill, print the bill, and save the bill to a file. Below, you'll find instructions on how to use this program effectively.

## Program Overview

The program consists of two main classes: `Order` and `OrderBurger`, and an interface `OrderInterface`. Here's a brief overview of each class and their responsibilities:

### `Order` (Abstract Class)
- Serves as an abstract class providing a blueprint for different types of orders.
- Contains common attributes like prices, burger names, quantities, and total costs.
- Declares abstract methods for displaying the menu, getting user inputs, calculating costs, printing bills, and saving bills to a file.

### `OrderBurger` (Subclass of `Order`)
- Specializes in burger orders and overrides the abstract methods from the `Order` class.
- Gets user input for burger options and quantities, validates input, calculates the bill (including tax), prints a detailed bill, and saves the bill to a file.

### `OrderInterface` (Interface)
- Outlines methods that must be implemented by classes like `Order` and `OrderBurger`.
- Defines a constant for tax calculation and declares methods for displaying menus, getting inputs, calculating costs, printing bills, and saving bills to files.

## Instructions for Usage

1. Run the `Driver` class (`menuDrivenProgram.Driver`) as the entry point of the program.

2. You will be presented with the burger menu for students and staff. The menu will display burger options numbered from 1 to 5, along with their corresponding prices. You can enter the option number to order a burger.

3. To place an order, follow these steps:
   - Enter the option number of the burger you want (1-5).
   - Specify the quantity of that burger you'd like to order (must be a positive whole number).
   - Repeat the above two steps to add more items to your order.
   - If you want to exit the ordering process, enter `6` at any time.

4. After you've finished ordering, the program will ask whether you are a student (enter 'S' or 's' for student) or staff (enter any other key). The program will calculate the total cost of your order, including tax.

5. The program will then display a detailed bill, showing the items ordered, their quantities, and individual costs. It will also display the total before tax, the tax amount, and the total price after tax.

6. Finally, the program will save the bill to a text file named `bill.txt` in the same directory where the program is located. You'll receive a confirmation message once the bill has been saved.

7. If you initially enter `6` to exit the program before ordering, the program will terminate without further action.

**Note:**
- Make sure to enter valid input: option numbers between 1 and 5 for ordering burgers, positive whole numbers for quantities, and 'S'/'s' for student status.
- Tax is calculated at a rate of 9% for staff; students are exempt from tax.
- The program handles invalid inputs and provides appropriate error messages.
- The bill is saved to a file named `bill.txt`.

Enjoy your burger ordering experience!
