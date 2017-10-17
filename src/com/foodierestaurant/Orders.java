package com.foodierestaurant;


import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Orders {

	private  int orderID;
	private  HashMap<Integer,Integer> itemsOrdered=new HashMap<Integer,Integer>();   
	private static HashMap<Integer,HashMap<Integer,Integer> > orders = new HashMap<Integer,HashMap<Integer,Integer> >(); 
	//Variable orders Stores <order id>, <<Item names, Quantity>> 
	
	/*This function takes the order from the customer.
	 * Generates an order id.
	 * Calls the orderSummary method to print the summary.
	 * Takes no arguments and returns the order ID generated. 
	 *  */
	public  int takeOrder(Menu menu) {
		
		orderID = GenerateRandomNumber.generate(200,300);			// Generating a random number for order id	
		Scanner sc = new Scanner(System.in);
		int menuNumber = 0;
//		try {
			do {
			System.out.println("Please Choose any of the above items. Press 0 for exit");
			menuNumber = sc.nextInt();
			if(menuNumber!=0) {
				if (Menu.items.containsKey(menuNumber)) {
					Item i = menu.getItem(menuNumber);
					System.out.println("Please tell  Quantity for " + i.getName());
					int quantity = sc.nextInt();
					itemsOrdered.put(i.getId(), quantity);
				}
				else
					System.out.println("You have entered an item which is not present in our Menu. Please choose a correct item.");
			}
		}while(menuNumber != 0);
//			}
//		catch (NullPointerException e) {
//			System.out.println("You have entered an item which is not present in our Menu. Please choose a correct item.");
//		}
//		
		
		orders.put(orderID, itemsOrdered);
		orderSummary(orders);   							// Calling the order summary to print the summary of the order taken.
		//System.out.println(getOrders());
		return orderID;
		
	}
	
	/* This method prints the Summary of the order*/
	public  void orderSummary(HashMap<Integer,HashMap<Integer,Integer> > order) {
		System.out.println("Here is your order summary");
//		for(HashMap.Entry<Integer, HashMap<Integer,Integer>> t:order.entrySet()) {
//			   Integer key = t.getKey();
//			   System.out.println("===== Order ID: " + key + " =====" );
//			   for (HashMap.Entry<Integer,Integer> orderVariable : t.getValue().entrySet()) {
//				   System.out.println(" Item Name: " + orderVariable.getKey()+ "  Quantity :" +orderVariable.getValue());
//				   
//			   }
//			     
//		}

		for(Integer orderIds : order.keySet()) {
			 System.out.println("===== Order ID: " + orderIds + " =====" );
			for(Integer orderVariable : order.get(orderIds).keySet()) {
				System.out.println(" Item Name: " + Menu.getItem(orderVariable).getName() + "  Quantity :" + order.get(orderIds).get(orderVariable));
			}
			System.out.println();
		}
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public HashMap<Integer, HashMap<Integer, Integer>> getOrders() {
		return orders;
	}
		
	
	}



