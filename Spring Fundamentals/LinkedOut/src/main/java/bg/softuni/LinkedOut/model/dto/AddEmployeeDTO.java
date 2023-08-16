package bg.softuni.LinkedOut.model.dto;

import bg.softuni.LinkedOut.model.enums.EducationLevel;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;


public class AddEmployeeDTO {

    @NotBlank(message = "Enter first name.")
    @Size(min = 2, message = "First name must be at least 2 characters.")
    private String firstName;
    @NotBlank(message = "Enter last name.")
    @Size(min = 2, message = "Last name must be at least 2 characters.")
    private String lastName;
    @NotNull
    private EducationLevel educationLevel;

    @NotNull
    private String companyName;
    @NotBlank
    private String jobTitle;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @NotNull(message = "Enter salary.")
    @DecimalMin(value = "0", message = "Salary must be positive number.")
    private BigDecimal salary;

    public String getFirstName() {
        return firstName;
    }

    public AddEmployeeDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AddEmployeeDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public AddEmployeeDTO setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public AddEmployeeDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public AddEmployeeDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public AddEmployeeDTO setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public AddEmployeeDTO setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }
}
