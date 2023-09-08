/*An interface outlining methods that must be implemented by classes like Order and OrderBurger.
Defines a constant for tax calculation and declares methods for displaying menus, getting inputs, 
calculating costs, printing bills, and saving bills to files.
*/

package menuDrivenProgram;

//OrderInterface outlines the methods to be implemented in both Order and OrderBurger,
public interface OrderInterface {
    // this constants can be used in your Order class or OrderBurger class
    final double TAX = 0.09;

    void displayMenu();         // displays the menu         
    void getInputs();         //gets inputs         
    void calculate();         //calculates the cost
    void printBill();          //prints the bill
    void saveBillToFile();          //saves the bill in a text file
}