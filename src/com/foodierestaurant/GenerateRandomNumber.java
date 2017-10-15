package com.foodierestaurant;
import java.util.Random;
public  class GenerateRandomNumber {

	public static int generate(int from, int to) {
		int randomNumber;
		Random rand = new Random();
		randomNumber = rand.nextInt(to) + from;
		return randomNumber;
	}
}
