package softuni.exam.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class ImportAgentDTO {

    @Size(min = 2)
    private String firstName;
    @Size(min = 2)
    private String lastName;
    @Email(regexp = ".+[@].+[\\\\.].+")
    private String email;
    private String town;

}
