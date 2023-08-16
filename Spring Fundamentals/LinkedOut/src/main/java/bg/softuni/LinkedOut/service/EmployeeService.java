package bg.softuni.LinkedOut.service;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;
import bg.softuni.LinkedOut.model.entity.Company;
import bg.softuni.LinkedOut.model.entity.Employee;
import bg.softuni.LinkedOut.model.mapper.EmployeeMapper;
import bg.softuni.LinkedOut.repository.CompanyRepository;
import bg.softuni.LinkedOut.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository,
                           CompanyRepository companyRepository,
                           EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.employeeMapper = employeeMapper;
    }

    public void addEmployee(AddEmployeeDTO addEmployeeDTO) {

        Employee employee = this.employeeMapper.addEmployeeDTOToEmployee(addEmployeeDTO);

        Company company = this.companyRepository.findByName(addEmployeeDTO.getCompanyName()).get();
        employee.setCompany(company);

        this.employeeRepository.save(employee);
    }

}
