package bg.softuni.Pathfinder.model;

import bg.softuni.Pathfinder.model.enums.CategoryName;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryName name;

    @Column(columnDefinition = "text")
    private String description;
}
