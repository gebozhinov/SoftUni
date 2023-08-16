package bg.softuni.LinkedOut.model.mapper;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;
import bg.softuni.LinkedOut.model.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {


    Employee addEmployeeDTOToEmployee(AddEmployeeDTO addEmployeeDTO);

}
