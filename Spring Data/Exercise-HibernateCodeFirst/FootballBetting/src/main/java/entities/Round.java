package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "rounds")
public class Round extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "round")
    private Set<Game> games;

    public Round() {}
}
