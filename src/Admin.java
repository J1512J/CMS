import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * Class includes all the functionality of the Admin
 * Method to display registered users, conferences and papers
 *
 *
 * @author (venkata karthikeya ravilla)
 */
public class Admin {

    public Admin() {
    }

    /**
     * Method to display all registered users
     */
    public void getRegisteredUsers() {
        try {
            File fileObject = new File("UserDetails.txt");
            Scanner fileReader = new Scanner(fileObject);
            System.out.println("*****-- Details of all the registered Users is presented Below --*****");
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                String[] userField = line.split(",");
                System.out.println("First name: " + userField[0]);
                System.out.println("Last name: " + userField[1]);
                System.out.println("User email: " + userField[2]);
                System.out.println("Highest Qualification: " + userField[4]);
                System.out.println("Occupation: " + userField[5]);
                System.out.println("Employer details: " + userField[6]);
                System.out.println("Mobile number: " + userField[7]);
                System.out.println("Area of Interest: " + userField[8]);
                System.out.println("Role: " + userField[9]);
                System.out.println("\n");
            }
            fileReader.close();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Method to display registered conferences
     */
    public void getRegisteredConferences() {
        try {
            File fileObject = new File("ConferenceDetails.txt");
            Scanner fileReader = new Scanner(fileObject);
            System.out.println("*****-- Details of all the Registered Conferences is presented Below --*****");
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                String[] conferenceField = line.split(",");
                System.out.println("Conference Name: " + conferenceField[0]);
                System.out.println("Conference Title: " + conferenceField[1]);
                System.out.println("Conference Topic: " + conferenceField[2]);
                System.out.println("Conference Deadline: " + conferenceField[3]);
                System.out.println("\n");
            }
            fileReader.close();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Method to get paper details
     */
    public void getSubmittedPapers() {
        try {
            File fileObject = new File("paperDatabase.txt");
            Scanner fileReader = new Scanner(fileObject);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                String[] papersField = line.split(",");
                System.out.println("Paper Name: " + papersField[2]);
                System.out.println("\n");
            }
            fileReader.close();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}