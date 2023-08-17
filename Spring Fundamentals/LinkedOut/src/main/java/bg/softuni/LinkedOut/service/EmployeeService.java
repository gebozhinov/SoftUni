package bg.softuni.LinkedOut.service;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;
import bg.softuni.LinkedOut.model.dto.AllEmployeesDTO;
import bg.softuni.LinkedOut.model.dto.AllEmployeesDTOImpl;
import bg.softuni.LinkedOut.model.entity.Company;
import bg.softuni.LinkedOut.model.entity.Employee;
import bg.softuni.LinkedOut.model.mapper.EmployeeMapper;
import bg.softuni.LinkedOut.repository.CompanyRepository;
import bg.softuni.LinkedOut.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<AllEmployeesDTOImpl> findAllEmployees() {
        List<AllEmployeesDTO> allEmployeesDTOS = this.employeeRepository.findAllEmployees().orElse(new ArrayList<>());

        List<AllEmployeesDTOImpl> allEmployees = new ArrayList<>();

        for (AllEmployeesDTO employeesDTO : allEmployeesDTOS) {
            String fullName = employeesDTO.getFirstName()
                    + " " + employeesDTO.getLastName();
            String jobTitle = employeesDTO.getJobTitle();
            LocalDate birthdate = employeesDTO.getBirthdate();

            AllEmployeesDTOImpl allEmployeesDTO = new AllEmployeesDTOImpl();
            allEmployeesDTO.setFullName(fullName);
            allEmployeesDTO.setJobTitle(jobTitle);
            allEmployeesDTO.setBirthdate(birthdate);

            allEmployees.add(allEmployeesDTO);

        }
        return allEmployees;
    }

}
