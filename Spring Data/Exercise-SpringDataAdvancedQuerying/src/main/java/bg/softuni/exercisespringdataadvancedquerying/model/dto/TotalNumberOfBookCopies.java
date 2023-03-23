package bg.softuni.exercisespringdataadvancedquerying.model.dto;

import bg.softuni.exercisespringdataadvancedquerying.model.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TotalNumberOfBookCopies {
    private Author author;
    private int copies;

    @Override
    public String toString() {
        return this.author.getFirstName() + " " + this.author.getLastName() + " - " + copies;
    }
}
