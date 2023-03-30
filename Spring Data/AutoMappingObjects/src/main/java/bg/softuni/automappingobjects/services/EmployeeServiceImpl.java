package bg.softuni.automappingobjects.services;

import bg.softuni.automappingobjects.entities.Address;
import bg.softuni.automappingobjects.entities.Employee;
import bg.softuni.automappingobjects.entities.dto.*;
import bg.softuni.automappingobjects.repositories.AddressRepository;
import bg.softuni.automappingobjects.repositories.EmployeeRepository;
import ch.qos.logback.core.model.Model;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Employee create(CreateEmployeeDTO data) {
        Employee employee = mapper.map(data, Employee.class);
        Optional<Address> address = this.addressRepository.findByCountryAndCity(
                data.getAddress().getCountry(),
                data.getAddress().getCity()
        );

        address.ifPresent(employee::setAddress);
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return this.employeeRepository.findAll()
                .stream()
                .map(e -> mapper.map(e, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ManagerDTO> findAllManager() {
        return this.employeeRepository.findAll().stream()
                .map(e -> mapper.map(e, ManagerDTO.class))
                .filter(e -> e.getEmployees().size() > 0)
                .toList();
    }

    @Override
    public EmployeeNameDTO findNamesById(long id) {
        return this.employeeRepository.findNamesById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public EmployeeFirstNameAndSalary findFirstNameAndSalaryById(long id) {
        return this.employeeRepository.findFirstNameAndSalaryById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Employee3DTO> getInfo() {
        List<Employee3DTO> result = new ArrayList<>();
        for (Employee employee : this.employeeRepository.getInfo()) {
            Employee3DTO employee3DTO = mapper.map(employee, Employee3DTO.class);
            result.add(employee3DTO);
        }

        return result;
    }
}
