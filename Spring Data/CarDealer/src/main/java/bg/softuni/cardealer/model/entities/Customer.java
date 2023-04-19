package bg.softuni.cardealer.model.entities;

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

    @Transient
    private BigDecimal spentMoney;
    public BigDecimal calculateSpentMoney() {
        BigDecimal sum = new BigDecimal(0);
        for (Sale sale : this.sales) {
            sum = sum.add(sale.calculatePrice());
        }
        if (isYoungDriver) {
            sum = sum.multiply(BigDecimal.valueOf(0.95));
        }
        this.spentMoney = sum;
        return sum;
    }


}
