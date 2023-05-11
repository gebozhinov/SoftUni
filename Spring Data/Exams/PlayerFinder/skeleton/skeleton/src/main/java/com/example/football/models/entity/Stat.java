package com.example.football.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "stats")
@Entity
public class Stat extends BaseEntity {

    @Column(nullable = false)
    private Float shooting;

    @Column(nullable = false)
    private Float passing;

    @Column(nullable = false)
    private Float endurance;

    @OneToOne(targetEntity = Player.class, mappedBy = "stat")
    private Player players;

}
