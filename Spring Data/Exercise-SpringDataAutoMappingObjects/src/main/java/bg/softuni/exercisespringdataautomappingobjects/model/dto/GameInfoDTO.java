package bg.softuni.exercisespringdataautomappingobjects.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class GameInfoDTO {
    private String title;
    private BigDecimal price;

    @Override
    public String toString() {
        return String.format("%s %.2f", this.title, this.price);
    }
}
