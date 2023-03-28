package bg.softuni.automappingobjects.entities.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EmployeeDTO {

    private String firstName;
    private BigDecimal salary;
    private String addressCity;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", addressCity='" + addressCity + '\'' +
                '}';
    }
}
