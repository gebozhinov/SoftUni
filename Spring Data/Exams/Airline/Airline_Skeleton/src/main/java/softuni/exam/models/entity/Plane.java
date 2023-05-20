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
@Table(name = "planes")
@Entity
public class Plane extends BaseEntity {

    @Column(name = "registered_number", nullable = false, unique = true)
    private String registeredNumber;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String airline;

    @OneToMany(targetEntity = Ticket.class, mappedBy = "plane")
    private Set<Ticket> tickets;

}
