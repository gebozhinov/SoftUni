package com.example.usersystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy = "bornTown", cascade = CascadeType.ALL)
    private Set<User> born = new HashSet<>();
    @OneToMany(mappedBy = "currentTown", cascade = CascadeType.ALL)
    private Set<User> lived = new HashSet<>();

}
