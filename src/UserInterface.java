import java.util.*;

/**
 * Methods to display all interfaces for the user
 *
 * @author (venkata karthikeya ravilla, Tejas Deepak)
 * @version (23/05/21)
 */
public class UserInterface {

    String input;

    public UserInterface(){
        input = "";
    }

    Scanner scanner = new Scanner(System.in);

    /**
     * Method to display the main screen to the actor
     * Options to create a new user or log in as existing user
     */
    public int displayMainScreen() {
        System.out.println("Choose one of the options below to proceed");
        System.out.println("Enter 1 to Login as an Existing user");
        System.out.println("Enter 2 to Register as a new User");
        System.out.println("Enter your option below :");
        Scanner scanner = new Scanner(System.in);
        char userInput;
        userInput = scanner.next().charAt(0);
        switch (userInput) {
            case '1':
                return 1;
            case '2':
                return 2;
            default:
                System.out.println("Please enter valid input !");
                break;
        }
        return 0;
    }


    /**
     * Method to display the Admin user features
     * @return int which is the response from the user
     */
    public int displayAdminFeatures()
    {
        System.out.println("Welcome to Admin main screen ");
        System.out.println("Enter 1 to retrieve information about registered users");
        System.out.println("Enter 2 to retrieve information about registered conferences");
        System.out.println("Enter 3 to retrieve information about Submitted Papers");
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        userInput = scanner.nextInt();
        switch (userInput)
        {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                System.out.println("Entered Input is invalid");
                System.out.println("Enter a valid input");
                displayAdminFeatures();
                break;
        }
        return 0;
    }

    /**
     * Method to display the Author user features
     * @return int which is the response from the user
     */
    public int displayAuthorFeatures()
    {
        System.out.println("Welcome to Author main screen");
        System.out.println("Enter 1 to Submit Paper");
        System.out.println("Enter 2 to View submitted paper status");
        System.out.println("Enter 3 to return to main screen");
        Scanner scanner = new Scanner(System.in);
        char userInput;
        userInput = scanner.next().charAt(0);
        switch (userInput)
        {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            default:
                System.out.println("Enter Valid input");
                displayAuthorFeatures();
                break;
        }
        return 0;
    }

    public int displayChairFeatures()
    {
        System.out.println("Welcome to Chair main screen");
        System.out.println("Enter 1 to Submit Conference information");
        System.out.println("Enter 2 to Modify conference deadline");
        System.out.println("Enter 3 to send review notifications to author");
        System.out.println("Enter 4 to make the final decision on paper review");
        Scanner scanner = new Scanner(System.in);
        char userInput;
        userInput = scanner.next().charAt(0);
        switch (userInput)
        {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            default:
                System.out.println("Enter Valid input");
                displayAuthorFeatures();
                break;
        }
        return 0;
    }
    public int displayReviewerFeatures()
    {
        System.out.println("Welcome to Reviewer main screen");
        System.out.println("Enter 1 To do the evaluation of paper");
        Scanner scanner = new Scanner(System.in);
        char userInput;
        userInput = scanner.next().charAt(0);
        switch (userInput)
        {
            case '1':
                return 1;
            default:
                System.out.println("Enter Valid input");
                displayReviewerFeatures();
                break;
        }
        return 0;
    }
}
