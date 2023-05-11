package com.example.football.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "towns")
@Entity
public class Town extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer population;

    @Column(name = "travel_guide",columnDefinition = "text", nullable = false)
    private String travelGuide;

    @OneToMany(targetEntity = Team.class, mappedBy = "town")
    private Set<Team> teams;

    @OneToMany(targetEntity = Player.class, mappedBy = "town")
    private Set<Player> players;


}
