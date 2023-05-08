package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(name = "country_name",nullable = false, unique = true)
    private String countryName;
    @Column(nullable = false)
    private String currency;

    @OneToMany(targetEntity = City.class, mappedBy = "country")
    private Set<City> cities;
}
