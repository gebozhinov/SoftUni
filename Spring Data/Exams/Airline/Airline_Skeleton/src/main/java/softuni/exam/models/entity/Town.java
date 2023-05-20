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

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private Integer population;
    @Column(nullable = false)
    private String guide;

    @OneToMany(targetEntity = Passenger.class, mappedBy = "town")
    private Set<Passenger> passengers;


}
