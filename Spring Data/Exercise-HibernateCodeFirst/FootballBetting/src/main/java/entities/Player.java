package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column
    private String name;
    @Column(name = "squad_number")
    private byte number;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Position position;
    @Column(name = "is_currently_injured")
    private boolean isInjured;
    @OneToMany(mappedBy = "player")
    private Set<PlayerStatistic> playerStatistics;

    public Player() {}
}
