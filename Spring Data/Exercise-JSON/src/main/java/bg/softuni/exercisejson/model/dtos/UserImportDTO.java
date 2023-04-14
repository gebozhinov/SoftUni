package bg.softuni.exercisejson.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserImportDTO {

    private String firstName;
    private String lastName;
    private int age;
}
