package bg.softuni.supermarket.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Table(name = "shops")
@Entity
public class Shop extends BaseEntity {

    @Column
    @Size(min = 2)
    private String address;

    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private String name;

    @ManyToOne
    private Town town;

    @OneToMany(targetEntity = Seller.class, mappedBy = "shop")
    private Set<Seller> sellers;

    @ManyToMany(targetEntity = Product.class, mappedBy = "shops")
    private Set<Product> products;

    public Shop() {}

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(Set<Seller> sellers) {
        this.sellers = sellers;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
