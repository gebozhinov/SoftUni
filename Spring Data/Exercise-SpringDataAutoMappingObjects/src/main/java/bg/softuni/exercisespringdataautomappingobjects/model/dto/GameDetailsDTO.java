package bg.softuni.exercisespringdataautomappingobjects.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class GameDetailsDTO {

    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;


    @Override
    public String toString() {
        return "Title: " + title + System.lineSeparator() +
                "Price: " + price + System.lineSeparator() +
                "Description: " + description + System.lineSeparator() +
                "Release date: " + releaseDate;
    }
}
