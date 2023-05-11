package com.example.football.models.entity;

import com.example.football.models.entity.enums.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "players")
@Entity
public class Player extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Enumerated
    @Column(nullable = false)
    private Position position;

    @ManyToOne
    private Town town;

    @ManyToOne
    private Team team;

    @OneToOne
    private Stat stat;

}
