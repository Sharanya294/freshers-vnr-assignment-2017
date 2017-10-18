package foodierestaurant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

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
        this.name = name;
        this.persons = persons;
        this.customerId = customerId;

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

    /* This Function will write the customer data to a text file */
    public void persistCustomerData() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(new File("../src/files/customer.txt"), true));
            writer.println("===============");
            writer.println("Customer Id:" + customerId + " Feedback : ");
            writer.println("Food: " + (feedback != null ? feedback.getFoodRating() : "")); // If the users don't want to
            // give the feedback, then
            // feedback object is null.
            // Hence checking for null
            // before
            // writing to file.
            writer.println("Service: " + (feedback != null ? feedback.getServiceRating() : ""));
            writer.println("Ambience: " + (feedback != null ? feedback.getAmbienceRating() : ""));
            writer.println((feedback != null ? feedback.getComments() : ""));
            writer.println("===============");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
