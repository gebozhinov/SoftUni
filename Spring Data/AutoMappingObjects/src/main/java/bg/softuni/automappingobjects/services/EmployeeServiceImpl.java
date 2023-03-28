package bg.softuni.automappingobjects.services;

import bg.softuni.automappingobjects.entities.Address;
import bg.softuni.automappingobjects.entities.Employee;
import bg.softuni.automappingobjects.entities.dto.CreateEmployeeDTO;
import bg.softuni.automappingobjects.entities.dto.EmployeeDTO;
import bg.softuni.automappingobjects.repositories.AddressRepository;
import bg.softuni.automappingobjects.repositories.EmployeeRepository;
import ch.qos.logback.core.model.Model;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

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
}
