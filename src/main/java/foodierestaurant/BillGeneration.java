package foodierestaurant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class BillGeneration extends Orders {

    private float totalBill;
    private int billID;

    public BillGeneration() {
        this.billID = GenerateRandomNumber.generate(300, 400); // Generating a random number for bill ID.
    }

    /*
     * Calculates the total bill. Takes the order id as parameter and returns the
     * total bill.
     */
    public float calculateBill(int orderID) {
        totalBill = 0;
        HashMap<Integer, HashMap<Integer, Integer>> order = getOrders();

        System.out.println("\n *******Your Bill********");
        for (Integer key : order.keySet()) {
            System.out.println("Bill ID:  " + billID + "  Order ID: " + key);
            System.out.println("Item Name\t    Qauntity  Amount(INR)");
            for (Integer orderVariable : order.get(key).keySet()) {

                Item i = Menu.getItem(orderVariable);
                System.out.printf("%-20s   %s        %s", i.getName(), order.get(key).get(orderVariable),
                        (order.get(key).get(orderVariable) * i.getCost()));
                System.out.println();
                totalBill = totalBill + order.get(key).get(orderVariable) * i.getCost();

            }
            System.out.println();
        }

        System.out.println("Total Bill is: " + totalBill);
        storeBill();
        return totalBill;

    }

    /* This function stores the bill into a file */
    public void storeBill() {
        HashMap<Integer, HashMap<Integer, Integer>> order = getOrders();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(new File("../src/files/bills.txt"), true));
            for (Integer key : order.keySet()) {
                writer.println("Bill ID:  " + billID + "  Order ID: " + key + " Total Bill: " + totalBill);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}