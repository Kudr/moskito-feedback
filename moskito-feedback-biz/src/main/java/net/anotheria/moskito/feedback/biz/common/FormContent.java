package net.anotheria.moskito.feedback.biz.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author andriiskrypnyk
 *         <p/>
 *         Content of the form filled up by customer
 */

public class FormContent {

    private String fName;

    private String lName;

    private String cEmail;

    private String cCompany;

    @JsonProperty("Note")
    private String Note;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcCompany() {
        return cCompany;
    }

    public void setcCompany(String cCompany) {
        this.cCompany = cCompany;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        this.Note = note;
    }

    @Override
    public String toString() {
        return "FormContent{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cCompany='" + cCompany + '\'' +
                ", Note='" + Note + '\'' +
                '}';
    }
}
