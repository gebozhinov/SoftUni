package bg.softuni.ShoppingList.model.entity;

import bg.softuni.ShoppingList.model.entity.enums.CategoryName;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, unique = true)
    private CategoryName name;
    @Column(columnDefinition = "text")
    private String description;
    @OneToMany(targetEntity = Product.class, mappedBy = "category")
    private Set<Product> products;

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Category setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }
}
