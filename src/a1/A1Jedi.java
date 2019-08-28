package a1;

import java.util.Arrays;
import java.util.Scanner;

import a1.A1Adept.Customer;



public class A1Jedi {
	public static class A1JediOutput
	{
		private int numberOfCustomers;
		private int numberOfItem;
		private String itemName;
		public A1JediOutput (int n1, int n2, String i) {
			numberOfCustomers = n1;
			numberOfItem = n2;
			itemName = i;
		}
		public String getItemName() {
			return itemName;
		}
		public void addNumberOfItem(int n) {
			numberOfItem += n;
		}
		public void addNumberOfCustomers(int n) {
			numberOfCustomers += n;
		}
		public int getNumberOfCustomers() {
			return numberOfCustomers;
		}
		public int getNumberOfItem() {
			return numberOfItem;
		}
	} // Class stores necessary output information
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

	public static class Customer 
	{
		private String name;
		private String itemsBought;
		public Customer (String n, String i)
		{
			name = n;
			itemsBought = i;
		}
		public void setName(String n)
		{
			name = n;
		}
		public void addItemsBought(String i)
		{
			itemsBought = itemsBought + i;
		}

	}
	public static void main(String[] args) 
	{

		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int numberOfItemsInStore = scan.nextInt();
		Item store[] = new Item[numberOfItemsInStore];
		A1JediOutput items[] = new A1JediOutput[numberOfItemsInStore];
		for (int i = 0; i < store.length ; i++) 
		{
			String temp = scan.next();

			store[i] = new Item(temp, scan.nextDouble());
			items[i] = new A1JediOutput( 0, 0, temp);
			
		} //creates array of Items that have two properties: (name, price)
			//initializes output array
		int numberOfCustomers = scan.nextInt();
		Customer customers[] = new Customer[numberOfCustomers];


		for (int i1 = 0; i1 < customers.length ; i1++) 
		{
			customers[i1] = new Customer("", "");
			customers[i1].setName(scan.next() + " " + scan.next());
			int itemsBought = scan.nextInt();
			for (int i4 = 0; i4 < itemsBought ; i4++) 
			{
				int quantity = scan.nextInt();
				String name = scan.next();
				customers[i1].addItemsBought(name);
				for (int a = 0; a < items.length; a++) {
					if (name.equals(items[a].getItemName())) {
						items[a].addNumberOfItem(quantity);
					}
				}



			} 

		}  //input: customer name, items bought, quantity and name
			//output: creates two arrays, one with customer name and String of itemsbought
			//other array is initizlied items arrays, used for output
		for (int a = 0; a < items.length; a++) {
			for (int i1 = 0; i1 < customers.length; i1++) {
				if (customers[i1].itemsBought.contains(items[a].getItemName())) {
					items[a].addNumberOfCustomers(1);
				}
			}
		} //goes through items array and checks if a customer bought an item
		//if they did, adds 1 customer to number of customers who bought certain item
		scan.close();
		for (int a = 0; a < items.length; a++) {
			if (items[a].getNumberOfCustomers() > 0)
			{
			System.out.println(items[a].getNumberOfCustomers() + " customers bought " +
			items[a].getNumberOfItem() + " " + items[a].getItemName());
			}
			else
			{
			System.out.println("no customers bought " + items[a].getItemName());
			}
		} //goes through item array and outputs information
		

	}
}


