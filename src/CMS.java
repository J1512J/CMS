import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Mediates between boundary and entity classes
 * Contains objects of the Entity classes
 * Methods to verify user log-in details
 * Method to validate user email id, mobile number and password
 * Methods to complete the various features of the users
 *
 * @author (venkata karthikeya ravilla, Tejas Deepak)
 * @version (23/05/21)
 */
public class CMS
{
    Admin objAdmin = new Admin();
    Author objAuthor = new Author();
    Paper objPaper = new Paper();
    //private ArrayList<User> userList;
    User objUser = new User();
    UserInterface objUserInterface = new UserInterface();
    ConferenceManagement cfm = new ConferenceManagement();

    Reviewer objReviewer = new Reviewer();

    private String role;
    private String userInfo;
    private int notificationCount;

    //public CMS(){}

    /**
     * Main method for application
     */
    public static void main(String[] args) {

        UserInterface objUserInterface = new UserInterface();
        Author objAuthor = new Author();
        Paper objPaper = new Paper();
        User objUser = new User();
        //ConferenceManagement cfm = new ConferenceManagement();
        Admin objAdmin = new Admin();
        CMS cms = new CMS();

        String role = null;
        int userRole = 0;


        Scanner scanner = new Scanner(System.in);
        int flag;
        int response;
        String userInput;

        String fRole = null;
        response = objUserInterface.displayMainScreen();
        if (response == 1)
        {
            userInput = cms.userLogin();
            cms.doVerification(userInput);
            //fRole = scanner.next();
        }
        else if (response == 2)
        {
            cms.userRegistration();

        }
        System.out.println("Enter Role :");
        fRole = scanner.next();

        switch (fRole.toLowerCase())
        {
            case "admin":
                do {
                    response = objUserInterface.displayAdminFeatures();
                    switch (response)
                    {
                        case 1:
                            objAdmin.getRegisteredUsers();
                            break;
                        case 2:
                            objAdmin.getRegisteredConferences();
                            break;
                        case 3:
                            objAdmin.getSubmittedPapers();
                            break;
                        default:
                            System.out.println("Error in the Admin case");
                            break;
                    }
                    System.out.println("Enter 0 to return to Admin screen or anything else to return to Main screen");
                    flag = scanner.nextInt();
                }
                while (flag == 0);
                objUserInterface.displayMainScreen();
                break;
            case "chair":
                do {
                    response = objUserInterface.displayChairFeatures();
                    switch (response)
                    {
                        case 1:
                            cms.setConferenceInformation();
                            break;
                        case 2:
                            cms.modifyDeadline();
                            break;
                        case 3:
                            cms.sendReviewNotification();
                            break;
                        case 4:
                            cms.decideFinalOutcome();
                            break;
                        default:
                            System.out.println("Error in Chair case");
                            break;
                    }
                    System.out.println("Enter 1 to return to Chair Screen");
                    flag = scanner.nextInt();
                }
                while (flag == 1);
                objUserInterface.displayMainScreen();
                break;
            case "author":
                do {
                    if (objAuthor.getReviewNotification() < cms.notificationCount) {
                        System.out.println("Review of paper received !");
                        objAuthor.setReviewNotification(cms.notificationCount);
                    }
                    response = objUserInterface.displayAuthorFeatures();
                    switch (response)
                    {
                        case 1:
                            cms.getPaperDetails();
                            break;
                        case 2:
                            objPaper.getOnlyPapers();
                            break;
                        case 3:
                            objUserInterface.displayMainScreen();
                            break;
                        default:
                            System.out.println("Error in Author case");
                            break;
                    }
                    System.out.println("Enter 1 to return to Author screen");
                    flag = scanner.nextInt();
                }
                while (flag == 1);
                objUserInterface.displayMainScreen();
                break;
            case "reviewer":
                do {
                    response = objUserInterface.displayReviewerFeatures();
                    switch (response)
                    {
                        case 1:
                            cms.submitEvaluation();
                            break;
                        default:
                            System.out.println("Error in Reviewer case");
                            break;
                    }
                    System.out.println("Enter 1 to return to the Reviewer screen");
                    flag = scanner.nextInt();
                }
                while (flag == 1);
                objUserInterface.displayMainScreen();
                break;
            default:
                System.out.println("Entered role doesn't exist");
                objUserInterface.displayMainScreen();
                break;
        }
    }


    /**
     * Method to verify the entered user information
     *
     * @param userInfo String that contains the user information
     */
    public void doVerification(String userInfo) {
        if (getLoginList().contains(userInfo)) {
            System.out.println("Your details are successfully verified");
        }
        else
        {
            System.out.println("Entered input is incorrect");
            System.out.println("Enter valid input");
            objUserInterface.displayMainScreen();
        }
    }

    /**
     * Method to accept the username, password and role from user to log-in to the CMS system
     *
     * @return String which contains the user information
     */
    public String userLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your registered Email as Username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your registered Password: ");
        String passWord = scanner.nextLine();
        System.out.print("Enter your registered role: ");
        String role = scanner.nextLine();
        userInfo = userName + "," + passWord + "," + role;
        return userInfo;
    }

    /**
     * Method to register new users by taking input from the user and adding it to the database(UserDetails.txt file)
     */
    public void userRegistration() {


        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        objUser.setFirstName(sc.next());
        System.out.print("Enter Last Name: ");
        objUser.setLastName(sc.next());
        verifyEmail();
        verifyPassword();
        System.out.print("Enter Highest Qualification: ");
        objUser.setHighestQualification(sc.next());
        System.out.print("Enter User Occupation: ");
        objUser.setUserOccupation(sc.next());
        System.out.print("Enter Employer Details: ");
        objUser.setEmployerDetails(sc.next());
        verifyMobileNumber();
        System.out.print("Enter Interest Area: ");
        objUser.setInterestArea(sc.next());
        System.out.print("Enter Role: ");
        objUser.setRole(sc.next());

        objUser.addUser();

    }

    /**
     * Method For validating password with respect to specified requirements
    */
    public void verifyPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password greater than 8 characters long and contains a numerical value");
        System.out.print("Enter Password: ");
        String pass = scanner.next();
        if (pass.length() > 8 && pass.matches(".*\\d.*")) {
            objUser.setUserPassword(pass);
        } else {
            System.out.println("Entered password doesn't match the requirements");
            verifyPassword();
        }
    }

    /**
     * Method For validating Email with respect to specified requirements
     */
    public void verifyEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a valid email containing @");
        System.out.print("Enter Email: ");
        String mail = scanner.next();
        if (mail.contains("@")) {
            objUser.setEmail(mail);
        } else {
            System.out.println("Entered email doesn't match the requirements");
            verifyEmail();
        }
    }

    /**
     * Method For validating mobile number with respect to specified requirements
     */
    public void verifyMobileNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mobile number with 10 characters long numeric");
        System.out.print("Enter Mobile Number: ");
        String mNum = scanner.next();
        int i = Integer.parseInt(mNum);

        if (mNum.length() == 10) {
            objUser.setMobileNumber(mNum);
        } else {
            System.out.println("Entered Mobile Number doesn't match the requirements");
            verifyMobileNumber();
        }
    }

    /**
     * Method for setting and submitting the conference information
     * action when entered displayChairfetures() and 1
     * */
    public void setConferenceInformation()
    {
        try {
            FileWriter myWriter = new FileWriter("ConferenceDetails.txt", true);
            Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
            System.out.print("Enter conference name: ");
            cfm.setName(sc.nextLine());
            System.out.print("Enter the title: ");
            cfm.setTitle(sc.nextLine());
            System.out.print("Enter the Topic: ");
            cfm.setTopics(sc.nextLine());
            System.out.println("Enter the Deadline in DD/MM/YYYY format");
            System.out.print("Enter the Deadline: ");
            cfm.setDeadline(sc.nextLine());
            String conferenceInfo = cfm.getName()+ "," + cfm.getTitle()+ "," + cfm.getTopics() + "," + cfm.getDeadline() + "\n";
            myWriter.write(conferenceInfo);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Method to modify conference deadline
     * action when entered displayChairfetures() and 2
     * */
    public void modifyDeadline() {
        try {
            Scanner scanner = new Scanner(System.in);
            File fileObject = new File("ConferenceDetails.txt");

            Scanner fileReader = new Scanner(fileObject);
            StringBuffer buffer = new StringBuffer();
            String conferenceDetails = null;
            while (fileReader.hasNextLine()) {
                buffer.append(fileReader.nextLine());
            }
            String conferenceData = buffer.toString();
            //closing the Scanner object
            fileReader.close();

            System.out.print("Enter your conference name you want to modify: ");
            String confName = scanner.nextLine();
            System.out.print("Enter your conference title you want to modify: ");
            String confTitle = scanner.nextLine();
            System.out.print("Enter your conference topics you want to modify: ");
            String confTopics = scanner.nextLine();
            System.out.print("Enter your conference deadline you want to modify: ");
            String confDeadline = scanner.nextLine();
            System.out.print("Enter the conference's new deadline : ");
            String newConfDeadline = scanner.nextLine();
            String confDetails = confName + "," + confTitle + "," + confTopics + "," + confDeadline;
            if (!conferenceData.contains(confDetails)) {
                System.out.println("Entered conference details doesn't exist, try agian with valid details");
                modifyDeadline();
            } else {
                String newConfDetails = "\n" + confName + "," + confTitle + "," + confTopics + "," + newConfDeadline + "\n";
                String newConfprint = "Conference Name: " + confName + "," + "Conference Title: " + confTitle + "," + "Conference Topics: " + confTopics + "," + "New Conference Deadline: " + newConfDeadline;
                //Replacing the old line with new line
                conferenceData = conferenceData.replaceAll(confDetails, newConfDetails);
                //instantiating the FileWriter class
                FileWriter writer = new FileWriter("conferenceDetails.txt", true);
                System.out.println("--==--");
                System.out.println("replaced conference deadline is " + newConfprint);
                writer.append(conferenceData + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to return an Arraylist of strings containing only username,password and role
     * Used in user login method
     */
    public ArrayList<String> getLoginList(){
        ArrayList<String> loginList = new ArrayList<String>();
        try {
            File fileObject = new File("UserDetails.txt");
            Scanner fileReader = new Scanner(fileObject);
            String loginDetails = null;

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] userField = line.split(",");
                String userName = userField[2];
                objUser.setEmail(userName);
                String passWord = userField[3];
                objUser.setUserPassword(passWord);
                String role = userField[9];
                objUser.setRole(role);
                loginDetails = userName + "," + passWord + "," + role;
                loginList.add(loginDetails);
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return loginList;
    }

    /**
     * Method of Review class
     * */
    public String limitOFReviewers()
    {
        int limit = objReviewer.getLimitNumberOfReviewers();
        if(limit <= 3 || limit == 4 )
        {
            submitEvaluation();
            return "The number of reviewers assigned to this paper are" + String.valueOf(limit);
        }
        else {
            return "maximum number of reviewers are assigned to this paper";
        }
    }

    /**
     * Method to submit evaluation for the reviewer
     * */

    public void submitEvaluation() {


        ArrayList<String[]> paperList = new ArrayList<String[]>();
        paperList = objReviewer.getPaperList();
        String userInput;
        String name = null;
        String evaluation = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println(" CHOOSE THE AREA OF EXPERTISE ");
        System.out.println(" 0 - Artificial Intelligence, 1 - Cybersecurity, 2 - Cloud Computing, 3 - Data Analysis,\n" +
                                     " 4- Communication and Transportation ");
        int enter = scanner.nextInt();
        if(enter >= 0 && enter <= 4)
        {
            System.out.println("Available area of expertise");
        }
        else {
            System.out.println(" enter valid number ");
            submitEvaluation();
        }

        System.out.println("Select the a paper to evaluate");
        System.out.println("Enter name of the paper including the square brackets");
        //for (int i = 0; i < objPaper.getOnlyPapers().size(); i++) {
            name = scanner.next();
            if (objPaper.getOnlyPapers().contains(name)) {
                 System.out.println("Enter the evaluation of this paper");
                    evaluation = scanner.next();
            } else {
                 System.out.println("The paper is not available");
                 System.out.println("Please enter valid name");
                 submitEvaluation();
            }
        //}
        try {
            FileWriter myWriter = new FileWriter("EvaluationDatabase.txt");
            myWriter.write(name + "-" + evaluation + "\n");
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Method to get the paper details from the user
     */
    public void getPaperDetails(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Paper name");
        objPaper.setPaperName(scanner.nextLine());
        objPaper.setSubmissionStatus(false);
        System.out.println("Enter Keywords");
        objPaper.setKeywords(scanner.nextLine());

        String tempFileName = null;
        String fileName = null;
        int flag = 0;
        while (flag != 1)
        {
            System.out.println("Enter the file name");
            tempFileName = scanner.nextLine();
            if (objPaper.checkFileType(tempFileName) == true)
            {
                fileName = tempFileName;
                flag = 1;
            }
            else
            {
                flag = 0;
            }
        }
        objPaper.setFileName(fileName);
        objPaper.writePaperData();
    }

    /**
     * Method that sends the review notification to the author from the chair
     */
    public void sendReviewNotification() {
        notificationCount = objAuthor.getReviewNotification() + 1;
        //objAuthor.setReviewNotification(notificationCount);
        System.out.println("Review Notification Sent");
    }

    /**
     * Method to decide final outcome of paper
     */
    public void decideFinalOutcome(){

        try {
            Scanner scanner = new Scanner(System.in);
            File fileObject = new File("EvaluationDatabase.txt");

            Scanner fileReader = new Scanner(fileObject);
            StringBuffer buffer = new StringBuffer();
            String paperDetails = null;
            String pName = null;
            String review = null;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                buffer.append(line);

                String[] paperField = line.split("-");
                System.out.println("Paper Name: " + paperField[0]);
                pName = paperField[0];
                System.out.println("Review given by reviewer: " + paperField[1]);
                review = paperField[1];
                System.out.println("\n");
            }
            String paperData = buffer.toString();
            //closing the Scanner object
            fileReader.close();

            System.out.println("Enter paper name to view its review and decide final outcome");
            String paperName = scanner.next();
            if (!pName.equals(paperName)) {
                System.out.println("Entered paper details doesn't exist, try again with valid details");
                decideFinalOutcome();
            } else {
                System.out.println("Enter final outcome for entered paper");
                String finalOutcome = scanner.next();
                paperDetails = paperName + "-" + review;
                String newPaperDetails = paperName + "-" + review + "-" + finalOutcome + "\n";
                String newPaperprint = "Paper Name: " + paperName + "," + "Paper Review " + review + "," + "Paper Final outcome: " + finalOutcome;
                //Replacing the old line with new line
                paperData = paperData.replaceAll(paperDetails, newPaperDetails);
                //instantiating the FileWriter class
                FileWriter writer = new FileWriter("FinalOutcomeDetails.txt",true);
                System.out.println("--==--");
                System.out.println("New paper details including final outcome" + newPaperprint);
                writer.append(paperData + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}