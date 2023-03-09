package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store_locations")
public class StoreLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "location_name")
    private String locationName;

    @OneToMany(mappedBy = "storeLocation", fetch = FetchType.EAGER)
    private Set<Sale> sales;

    public StoreLocation() {
        this.sales = new HashSet<>();
    }
}
