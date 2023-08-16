package bg.softuni.LinkedOut.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal budget;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String town;

    @OneToMany(targetEntity = Employee.class, mappedBy = "company")
    private Set<Employee> employees;

    public UUID getId() {
        return id;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public Company setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public Company setTown(String town) {
        this.town = town;
        return this;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Company setEmployees(Set<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
