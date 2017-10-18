package com.foodierestaurant;

import java.util.Scanner;

public class Feedback {
	private int foodRating;
	private int serviceRating;
	private int ambienceRating;
	private String comments;
	
	public int getFoodRating() {
		return foodRating;
	}

	public void setFoodRating(int foodRating) {
		this.foodRating = foodRating;
	}

	public int getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(int serviceRating) {
		this.serviceRating = serviceRating;
	}

	public int getAmbienceRating() {
		return ambienceRating;
	}

	public void setAmbienceRating(int ambienceRating) {
		this.ambienceRating = ambienceRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	/* This method will take the feedback from the customer*/
	public void takeFeedback() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= Feedback Form======== ");
		System.out.println("Rate us out of 5 on each section");
		System.out.println("Food: ");
		foodRating=sc.nextInt();
		System.out.println("Service: ");
		serviceRating=sc.nextInt();
		System.out.println("Ambience: ");
		ambienceRating=sc.nextInt();
		System.out.print("Any additional comments: ");
		sc.nextLine();
		comments=sc.nextLine();
		System.out.println("Thank you. Visit us again !!");		
	}
	

}
