package bg.softuni.cardealer.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Column
    private double discount;
    @OneToOne
    private Car car;
    @ManyToOne
    private Customer customer;

    @Transient
    private BigDecimal price;
    @Transient
    private BigDecimal priceWithDiscount;

    public BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal(0);
        for (Part part : car.getParts()) {
            price = price.add(part.getPrice());
        }
        this.price = price;
        this.priceWithDiscount = price.multiply(BigDecimal.valueOf(1 - (discount / 100)));

        return this.priceWithDiscount;
    }
}
