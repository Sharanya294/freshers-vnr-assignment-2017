package com.foodierestaurant;

public class Customer {

	private String name;
	private int persons;
	private int customerId;
	private Feedback feedback;
	
	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Customer(String name, int persons, int customerId) {
		this.name=name;
		this.persons=persons;
		this.customerId=customerId;	
		
	}

	public String getName() {
		return name;
	}

	

	public int getCustomerId() {
		return customerId;
	}



	public int getPersons() {
		return persons;
	}

	
}
