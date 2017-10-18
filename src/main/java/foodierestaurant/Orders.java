package foodierestaurant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Orders {

    private int orderID;
    private int customerID;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    private HashMap<Integer, Integer> itemsOrdered = new HashMap<Integer, Integer>();
    private static HashMap<Integer, HashMap<Integer, Integer>> orders = new HashMap<Integer, HashMap<Integer, Integer>>();
    // Variable orders Stores <order id>, <<Item names, Quantity>>

    /*
     * This function takes the order from the customer. Generates an order id. Calls
     * the orderSummary method to print the summary. Takes no arguments and returns
     * the order ID generated.
     */
    public int takeOrder(Menu menu) {

        orderID = GenerateRandomNumber.generate(200, 300); // Generating a random number for order id
        Scanner sc = new Scanner(System.in);
        int menuNumber = 0;
        do {
            System.out.println("Please Choose any of the above items. Press 0 for exit");
            menuNumber = sc.nextInt();
            if (menuNumber != 0) {
                if (Menu.items.containsKey(menuNumber)) {
                    Item i = menu.getItem(menuNumber);
                    System.out.println("Please tell  Quantity for " + i.getName());
                    int quantity = sc.nextInt();
                    itemsOrdered.put(i.getId(), quantity);
                } else
                    System.out.println(
                            "You have entered an item which is not present in our Menu. Please choose a correct item.");
            }
        } while (menuNumber != 0);

        orders.put(orderID, itemsOrdered);
        orderSummary(orders); // Calling the order summary to print the summary of the order taken.
        return orderID;

    }

    /* This method prints the Summary of the order */
    public void orderSummary(HashMap<Integer, HashMap<Integer, Integer>> order) {
        System.out.println("Here is your order summary");
        for (Integer orderIds : order.keySet()) {
            System.out.println("===== Order ID: " + orderIds + " =====");
            for (Integer orderVariable : order.get(orderIds).keySet()) {
                System.out.println(" Item Name: " + Menu.getItem(orderVariable).getName() + "  Quantity :"
                        + order.get(orderIds).get(orderVariable));
            }
            System.out.println();
        }
        storeOrders(); // Calling to function to store the orders.
    }

    /* This method will store the orders to a file */
    public void storeOrders() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(new File("../src/files/orders.txt"), true));
            for (Integer orderIds : orders.keySet()) {
                writer.println("===== Order ID: " + orderIds + " Customer ID: " + customerID + "=====");
                for (Integer orderVariable : orders.get(orderIds).keySet()) {
                    writer.println(" Item Name: " + Menu.getItem(orderVariable).getName() + "  Quantity :"
                            + orders.get(orderIds).get(orderVariable));
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
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
