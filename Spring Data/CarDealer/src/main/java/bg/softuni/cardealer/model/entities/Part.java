package bg.softuni.cardealer.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "parts")
public class Part extends BaseEntity {

    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private int quantity;

    @ManyToMany(mappedBy = "parts", cascade = CascadeType.MERGE)
    private Set<Car> cars;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Supplier supplier;

}
