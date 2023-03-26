package bg.softuni.exercisespringdataadvancedquerying.model.dto;

import bg.softuni.exercisespringdataadvancedquerying.model.entity.AgeRestriction;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.EditionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class BookInformation {

    private String title;
    private EditionType editionType;
    private AgeRestriction ageRestriction;
    private BigDecimal price;

    @Override
    public String toString() {
        return title + " " + editionType.name() + " " + ageRestriction.name() + " " + price;
    }
}
