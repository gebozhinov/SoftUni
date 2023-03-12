package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @Column(length = 3, nullable = false, unique = true)
    private String id;
    @Column(name = "position_description")
    private String positionDescription;
    @OneToMany(mappedBy = "position")
    private Set<Player> players;



    public Position() {}
}
