package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "agents")
@Entity
public class Agent extends BaseEntity {

    @Column(name = "first_name", nullable = false, unique = true)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true)
    private String email;

    @ManyToOne
    private Town town;
    @OneToMany(targetEntity = Offer.class, mappedBy = "agent")
    private Set<Offer> offers;
}
