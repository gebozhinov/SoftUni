package bg.softuni.automappingobjects.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class Employee3DTO {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String managerLastName;

}
