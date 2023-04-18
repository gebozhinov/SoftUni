package bg.softuni.cardealer.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Column
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "is_young_driver")
    private boolean isYoungDriver;
    @OneToMany(targetEntity = Sale.class, mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Sale> sales;

}
