package a1;

import java.util.Scanner;

public class A1Novice {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Your code follows here.
		int count = scan.nextInt(); 
		//establishes number of customers based on input
		for (int i = 0; i < count; i++) {
			String output = scan.next().substring(0,1) + ". " 
					+ scan.next() + ": ";
			//Takes input of customers and organizes their names into "F. Last: "
			double total = 0.0;
			//TOTAL output variable
			int itemsBought = scan.nextInt();
			int quantity = 0;
			String name = "";
			double price = 0.0;
			for (int i1 = 0; i1 < itemsBought; i1++) {
				quantity = scan.nextInt();
				name = scan.next();
				price = scan.nextDouble();
				total = total + (quantity * price);
			} //for loop that takes integer quantity of items bought
			 // then loops through accumulating total cost of items
			System.out.println(output + String.format("%.2f", total));
			//outputs information
		}
		
		scan.close();

	}
	
}
