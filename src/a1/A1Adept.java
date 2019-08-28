package a1;

import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class A1Adept 
{

	public static class Item 
	{
		private String name;
		private double price;
		public Item (String n, double p) 
		{
			name = n;
			price = p;
		}
		public void setData(String n, double p) 
		{
			name = n;
			price = p;
		}
		public String getName() 
		{
			return name;
		}
		public double getPrice() 
		{
			return price;
		}
	} // end class, class implements item type
	public static class Customer implements Comparable<Customer>
	{
		private String name;
		private double amount;
		public Customer(String n, double a) 
		{
			name = n;
			amount = a;
		}
		public void setName(String n) 
		{
			name = n;


		}
		public void setAmount(double a) 
		{
			amount = a;
		}
		public String getName() 
		{
			return name;
		}
		public double getAmount() 
		{
			return amount;
		}
		@Override
		public int compareTo(Customer o) {
			// TODO Auto-generated method stub
			return Double.compare(this.getAmount(), o.getAmount());

		}
	} // end class, implements Customer type and comparator to sort array of customer


	public static void main(String[] args) 
	{

		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int numberOfItemsInStore = scan.nextInt();
		Item store[] = new Item[numberOfItemsInStore];
		for (int i = 0; i < store.length ; i++) 
		{
			store[i] = new Item(scan.next(), scan.nextDouble());

		} //input: number of items in store, name of each item, and price of each item
		//creates array of Items that have two properties: (name, price)

		int numberOfCustomers = scan.nextInt();
		Customer customers[] = new Customer[numberOfCustomers];
		//input: number of customers
		//out: initializes array of customers

		for (int i1 = 0; i1 < customers.length ; i1++) 
		{
			customers[i1] = new Customer(null, i1);
			customers[i1].setName(scan.next() + " " + scan.next());
			int itemsBought = scan.nextInt();
			double total = 0.0;
			for (int i4 = 0; i4 < itemsBought ; i4++) 
			{
				int quantity = scan.nextInt();
				String name = scan.next();

				for (int i3 = 0; i3 < store.length ; i3++) 
				{
					if (store[i3].getName().equals(name)) 
					{
						total += quantity * store[i3].getPrice();
						i3 = 0;
						break;
					} //conditional: compares String values of Items in store
					//result: adds quantity * price to amount spent

				} //loop accumulates total amount spent
				
				customers[i1].setAmount(total);


			} //loop sets amount spent


		} // for loop that creates array of type Customer with two properties: (name, amount spent)
		Arrays.sort(customers);
		//sorts customers
		System.out.println("Biggest: " + customers[customers.length - 1].getName() 
				+ " (" + String.format("%.2f", customers[customers.length - 1].getAmount()) + ") ");
		//prints biggest spender
		System.out.println("Smallest: " + customers[0].getName() 
				+ " (" + String.format("%.2f", customers[0].getAmount()) + ") ");
		//prints smallest spender
		double averageSpent = 0;
		//average spent variable used in output line
		for (int i = 0; i < customers.length; i++) {

			averageSpent += customers[i].getAmount();

		} //for loop accumulates spending of all customers
		averageSpent = averageSpent / customers.length;
		//gets average spending per customer
		System.out.println("Average: " + String.format("%.2f", averageSpent));
		//prints average spent
		scan.close();

	}
}

