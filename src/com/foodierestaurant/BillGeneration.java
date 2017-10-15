package com.foodierestaurant;

import java.util.HashMap;

public class BillGeneration extends Orders  {
	

	 private float totalBill;
	 private int billID;
	 
	 public BillGeneration() {
		 this.billID=GenerateRandomNumber.generate(300,400);
	 }
	 HashMap<String,Integer> prices = new HashMap<String,Integer>();
	 public void initializePrices() {
		 prices.put("Lemon Grass soup", 80);
		 prices.put("Hot and sour soup", 100);
		 prices.put("Chiken Manchuria", 200);
		 prices.put("Chilly Panner", 150);
		 prices.put("Chicken Biryani", 250);
		 prices.put("Veg Biryani", 150);
		 prices.put("Gulab Jamun", 50);
		 prices.put("Dal Halwa", 40);
		 
		 
	 }
	public float calculateBill(int orderID) {
		totalBill=0;
		HashMap<Integer, HashMap<String, Integer>> order = getOrders();
		
		System.out.println("\n *******Your Bill********");
		for(HashMap.Entry<Integer, HashMap<String,Integer>> t:order.entrySet()) {
			   Integer key = t.getKey();
			   System.out.println("Bill ID:  "+ billID+ "  Order ID: " + key );
			   System.out.println("Item Name\t \t\t   Qauntity \t Amount"  );
			   
			   for (HashMap.Entry<String,Integer> orderVariable : t.getValue().entrySet()) {
				   
				   System.out.println(orderVariable.getKey()+ " \t\t\t " +orderVariable.getValue() + "\t  "
						   +prices.get(orderVariable.getKey())* orderVariable.getValue() );
				 //  System.out.println("Item Price: " + prices.get(orderVariable.getKey()));
				   totalBill=totalBill+prices.get(orderVariable.getKey())* orderVariable.getValue();
				   
			   }
			     
		}
		
		System.out.println("Total Bill is: "+ totalBill);
		
		return totalBill;
		
	}

}
