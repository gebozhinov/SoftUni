package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(length = 3, nullable = false, unique = true)
    private String id;

    @Column
    private String name;
    @ManyToMany
    @JoinTable(name = "countries_continents",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id"))
    private Set<Continent> continents;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<Town> towns;

    public Country() {
    }

}
