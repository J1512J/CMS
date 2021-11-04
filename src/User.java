import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Holds the information regarding the user like;
 * first name, last name, email id, password, highest qualification, occupation, employer details,
 * mobile number, interest areas and role.
 * Accessor and mutator methods for the parameters mentioned above
 * Method to write parameters into file containing user details
 * Method to display user parameters
 *
 *@author (venkata karthikeya ravilla)
 */
public class User
{
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userPassword;
    private String highestQualification;
    private String userOccupation;
    private String employerDetails;
    private String mobileNumber;
    private String interestArea;
    private String role;


    /**
     * Constructor for class User
     */
    public User ()
    {
        firstName = "John";
        lastName = "Doe";
        userEmail = "johndoe@gmail.com";
        userPassword = "johndoe123";
        highestQualification = "Masters";
        userOccupation = "Student";
        employerDetails = "Monash";
        mobileNumber = "1234567890";
        interestArea = "Engineering";
        role = "Admin";
    }

    /**
     * Parameterised constructor for User class
     * @param newFirstName
     * @param newLastName
     * @param newUserEmail
     * @param newUserPassword
     * @param newHighestQualification
     * @param newUserOccupation
     * @param newEmployerDetails
     * @param newMobileNumber
     * @param newInterestArea
     * @param newRole
     */
    public User( String newFirstName, String newLastName, String newUserEmail, String newUserPassword, String newHighestQualification,
                 String newUserOccupation, String newEmployerDetails, String newMobileNumber, String newInterestArea, String newRole)
    {
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.userEmail = newUserEmail;
        this.userPassword = newUserPassword;
        this.highestQualification = newHighestQualification;
        this.userOccupation = newUserOccupation;
        this.employerDetails = newEmployerDetails;
        this.mobileNumber = newMobileNumber;
        this.interestArea = newInterestArea;
        this.role = newRole;
    }

    /**
     * Accessor method for user first name
     * @param firstName
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Accessor method for user last name
     * @param lastName
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Accessor method for user email id
     * @param userEmail
     */
    public void setEmail(String userEmail){
        this.userEmail = userEmail;
    }

    /**
     * Accessor method for user password
     * @param userPassword
     */
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    /**
     * Accessor method for user's highest qualification
     * @param highestQualification
     */
    public void setHighestQualification(String highestQualification){
        this.highestQualification = highestQualification;
    }

    /**
     * Accessor method for user's occupation
     * @param userOccupation
     */
    public void setUserOccupation(String userOccupation){
        this.userOccupation = userOccupation;
    }

    /**
     * Accessor method for user's employer details
     * @param employerDetails
     */
    public void setEmployerDetails(String employerDetails){
        this.employerDetails = employerDetails;
    }

    /**
     * Accessor method for user mobile number
     * @param mobileNumber
     */
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    /**
     * Accessor method for user's interest area
     * @param interestArea
     */
    public void setInterestArea(String interestArea){
        this.interestArea = interestArea;
    }

    /**
     * Accessor method for user role
     * @param role
     */
    public void setRole(String role){
        this.role = role;
    }

    /**
     * Mutator method for user first name
     * @return String
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Mutator method for user last name
     * @return String
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Mutator method for user email id
     * @return String
     */
    public String getUserEmail(){
        return userEmail;
    }

    /**
     * Mutator method for user password
     * @return String
     */
    public String getUserPassword(){
        return userPassword;
    }

    /**
     * Mutator method for user's highest qualification
     * @return String
     */
    public String getHighestQualification(){
        return highestQualification;
    }

    /**
     * Mutator method for user's occupation
     * @return String
     */
    public String getUserOccupation(){
        return userOccupation;
    }

    /**
     * Mutator method for user employer details
     * @return String
     */
    public String getEmployerDetails(){
        return employerDetails;
    }

    /**
     * Mutator method for user mobile number
     * @return String
     */
    public String getMobileNumber(){
        return mobileNumber;
    }

    /**
     * Mutator method for user interest area
     * @return String[]
     */
    public String getInterestArea(){
        return interestArea;
    }

    /**
     * Mutator method for user role
     * @return String
     */
    public String getRole(){
        return role;
    }

    /**
     * Method to write user details into file "UserDetails.txt"
     */
    public void addUser(){
        String newUser = firstName + "," + lastName + "," + userEmail + "," + userPassword + "," +
                highestQualification + "," + userOccupation + "," + employerDetails + "," +
                mobileNumber + "," + interestArea + "," + role + "\n";

        File myObj = new File("UserDetails.txt");
        FileWriter myWriter = null;
        try
        {
            myWriter = new FileWriter("UserDetails.txt", true);
            myWriter.write(newUser);
            myWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}