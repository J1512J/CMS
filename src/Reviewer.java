import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reviewer
{
    int limitNumberOfReviewers;
    String evaluationOfPaper;
    ArrayList<String[]> paperList = new ArrayList<String[]>();


    public Reviewer(){

    }

    public Reviewer(int limitNumberOfReviewers,String evaluationOfPaper)
    {

        this.limitNumberOfReviewers = limitNumberOfReviewers;
        this.evaluationOfPaper = evaluationOfPaper;
    }

    public int getLimitNumberOfReviewers()
    {
        return limitNumberOfReviewers;
    }
    public String getEvaluationOfPaper()
    {
        return evaluationOfPaper;
    }

    public void setLimitNumberOfReviewers(int limitNumberOfReviewers)
    {
        this.limitNumberOfReviewers = limitNumberOfReviewers;

    }
    public void setEvaluationOfPaper(String evaluationOfPaper)
    {
        this.evaluationOfPaper = evaluationOfPaper;
    }

    public ArrayList<String[]> getPaperList() {
        try{
            File filePaper = new File("paperDatabase.txt");
            Scanner fileRead = new Scanner(filePaper);
            while (fileRead.hasNextLine())
            {
                String line = fileRead.nextLine().trim();
                String[] fieldPaper = line.split(",");
                paperList.add(fieldPaper);
            }
            fileRead.close();
            return paperList;
        }
        catch (NullPointerException | FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return null;
    }
}

