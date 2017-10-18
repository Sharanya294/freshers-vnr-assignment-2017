package com.foodierestaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Resturant {

	private Menu menu;

	private ArrayList<Table> tableList = new ArrayList<Table>();;

	public Resturant() {
		menu = new Menu();

		/* initialize all the tables. */

		tableList.add(new Table(1, 2));
		tableList.add(new Table(2, 4));
		tableList.add(new Table(3, 2));
		tableList.add(new Table(4, 4));
		tableList.add(new Table(5, 4));
		tableList.add(new Table(6, 4));
		tableList.add(new Table(7, 8));

	}

	/*
	 * This method will start the whole flow from customer entering the restaurant
	 * and till leaving
	 */
	public void startResurant() {
		System.out.println("Welcome to the Foodie Restaurant !!");
		System.out.println("Your Good Name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Number of persons: ");
		int persons = sc.nextInt();
		int customerId = GenerateRandomNumber.generate(1, 100); // Will generate a random Customer ID
		Customer customerObj = new Customer(name, persons, customerId); // creating the customer object
		int choosenTable = allocateTable(customerObj, persons); // calling allocateTable method to allocate suitable
																// table
		serveWater(choosenTable); // Serving water on the table
		System.out.println(name + ",Please tell your order ?? \n \n");
		menu.displayMenu(); // Displaying the menu
		Orders orderObj = new Orders();
		orderObj.setCustomerID(customerId); // linking the customer id with orders
		int yourOrderID = orderObj.takeOrder(menu); // Calling the takeOrder method from Order class to take order from
													// customer
		MainCook.cookTheOrder(yourOrderID); // Cooking the order by calling static method cookThe order
		BillGeneration billObj = new BillGeneration();
		billObj.calculateBill(yourOrderID); // calculates the bill based on order id passed
		System.out.println("We would like to hear from you. Do you want to give feedback " + name + "? (Y/N)");

		String feedbackDecision = sc.next();
		if (feedbackDecision.equalsIgnoreCase("Y")) {
			Feedback feedback = new Feedback();
			feedback.takeFeedback(); // taking the feedback
			customerObj.setFeedback(feedback); // linking feedback to Customer
		} else {
			System.out.println("Thank you. Visit us again !!");
		}
		customerObj.persistCustomerData(); // Stores customer Data
	}

	/*
	 * This function will find the available tables based on the number of persons.
	 * It will return the list of available tables.
	 */

	public ArrayList<Integer> findTable(int persons) {
		ArrayList<Integer> availableTables = new ArrayList<Integer>();
		System.out.println("Finding for suitable tables...");
		for (Table tables : tableList) {

			if (tables.getCapacity() >= persons)
				availableTables.add(tables.getTableId());

		}
		return availableTables;
	}

	/*
	 * This method will list all the tables based on number of persons and will
	 * allocate a table chosen by manager. Returns the table number which is
	 * allocated
	 */
	public int allocateTable(Customer customerObj, int persons) {
		// creates the table object and initializes all the tables
		ArrayList<Integer> availableTables = findTable(persons);
		if (availableTables.isEmpty())
			System.out.println("Sorry! there are no vacant tables");

		else
			System.out.println("Available Tables are: " + availableTables);
		System.out.println("Choose a table to allocate from above tables");
		int choosenTable = new Scanner(System.in).nextInt();
		System.out.println("Customer " + customerObj.getName() + " is allocated to table number " + choosenTable);
		return choosenTable;

	}

	/* This function will serve water to the table */
	public void serveWater(int tableNumber) {
		try {

			System.out.println("... \n...");
			Thread.sleep(3000);
			System.out.println("Water is served on " + tableNumber + "\n");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
