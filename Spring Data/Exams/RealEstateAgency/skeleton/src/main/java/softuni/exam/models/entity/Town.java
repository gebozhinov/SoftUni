package softuni.exam.models.entity;

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

    @Column(name = "town_name", nullable = false, unique = true)
    private String townName;

    @Column(nullable = false)
    private Integer population;

    @OneToMany(targetEntity = Agent.class, mappedBy = "town")
    private Set<Agent> agents;

    @OneToMany(targetEntity = Apartment.class, mappedBy = "town")
    private Set<Apartment> apartments;
}
