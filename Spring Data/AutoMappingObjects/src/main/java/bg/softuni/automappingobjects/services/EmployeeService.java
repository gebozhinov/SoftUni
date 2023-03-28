package bg.softuni.automappingobjects.services;

import bg.softuni.automappingobjects.entities.Employee;
import bg.softuni.automappingobjects.entities.dto.CreateEmployeeDTO;
import bg.softuni.automappingobjects.entities.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO data);

    List<EmployeeDTO> findAll();
}
