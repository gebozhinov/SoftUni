package bg.softuni.nextleveltechnologies.service;

import bg.softuni.nextleveltechnologies.model.dtos.employee.ImportEmployeesDTO;
import bg.softuni.nextleveltechnologies.model.enitities.Employee;
import bg.softuni.nextleveltechnologies.model.enitities.Project;
import bg.softuni.nextleveltechnologies.repositories.EmployeeRepository;
import bg.softuni.nextleveltechnologies.repositories.ProjectRepository;
import bg.softuni.nextleveltechnologies.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import static bg.softuni.nextleveltechnologies.constant.Message.INCORRECT_DATA;
import static bg.softuni.nextleveltechnologies.constant.Message.SUCCESSFULLY_IMPORTED_EMPLOYEE;
import static bg.softuni.nextleveltechnologies.constant.Paths.IMPORT_EMPLOYEES_PATH;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               ProjectRepository projectRepository,
                               ModelMapper modelMapper,
                               ValidationUtil validationUtil) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;

        this.validationUtil = validationUtil;
    }

    @Override
    public String getXMLContent() throws IOException {
        return Files.readString(IMPORT_EMPLOYEES_PATH);
    }

    @Override
    public String importEmployees() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_EMPLOYEES_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(ImportEmployeesDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportEmployeesDTO importEmployeesDTO = (ImportEmployeesDTO) unmarshaller.unmarshal(file);
        importEmployeesDTO.getEmployees()
                .forEach(importEmployeeDTO -> {
                    boolean isValid = validationUtil.isValid(importEmployeeDTO);

                    Optional<Project> project =
                            projectRepository.findFirstByName(importEmployeeDTO.getProject().getName());

                    if (project.isEmpty()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Employee employee = modelMapper.map(importEmployeeDTO, Employee.class);
                        employee.setProject(project.get());
                        employeeRepository.saveAndFlush(employee);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_EMPLOYEE,
                                        employee.getFirstName(),
                                        employee.getLastName()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "Employee"))
                                .append(System.lineSeparator());
                    }

                });

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.employeeRepository.count() > 0;
    }
}
