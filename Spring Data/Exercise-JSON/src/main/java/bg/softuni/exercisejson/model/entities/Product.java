package bg.softuni.exercisejson.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false)
    @Size(min = 3)
    private String name;
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @Fetch(FetchMode.JOIN)
    private User buyerId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id")
    @Fetch(FetchMode.JOIN)
    private User sellerId;
    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<Category> categories;

}
