package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    @Column(name = "city_name",nullable = false, unique = true)
    private String cityName;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private Integer population;
    @ManyToOne
    private Country country;

    @OneToMany(targetEntity = Forecast.class, mappedBy = "city")
    private Set<Forecast> forecasts;
}
