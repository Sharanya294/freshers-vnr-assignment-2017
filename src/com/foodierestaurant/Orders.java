package com.foodierestaurant;


import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Orders {

	private  int orderID;
	private  HashMap<String,Integer> itemsOrdered=new HashMap<String,Integer>();   
	private static HashMap<Integer,HashMap<String,Integer> > orders = new HashMap<Integer,HashMap<String,Integer> >();
	
	public  int takeOrder() {
		
		orderID = GenerateRandomNumber.generate(200,300);			// Generating a random number for order id	
		Scanner sc = new Scanner(System.in);
		int menuNumber=1;
		do {
			System.out.println("Please Choose any of the above items. Press 0 for exit");
			menuNumber = sc.nextInt();
			switch(menuNumber) {   							
			case 1: 
				System.out.println("Please tell  Quantity for Lemon Grass soup");
				int quantity = sc.nextInt();
				itemsOrdered.put("Lemon Grass soup", quantity );
				//System.out.println(itemsOrdered);
				break;
			case 2:
				System.out.println("Please tell Quantity for Hot and sour soup");
				itemsOrdered.put("Hot and sour soup", sc.nextInt() );
				break;
				
			case 3:
				System.out.println("Please tell Quantity for Chiken Manchuria");
				itemsOrdered.put("Chiken Manchuria", sc.nextInt() );
				break;
			case 4:
				System.out.println("Please tell Quantity for Panner 65");
				itemsOrdered.put("Chilly Panner", sc.nextInt() );
				break;
			case 5:
				System.out.println("Please tell Quantity for chicken biryani");
				itemsOrdered.put("Chicken Biryani", sc.nextInt() );
				break;
			case 6:
				System.out.println("Please tell Quantity for Veg Biryani");
				itemsOrdered.put("Veg Biryani", sc.nextInt() );
				break;
			case 7:
				System.out.println("Please tell Quantity for Gulab Jamun");
				itemsOrdered.put("Gulab Jamun", sc.nextInt() );
				break;
			case 8:
				System.out.println("Please tell Quantity for Dal Halwa");
				itemsOrdered.put("Dal Halwa", sc.nextInt() );
				break;
			case 0:
				System.out.println("Thank you for the order !!");
				//System.out.println(itemsOrdered);
				break;
			}
			
		}while (menuNumber != 0);
		orders.put(orderID, itemsOrdered);
		orderSummary(orders);   							// Calling the order summary to print the summary of the order taken.
		//System.out.println(getOrders());
		sc.close();
		return orderID;
		
	}
	
	/* This method prints the Summary of the order*/
	public  void orderSummary(HashMap<Integer,HashMap<String,Integer> > order ) {
		System.out.println("Here is your order summary");
		for(HashMap.Entry<Integer, HashMap<String,Integer>> t:order.entrySet()) {
			   Integer key = t.getKey();
			   System.out.println("===== Order ID: " + key + " =====" );
			   for (HashMap.Entry<String,Integer> orderVariable : t.getValue().entrySet()) {
				   System.out.println(" Item Name: " + orderVariable.getKey()+ "  Quantity :" +orderVariable.getValue());
				   
			   }
			     
		}
		
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public HashMap<Integer, HashMap<String, Integer>> getOrders() {
		return orders;
	}
		
	
	}



