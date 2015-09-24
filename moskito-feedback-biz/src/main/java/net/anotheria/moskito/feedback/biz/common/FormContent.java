package net.anotheria.moskito.feedback.biz.common;

/**
 * @author andriiskrypnyk
 *
 *         Content of the form filled up by customer
 */

public class FormContent {

    private String firstName;

    private String lastName;

    private String companyEmail;

    private String description;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FormContent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
