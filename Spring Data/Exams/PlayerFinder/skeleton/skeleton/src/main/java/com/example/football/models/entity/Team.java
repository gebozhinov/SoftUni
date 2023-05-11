package com.example.football.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "teams")
@Entity
public class Team extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "stadium_name", nullable = false)
    private String stadiumName;

    @Column(name = "fan_base", nullable = false)
    private Integer fanBase;

    @Column(columnDefinition = "text", nullable = false)
    private String history;

    @ManyToOne
    private Town town;

    @OneToMany(targetEntity = Player.class, mappedBy = "team")
    private Set<Player> players;
}
