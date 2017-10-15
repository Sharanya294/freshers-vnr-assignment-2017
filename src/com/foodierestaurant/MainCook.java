package com.foodierestaurant;

public class MainCook {

	public static void cookTheOrder(int orderNumber) {
		try {
		System.out.println("\n your Order ID "+ orderNumber+ " is getting cooked." );
		System.out.println("\n Please wait for few mintutes while we cook the delicious food..");
		
			Thread.sleep(5000);
		 
		System.out.println("\n Food is served to the customer..");
		
			Thread.sleep(5000);
		}
		
catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
