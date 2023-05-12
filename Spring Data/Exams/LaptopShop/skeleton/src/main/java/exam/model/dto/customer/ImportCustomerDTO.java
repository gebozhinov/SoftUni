package exam.model.dto.customer;

import exam.model.dto.town.TownNameWrapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class ImportCustomerDTO {

    @Size(min = 2)
    private String firstName;

    @Size(min = 2)
    private String lastName;

    @Email(regexp = ".+[@].+[\\\\.].+")
    private String email;
    private String registeredOn;

    private TownNameWrapper town;
}
