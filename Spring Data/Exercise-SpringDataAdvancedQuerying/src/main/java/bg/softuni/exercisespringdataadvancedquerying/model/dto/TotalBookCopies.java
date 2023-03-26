package bg.softuni.exercisespringdataadvancedquerying.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TotalBookCopies {
    private String fullName;
    private int copies;



    @Override
    public String toString() {
        return this.fullName + " " + copies;
    }
}
