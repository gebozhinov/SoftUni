package bg.softuni.cardealer.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column
    private String make;
    @Column
    private String model;
    @Column(name = "travelled_distance")
    private long travelledDistance;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "parts_cars", joinColumns = @JoinColumn(name = "car_id")
            , inverseJoinColumns = @JoinColumn(name = "part_id"))
    private Set<Part> parts;

    public Car() {
        this.parts = new HashSet<>();
    }
    public void addPart(Part part) {
        this.parts.add(part);
    }

}
