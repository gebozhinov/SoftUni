package bg.softuni.nextleveltechnologies.model.enitities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "projects")
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal payment;

    @Column(name = "start_date")
    private LocalDate startDate;

    @ManyToOne(optional = false)
    private Company company;

    @OneToMany(targetEntity = Employee.class, mappedBy = "project")
    private Set<Employee> employees;


    @Override
    public String toString() {
        return "Project: \n" +
                "   name: " + name + "\n" +
                "   description: " + description + "\n" +
                "   is finished: " + isFinished + "\n" +
                "   payment: " + payment + "\n" +
                "   start date: " + startDate + "\n" +
                "   " + company;
    }
}
