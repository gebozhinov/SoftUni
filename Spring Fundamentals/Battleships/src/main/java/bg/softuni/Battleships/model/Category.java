package bg.softuni.Battleships.model;

import bg.softuni.Battleships.model.enums.CategoryName;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    @Column(nullable = false, unique = true)
    private CategoryName name;

    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(targetEntity = Ship.class, mappedBy = "category")
    private Set<Ship> ships;

    public Long getId() {
        return id;
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

    public Set<Ship> getShips() {
        return ships;
    }

    public Category setShips(Set<Ship> ships) {
        this.ships = ships;
        return this;
    }
}
