package bg.softuni.LinkedOut.model.entity;

import bg.softuni.LinkedOut.model.enums.EducationLevel;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_level", nullable = false)
    private EducationLevel educationLevel;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToOne
    private Company company;
    public UUID getId() {
        return id;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Employee setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public Employee setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Employee setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Employee setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Employee setCompany(Company company) {
        this.company = company;
        return this;
    }
}
