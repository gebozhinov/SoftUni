package bg.softuni.automappingobjects.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CreateEmployeeDTO {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate birthday;
    private AddressDTO address;

}
