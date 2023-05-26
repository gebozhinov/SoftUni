package bg.softuni.nextleveltechnologies.model.enitities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "employees")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @ManyToOne(optional = false)
    private Project project;

    @Override
    public String toString() {
        return "Employee name: " + firstName + " " + lastName + "\n" +
                "   Age: " + age + "\n" +
                "   Project name: " + project.getName();
    }
}
