package entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "store_location_id")
    private StoreLocation storeLocation;

    @Column
    private Date date;

    public Sale() {
    }
}
