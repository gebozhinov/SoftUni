package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.enums.ApartmentType;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "apartments")
@Entity
public class Apartment extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "apartment_type", nullable = false)
    private ApartmentType apartmentType;

    @Column(nullable = false)
    private Double area;

    @ManyToOne
    private Town town;

    @OneToMany(targetEntity = Offer.class, mappedBy = "apartment")
    private Set<Offer> offers;
}
