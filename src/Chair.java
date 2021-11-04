import java.util.Date;
public class Chair {

private String reviewNotifications;
private boolean finalDecision;
private Date modifyDeadlineDate;
private String assignPaper;

    public boolean isFinalDecision() {

        return finalDecision;
    }

    public Date getModifyDeadlineDate() {

        return modifyDeadlineDate;
    }

    public String getAssignPaper() {

        return assignPaper;
    }

    public String getReviewNotifications() {

        return reviewNotifications;
    }

    public void setAssignPaper(String assignPaper) {

        this.assignPaper = assignPaper;
    }

    public void setFinalDecision(boolean finalDecision) {

        this.finalDecision = finalDecision;
    }

    public void setModifyDeadlineDate(Date modifyDeadlineDate) {

        this.modifyDeadlineDate = modifyDeadlineDate;
    }

    public void setReviewNotifications(String reviewNotifications) {

        this.reviewNotifications = reviewNotifications;
    }
}

