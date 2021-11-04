import java.io.*;
import java.util.*;
import java.text.*;

//package com.javapoint;

/**
 * Description of class paper
 *
 * Holds information about the paper like paper name, keywords, submission status and file name of the paper.
 * Methods to access and mutate the parameters mentioned above.
 * Methods to Read and Write the paper name, keywords and file name into the file
 * Method to check the file type
 *
 * @author (Tejas Deepak)
 * @version (22 / 05 / 21)
 */
public class Paper {
    private String paperName;
    private String keywords;
    private String fileName;
    private boolean submissionStatus;

    private final String OUT_FILE = "paperDatabase.txt";
    private final String IN_FILE = "paperDatabase.txt";

    /**
     * Constructor for class Paper
     */
    public Paper ()
    {
        paperName = "Software Engineering Assignment Code";
        keywords = "Software, Engineering, Assingment, Code";
        fileName = "assignmentCode.pdf";
        submissionStatus = true;
    }

    /**
     * Parameterised constructor for class Paper
     */
    public Paper (String newPaperName, String newKeywords, String newFileName, boolean newSubmissionStatus)
    {
        paperName = newPaperName;
        keywords = newKeywords;
        fileName = newFileName;
        submissionStatus = newSubmissionStatus;
    }

    /**
     * Accessor method for the name of the paper
     * return type String
     */
    public String getPaperName() {
        return paperName;
    }

    /**
     * Accessor method for the keywords in the paper
     * return type Array of String
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Mutator method for the keywords in the paper
     * @param newKeyword
     */
    public void setKeywords(String newKeyword) {
            this.keywords = newKeyword;
    }

    /**
     * Mutator method for the name of the paper
     * @param paperName
     */
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    /**
     * Accessor method for the submission status
     * return type String
     */
    public  String isSubmissionStatus() {
        return this.realSubmissionStatus(submissionStatus);
    }

    /**
     * Mutator method for the submission status
     * @param submissionStatus
     */
    public void setSubmissionStatus(boolean submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    /**
     * Accessor method for the name of the file
     * return type String
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Mutator method for the name of the file
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method to write the paper name into the file
     */
    public void writePaperData() {
        String paperData = paperName + "," + submissionStatus + "," + fileName + "," + keywords + "\n";

        File myObj = new File(OUT_FILE);
        FileWriter output = null;
        try {
           output = new FileWriter(OUT_FILE, true);
           output.write(paperData);
           output.close();
        }
        catch (Exception e) {
            System.out.println("Error in writing file");
        }
    }

    /**
     * Method to read the paper names from the file
     * return type String
     */
    public void readPaperData() {
        String fileLine = null;
        try {
            FileReader input = null;
            try {
                input = new FileReader(IN_FILE);
                Scanner console = new Scanner(input);

                fileLine = console.nextLine();
//                paperName = fileLine;

            }
            finally {
                input.close();
                System.out.println(fileLine);
            }
        }catch (FileNotFoundException exception){
            System.out.println(IN_FILE + " not found");
        }catch (IOException exception){
            System.out.println("Unexpected I/O error occured");
        }
    }

    /**
     * Method to check the file type
     * @param fileName
     */
    public boolean checkFileType(String fileName)
    {
        String substring ;
        int len = fileName.length();
        substring = fileName.substring(len-3, len);
        if (substring.equals("pdf"))
        {
            return true;
        }
        else {
            System.out.println("Incorrect file format");
            return false;
        }
    }

    /**
     * Method to return submission status in String format instead of Boolean
     * @param submissionStatus
     * @return String
     */
    public String realSubmissionStatus (boolean submissionStatus)
    {
        String status;
        if (submissionStatus == true)
        {
            status = "Submitted";
        }
        else
        {
            status = "Rejected";
        }
        return  status;
    }

    /**
     * Method to write paper name to a new file
     */
    public ArrayList<String> getOnlyPapers() {
        ArrayList<String> paperList = new ArrayList<String>();
        try {
            File fileObject = new File("paperDatabase.txt");
            Scanner fileReader = new Scanner(fileObject);

            String paperName = null;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                String[] papersField = line.split(",");
                paperName = papersField[2];
                paperList.add(paperName);
            }
            fileReader.close();
            System.out.println(paperList);
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return paperList;
    }
}