package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private double price;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Sale> sales;

    public Product() {
        this.sales = new HashSet<>();
    }
}
