package bg.softuni.automappingobjects.entities.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class Employee2DTO {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
}
