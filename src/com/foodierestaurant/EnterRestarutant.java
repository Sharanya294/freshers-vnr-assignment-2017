package com.foodierestaurant;

import java.util.Scanner;

public class EnterRestarutant {
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Foodie Restaurant !!");
		System.out.println("Your Good Name: ");
		Scanner sc = new Scanner(System.in);
		String name=sc.next();
		System.out.println("Number of persons: ");
		int persons=sc.nextInt(); 
		int  customerId =GenerateRandomNumber.generate(1,100); // Will generate a random Customer ID 
		Customer customerObj=new Customer(name,persons,customerId); // creating the customer object
		Table tableObj = new  Table();								// creating Table object to initialize all tables
		int choosenTable=tableObj.allocateTable(customerObj,persons); // calling allocateTable method to allocate suitable table
		tableObj.serveWater(choosenTable);							// Serving water on the table
		System.out.println(name+ ",Please tell your order ?? \n \n");
		MainMenu.displayMenu();									// Displaying menu to the customer
		int yourOrderID= new Orders().takeOrder();				 	// Calling the takeOrder method from Order class to take order from customer
		MainCook.cookTheOrder(yourOrderID);						// Cooking the order by calling static method cookThe order
		BillGeneration billObj= new BillGeneration();				
		billObj.initializePrices();								// Initializes the prices for the items present in menu 
		billObj.calculateBill(yourOrderID);						// calculates the bill based on order id passed
		sc.close();												
		
		
		
		
		
					
	}

}
