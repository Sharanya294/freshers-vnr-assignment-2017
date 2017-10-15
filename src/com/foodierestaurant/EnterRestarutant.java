package com.foodierestaurant;

import java.util.Scanner;

public class EnterRestarutant {
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Foodie Restaurant !!");
		System.out.println("Customer Name: ");
		Scanner sc = new Scanner(System.in);
		String name=sc.next();
		System.out.println("Number of persons: ");
		int persons=sc.nextInt(); 
		int  customerId =GenerateRandomNumber.generate(1,100);
		Customer customerObj=new Customer(name,persons,customerId); // creating the customer object
		Table tableObj = new  Table();
		int choosenTable=tableObj.allocateTable(customerObj,persons); // calling allocateTable method
		tableObj.serveWater(choosenTable);
		System.out.println(name+ ",Please tell your order ?? \n \n");
		 MainMenu.displayMenu();
		 int yourOrderID= new Orders().takeOrder();
		 MainCook.cookTheOrder(yourOrderID);
		 BillGeneration billObj= new BillGeneration();
		 billObj.initializePrices();
		 billObj.calculateBill(yourOrderID);
		sc.close();
		
		
		
		
		
					
	}

}
