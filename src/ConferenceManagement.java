/**
@author (Ronald Etyeku)
@version (10/05/21)
*/
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;



class ConferenceManagement {

private String name;
private String title;
private String topics;
private int submittedPapers;
private String deadline;
private String conferenceList;
private String conferenceSet;
private String chair;


        public String  getName() {
                return name;
        }

        public String getTopics() {
                return topics;
        }

        public String getTitle() {
                return title;
        }

        public String getDeadline() {
                return deadline;
        }

        public int getSubmittedPapers() {
                return submittedPapers;
        }

        public String getConferenceList() {
                return conferenceList;
        }

        public String getConferenceSet() {
                return conferenceSet;

        }
        public void setConferenceList(String conferenceList) {
                this.conferenceList = conferenceList;
        }

        public void setDeadline(String deadline) {
                this.deadline = deadline;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setConferenceSet(String conferenceSet) {
                this.conferenceSet = conferenceSet;
        }

        public void setSubmittedPapers(int submittedPapers) {
                this.submittedPapers = submittedPapers;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public void setTopics(String topics) {
                this.topics = topics;
        }


        public void conferenceSave()
        {
                ArrayList<Object> newConference = new ArrayList<Object>();
                newConference.add(name);
                newConference.add(title);
                newConference.add(topics);
                newConference.add(deadline);
                newConference.add(submittedPapers);
                try {
                        FileWriter myWriter = new FileWriter("ConferenceDatabase.txt");
                        myWriter.write(String.valueOf(newConference) + "\n");
                        myWriter.close();

                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
        }
    }

