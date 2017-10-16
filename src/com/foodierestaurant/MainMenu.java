package com.foodierestaurant;

import java.io.BufferedReader;
import java.io.FileReader;

public class  MainMenu {

	/* This function will read the menu items from the menuFile.txt file and prints on the screen */
	public static void displayMenu() {

		try {
		 BufferedReader in = new BufferedReader(new FileReader("src/files/menuFile.txt"));
		 String line;
		 while((line = in.readLine()) != null)
		 {
		     System.out.println(line);
		 }
		 in.close();
		}
		
		catch( Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
