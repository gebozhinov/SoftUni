package bg.softuni.automappingobjects.services;

import bg.softuni.automappingobjects.entities.Employee;
import bg.softuni.automappingobjects.entities.dto.*;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO data);

    List<EmployeeDTO> findAll();

    List<ManagerDTO> findAllManager();
    EmployeeNameDTO findNamesById(long id);

    EmployeeFirstNameAndSalary findFirstNameAndSalaryById(long id);

    List<Employee3DTO> getInfo();
}
