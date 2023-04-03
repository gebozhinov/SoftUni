package bg.softuni.exercisespringdataautomappingobjects.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    @Column(nullable = false)
    private String title;
    @Column
    private String trailer;
    @Column
    private String imgUrl;
    @Column
    private double size;
    @Column
    private BigDecimal price;
    @Column(nullable = false)
    private String description;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @ManyToMany(mappedBy = "games")
    private List<User> users;
    @ManyToMany(mappedBy = "games")
    private List<Order> orders;

    public Game() {
        this.users = new ArrayList<>();
        this.orders = new ArrayList<>();
    }
}
