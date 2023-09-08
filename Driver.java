/*
Serves as the entry point of the program.
Creates an instance of the OrderBurger class to handle the order.
Invokes methods to display the menu, get user inputs for burger orders and quantities, 
calculate the bill, print the bill, and save the bill to a file.
 */

package menuDrivenProgram;

public class Driver {
    public static void main(String[] args) {
            OrderBurger order = new OrderBurger();                 

            order.displayMenu();        //displays the menu                   
            order.getInputs();          //gets inputs                   
            order.calculate();          //calculates cost                  
            order.printBill();           //prints bill
            order.saveBillToFile();          //saves the bill in a text file
    }
}