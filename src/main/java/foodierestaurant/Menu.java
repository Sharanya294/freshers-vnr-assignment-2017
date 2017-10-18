package foodierestaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Menu {

	static HashMap<Integer, Item> items = new HashMap<Integer, Item>();

	/*
	 * This function will read the menu items from the menuFile.txt file and prints
	 * on the screen It divides the file lines based on tab delimiter and stores the
	 * menu details in a hash map
	 */
	public void displayMenu() {

		try {
			BufferedReader in = new BufferedReader(new FileReader("../src/files/menuFile.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				String str[] = line.split("\\t");
				if (str.length == 3) {
					System.out.printf("%s   %-30s %s", str[0], str[1], str[2]);
					System.out.println();
					Item item = new Item(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]));
					items.put(Integer.parseInt(str[0]), item);
				} else {
					System.out.println(line);
				}
			}
			in.close();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	/* It will return the item Object based on item key */
	public static Item getItem(int id) {
		return items.get(id);
	}

}
