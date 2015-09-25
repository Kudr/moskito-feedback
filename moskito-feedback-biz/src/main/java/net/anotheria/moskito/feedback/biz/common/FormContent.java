package net.anotheria.moskito.feedback.biz.common;

/**
 * @author andriiskrypnyk
 *         <p/>
 *         Content of the form filled up by customer
 */

public class FormContent {

    private String fName;

    private String lName;

    private String email;

    private String company;

    private String note;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FormContent{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
