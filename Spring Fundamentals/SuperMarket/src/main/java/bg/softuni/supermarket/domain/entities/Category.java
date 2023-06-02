package bg.softuni.supermarket.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Table(name = "categories")
@Entity
public class Category extends BaseEntity {


    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private String name;

    @OneToMany(targetEntity = Product.class, mappedBy = "category")
    private Set<Product> products;

    public Category() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
