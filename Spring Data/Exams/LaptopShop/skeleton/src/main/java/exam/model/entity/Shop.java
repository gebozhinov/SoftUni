package exam.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "shops")
@Entity
public class Shop extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private BigDecimal income;

    @Column(nullable = false)
    private String address;

    @Column(name = "employee_count", nullable = false)
    private Integer employeeCount;

    @Column(name = "shop_area", nullable = false)
    private Integer shopArea;

    @ManyToOne
    private Town town;

    @OneToMany(targetEntity = Laptop.class, mappedBy = "shop")
    private Set<Laptop> laptops;
}
