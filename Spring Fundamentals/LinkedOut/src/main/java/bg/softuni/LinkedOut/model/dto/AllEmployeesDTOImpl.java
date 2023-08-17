package bg.softuni.LinkedOut.model.dto;

import java.time.LocalDate;

public class AllEmployeesDTOImpl {

    String fullName;
    String jobTitle;
    LocalDate birthdate;

    public String getFullName() {
        return fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public AllEmployeesDTOImpl setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public AllEmployeesDTOImpl setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public AllEmployeesDTOImpl setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }
}
