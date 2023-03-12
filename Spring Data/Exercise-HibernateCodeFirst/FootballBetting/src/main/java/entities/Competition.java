package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {

    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "competition_type")
    private CompetitionType type;
    @OneToMany(mappedBy = "competition")
    private Set<Game> games;

    public Competition() {}
}
