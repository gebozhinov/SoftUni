package com.example.usersystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column
    private String name;
    @OneToMany(targetEntity = Town.class ,mappedBy = "country", cascade = CascadeType.ALL)
    private List<Town> towns = new ArrayList<>();
}
