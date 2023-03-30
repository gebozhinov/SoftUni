package bg.softuni.automappingobjects.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(nullable = false)
    private BigDecimal salary;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(name = "is_on_holiday")
    private boolean isOnHoliday;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Address address;
    @ManyToOne(optional = false)
    private Employee manager;
    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }
}
