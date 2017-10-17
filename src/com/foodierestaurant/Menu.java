package com.foodierestaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class  Menu {
	
	static HashMap<Integer, Item> items = new HashMap<>();

	/* This function will read the menu items from the menuFile.txt file and prints on the screen */
	public  void displayMenu() {

		try {
		 BufferedReader in = new BufferedReader(new FileReader("src/files/menuFile.txt"));
		 String line;
		 while((line = in.readLine()) != null)
		 {
		    // System.out.println(line);
		     String str[] = line.split("\\t");
		     
		     if(str.length == 3) {
		    	 System.out.printf("%s   %-30s %s", str[0],str[1],str[2]);
		    	 System.out.println();
		  // 	 System.out.println(str[0]+" "+str[1]+" "+str[2]);
		    	 Item item = new Item(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]));
		    	 items.put(Integer.parseInt(str[0]),item);
		     }
		     else {
		    	 System.out.println(line);
		     }
		 }
		 in.close();
		}
		
		catch( Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static Item getItem(int id)
	{
		return items.get(id);
	}
	


}
