package bg.softuni.automappingobjects.entities.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ManagerDTO {
    private String firstName;
    private String lastName;
    private List<Employee2DTO> employees;
}
