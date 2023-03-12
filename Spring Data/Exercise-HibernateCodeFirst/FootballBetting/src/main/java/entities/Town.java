package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "town")
    private Set<Team> teams;
    @ManyToOne
    private Country country;
    public Town() {}

}
