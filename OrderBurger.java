/*A subclass of Order that specializes in burger orders.
Overrides abstract methods from the Order class to implement specific ordering and billing logic.
Gets user input for burger options and quantities, validates input, calculates the bill (including tax), 
prints a detailed bill, and saves the bill to a file.
*/

package menuDrivenProgram;
//imported to handle input/output exceptions
import java.io.IOException;
//imported to write data to a file
import java.io.PrintWriter;

//OrderBurger is a subclass of Order, it inherits behaviors and attributes from Order class and implementing specific behaviors. 
public class OrderBurger extends Order {

    // get inputs from user
    public void getInputs() {
		
		//To store the user's input burger option
		int burgerOption;
		
		while (true) {
			System.out.print("Which burger do you want? Enter the option number (1-5), enter 6 when you are finish with order: ");

			//This while loop checks if the user input is an integer using hasNextInt(). For user input validation. If input is not a integer, a error message will display. 
			//Once a valid integer inputs is received for burger option and quantity (shown on the bottom when asking for burger quantity), the rest of the method works as before.
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input! Please enter a number between 1 and 5, or 6 to finish your order.");
				
				// This clear the invalid input from the scanner.
				scanner.next();
			}
			
			burgerOption = scanner.nextInt();
			
			//If statement, if the user entered 6 (exit option), if true, then it prints the thank you message and breaks out of the loop to end the ordering process.
			if (burgerOption == 6) {
				System.out.println("Thank you for coming today. Have a nice day!");
				//Exit the method if the user entered 6, This also ensures no further actions related to ordering, printing the bill, writing to a file, or asking for other questions will be performed.
				return; 
			}
			//This while statement check if the user entered a valid input (between 1 and 5). For user input validation. If not, it prints an error message and continues to the next iteration of
			//the loop to ask for user input again. If the user enters a valid burger option between 1 and 5 the code will proceed to ask for the burger quantity and update the quantityArray.
			while (burgerOption < 1 || burgerOption > 5) {
				System.out.println("Invalid input! Please enter a number between 1 and 5.");
				System.out.println("Which burger do you want? Enter the option number (1-5), enter 6 when you are finished with the order: ");
				burgerOption = scanner.nextInt();
			}
			
			//Continue with the ordering process get the burger quantity and update the quantityArray
			//To store the quantity of the selected burger
			int burgerQuantity;
			
			System.out.print("How many burger would you like? Enter your quantity: ");
			
			//Same as the while loop above for checking the user input is an integer for burger option using hasNextInt(). For user input validation. Checks if the user input for quantity is an integer.
			while(!scanner.hasNextInt()) {
				System.out.println("Invalid input! Please enter a positive whole number for the quantity.");
				//Clear the invalid input from the scanner
				scanner.next(); 
			}
			
			burgerQuantity = scanner.nextInt();
			
			//This if statement checks if the entered burger quantity is less than 1. For user input validation. If true, it prints an error message.
			//Otherwise, it updates the quantityArray with the user's input for the corresponding burger option. 
			if (burgerQuantity < 1) {
				System.out.println("Invalid input! Burger quantity should be at least 1.");
			} else {
				quantityArray[burgerOption -1] += burgerQuantity;
			}	
		}
	}		

    // calculate the bill
    public void calculate() {
    	
    	// Check if the user entered "6" at the beginning
        if (quantityArray[0] == 0 && quantityArray[1] == 0 && quantityArray[2] == 0 && quantityArray[3] == 0 && quantityArray[4] == 0) {
            // Exit the method if user entered "6" at the beginning
        	return; 
        }
		
		System.out.print("Are you a student? (Enter S or s for student) or staff (Enter any other key for staff): ");
		//Read the user's input for student or staff status and stores it in he inputStudentOrStaff variable. The trim() method removes leading and trailing whitespaces from the input. 
		String inputStudentOrStaff = scanner.next().trim();
		//Check if the user enter s or S to indicate they are a student. If true, student, if false then staff. 
		isStudent = inputStudentOrStaff.equals("s") || inputStudentOrStaff.equals("S");
		
		//Using a for loop, it multiples the quantity of each burger with its corresponding price and add it to the total. 
		for (int i =0; i < quantityArray.length; i++) {
			totalBeforeTax += quantityArray[i] * priceArray[i];
		}
		
		//The if-else statement determine the tax amount based on whether the user is a student or staff. If user is student, tax is 0. Else, tax will be calculated as 9% from the OrderInterface file.
		if (isStudent) {
			tax = 0;
		} else {
			tax = totalBeforeTax * TAX;
		}
		//Calculates the total price.
		totalPriceAfterTax = totalBeforeTax + tax;
		
	}
    // print out the bill
    public void printBill() {
    	// Check if the user entered "6" at the beginning
        if (quantityArray[0] == 0 && quantityArray[1] == 0 && quantityArray[2] == 0 && quantityArray[3] == 0 && quantityArray[4] == 0) {
            // Exit the method if user entered "6" at the beginning
        	return; 
        }
   	
		System.out.println("Here is your bill with the order details:");
		
		//For loop to iterate through the quantityArray and display the details of each ordered item.
		for (int i = 0; i < quantityArray.length; i++) {
			//If statement to check if the quantity of the current item is greater than 0. To make sure only items with non-zero quantities are printed in the bill. %.2f format the amount with two decimal places.
			if (quantityArray[i] > 0) {
				//Prints the burger name at index i, get the quantity of the burger, and to calculate the total cost for that item. 
				System.out.println("Item: " + burgerArray[i] + " - Quantity: " + quantityArray[i] + " - Cost: $" + String.format("%.2f", (quantityArray[i] * priceArray[i]) )); 
			}
		}
		//Prints out the Total before tax, tax amount, and Total price after tax, and formating with two decimal places. 
		System.out.println("Total before tax: $" + String.format("%.2f", totalBeforeTax));
		System.out.println("Tax amount: $" + String.format("%.2f", tax));
		System.out.println("Total price after tax: $" + String.format("%.2f", totalPriceAfterTax ));	
	}
    // save the bill in a file, need to add
    public void saveBillToFile() {
    	
    	// Check if the user entered "6" at the beginning
        if (quantityArray[0] == 0 && quantityArray[1] == 0 && quantityArray[2] == 0 && quantityArray[3] == 0 && quantityArray[4] == 0) {
            // Exit the method if user entered "6" at the beginning
        	return; 
        }
    	//try-with-resources block, automatically closes resources like files, Printwriter, when it is no longer needed. And it opens a file named bill.txt for writing. 
    	try (PrintWriter output = new PrintWriter("bill.txt")) {
            //the header line "Here is your bill with the order details: " is printed
    		output.println("Here is your bill with the order details:");
    		
    		//a for loop to iterate through each burger option in the quantityArry. If the quantity of a burger is greater than 0, it prints the details of that burger to the file. 
            for (int i = 0; i < quantityArray.length; i++) {
                if (quantityArray[i] > 0) {
                    output.println("Item: " + burgerArray[i] + " - Quantity: " + quantityArray[i] + " - Cost: $" + String.format("%.2f", (quantityArray[i] * priceArray[i])));
                }
            }
            //prints the total before tax, tax amount, and total price, and finally prints the bill has been saved to the file bill.txt.
            output.println("Total before tax: $" + String.format("%.2f", totalBeforeTax));
            output.println("Tax amount: $" + String.format("%.2f", tax));
            output.println("Total price after tax: $" + String.format("%.2f", totalPriceAfterTax));
            System.out.println("Bill saved to 'bill.txt'");
            //if an error occurs when writing to the file, the catch block catches the exception and prints an error message. 
        } catch (IOException e) {
            System.out.println("Error while saving the bill to file: " + e.getMessage());
        }	
    }
}