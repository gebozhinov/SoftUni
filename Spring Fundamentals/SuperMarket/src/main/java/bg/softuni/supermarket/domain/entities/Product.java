package bg.softuni.supermarket.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Table(name = "products")
@Entity
public class Product extends BaseEntity {

    @Column(name = "best_before")
    private LocalDate bestBefore;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    @Size(min = 2)
    private String name;

    @Column(nullable = false, precision = 19, scale = 2)
    @DecimalMin("0")
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(name = "products_shops",
            joinColumns = @JoinColumn(name = "product_id")
            , inverseJoinColumns = @JoinColumn(name = "shop_id"))
    private Set<Shop> shops;

    public Product() {
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }
}
