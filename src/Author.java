import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


/**
 * Holds an object of class paper
 * Holds author information like author name, author email id
 * Methods to access and mutate the parameters mentioned above
 * Method to check validity of the mail id
 * Method to display paper information
 *
 *     @author (Tejas Deepak)
 *     @version (24 / 05 / 21)
 */
public class Author
{
    private String authorFirstName;
    private String authorLastName;
    private String authorMailID;
    private int reviewNotification;
    private ArrayList<Paper> arrPaper;


    /**
     * Constructor for class Author
     */
    public Author (){
        authorFirstName = "John";
        authorLastName = "Doe";
        authorLastName = "johndoe@gmail.com";
        arrPaper = new ArrayList<>();
        reviewNotification = 0;
    }

    /**
     * Parameterised constructor for class Author
     */
    public Author (String newAuthorName, String newAuthorLastName, String newAuthorMailID, ArrayList<Paper> newArrPaper, int newReviewNotification){
        authorFirstName = newAuthorName;
        authorLastName = newAuthorLastName;
        authorMailID = newAuthorMailID;
        arrPaper = newArrPaper;
        reviewNotification = newReviewNotification;
    }

    /**
     * Accessor method for the first name of the author
     * return type String
     */
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    /**
     * Accessor method for the last name of the author
     * return type String
     */
    public String getAuthorLastName() {
        return authorLastName;
    }

    /**
     * Accessor method for the email id of the author
     * @return type String containing email id
     */
    public String getAuthorMailID() {
        return authorMailID;
    }

    /**
     * Accessor method for the review notification
     * @return type int referring to the number of notifications
     */
    public int getReviewNotification() {
        return reviewNotification;
    }

    /**
     * Mutator method for the review notification
     * @param reviewNotification
     */
    public void setReviewNotification(int reviewNotification) {
        this.reviewNotification = reviewNotification;
    }

    /**
     * Mutator method for the first name of the author
     * @param authorFirstName
     */
    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    /**
     * Mutator method for the last name of the author
     * @param authorLastName
     */
    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    /**
     * Mutator method for the email id of the author
     * @param authorMailID
     */
    public void setAuthorMailID(String authorMailID) {
        this.authorMailID = authorMailID;
    }

    /**
     * Method to validate the email ID
     * @param authorMailID
     * @return boolean
     */
    public boolean checkMailID(String authorMailID) {
        String pattern = ".*@.*";
        boolean result =  Pattern.matches(pattern, authorMailID);
        return result;
    }

    /**
     * Method to display the details of the Paper
     */
    public void displayPaperDetails() {
        for (Paper tempPaper : arrPaper)
        {
            System.out.println("Paper Name : " + tempPaper.getPaperName());
            System.out.println("Keywords   : " + tempPaper.getKeywords());
            System.out.println("Submission Status : " + tempPaper.isSubmissionStatus());
            System.out.println("File name : " + tempPaper.getFileName());
        }

    }

    /**
     * Method to write the author details to a file authorDetails.txt
     */
    public void addAuthor() {
        final String OUT_FILE = "authorDetails.txt";
        String newAuthor = authorFirstName + "," + authorLastName + "," + authorMailID;
        for (Paper tempPaper : arrPaper)
        {
            newAuthor = newAuthor + "," + tempPaper.getPaperName() + "," + tempPaper.getKeywords() + "," + tempPaper.getFileName() + "," + tempPaper.isSubmissionStatus();
        }
        newAuthor = newAuthor + "\n";
        try
        {
            PrintWriter output = new PrintWriter(OUT_FILE);
            output.write(newAuthor);
            output.close();
        }
        catch (Exception e)
        {
            System.out.println("Error in writing file");
        }
    }
}
