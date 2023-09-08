/*An abstract class that provides a blueprint for different types of orders.
Contains common attributes like prices, burger names, quantities, and total costs.
Declares abstract methods for displaying the menu, getting user inputs, calculating costs, printing bills, and saving bills to a file.
*/

package menuDrivenProgram;

import java.util.Scanner;

//Order is an abstract class containing common attributes and methods
public abstract class Order implements OrderInterface{
	
	//To read user input. Also, the protected access modifiers are uses for the listed variables below, in order to be accessible within the subclasses (OrderBurger)
	protected Scanner scanner = new Scanner(System.in);
	
	//A private array to store the prices of different burgers.
	protected double[] priceArray = {5.25, 5.75, 5.95, 5.95, 5.95};
	
	//Store the names of different burger
	protected String[] burgerArray = {"Double Cheese Burger", "Bacon Cheese", "Mushroom Swiss", "Veggie Burger", "Protein Burger"};
	
	//Store the quantities of each burger ordered
	protected int[] quantityArray = new int[5];
	
	//Store the total cost before tax is added
	protected double totalBeforeTax;
	
	//Store the tax amount
	protected double tax;
	
	//Store the total cost with tax added
	protected double totalPriceAfterTax;
	
	//To store whether the user is student or not
	protected boolean isStudent;
	
	// display the menu
	public void displayMenu() {
	System.out.println("==========================================");
		//Prints the title
		System.out.println("Burger Menu for Student and Staff:");
		//Prints a separator line of dashes to create a visual separation between title and burger items.
		System.out.println("--------------------------");
		//Using a for loop to display each burger item with its corresponding price.
		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1) + ". " + burgerArray[i] + " - Cost: $" + priceArray[i]);
		}
		System.out.println("6. Exit Menu");
		System.out.println("==========================================");
	}

	public abstract void getInputs();// get integer from user  //should be overridden in OrderBurger class
	public abstract void calculate();// calculate the bill  //should be overridden in OrderBurger class
	public abstract void printBill(); // print out the bill  //should be overridden in OrderBurger class
	public abstract void saveBillToFile();// saves the bill in a file  //should be overridden in OrderBurger class	
}