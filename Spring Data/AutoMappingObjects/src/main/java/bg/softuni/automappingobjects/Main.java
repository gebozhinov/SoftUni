package bg.softuni.automappingobjects;

import bg.softuni.automappingobjects.entities.Address;
import bg.softuni.automappingobjects.entities.Employee;
import bg.softuni.automappingobjects.entities.dto.AddressDTO;
import bg.softuni.automappingobjects.entities.dto.CreateEmployeeDTO;
import bg.softuni.automappingobjects.entities.dto.ManagerDTO;
import bg.softuni.automappingobjects.services.AddressService;
import bg.softuni.automappingobjects.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final AddressService addressService;
    private final EmployeeService employeeService;

    private final Scanner scanner;

    @Autowired
    public Main(AddressService addressService, EmployeeService employeeService, Scanner scanner) {
        this.addressService = addressService;
        this.employeeService = employeeService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
//        createAddress();
//        createEmployee();
//        printAllEmployees();
//        printEmployeeNames();
//        printEmployeeFirstNameAndSalary();
//        printAllManagers();
//        printAllManagers2();
    }

    // 3.	Projection
    private void printAllManagers2() {
        this.employeeService.getInfo()
                .forEach(e -> System.out.printf("%s %s %.2f - Manager: %s%n", e.getFirstName(),
                        e.getLastName(), e.getSalary(), e.getManagerLastName()));
    }

    //2.	Advanced Mapping
    private void printAllManagers() {
        for (ManagerDTO manager : this.employeeService.findAllManager()) {
            System.out.printf("%s %s | Employees: %d%n",
                    manager.getFirstName(), manager.getLastName(), manager.getEmployees().size());
            for (int i = 0; i < manager.getEmployees().size(); i++) {
                String employeeName = manager.getEmployees().get(i).getFirstName() + " " +
                        manager.getEmployees().get(i).getLastName();
                BigDecimal salary = manager.getEmployees().get(i).getSalary();
                System.out.printf("    - %s %.2f%n", employeeName, salary);
            }
        }
    }

    private void printEmployeeFirstNameAndSalary() {
        long employeeId = Long.parseLong(scanner.nextLine());
        System.out.println(this.employeeService.findFirstNameAndSalaryById(employeeId)
                .getFirstName());
        System.out.println(this.employeeService.findFirstNameAndSalaryById(employeeId).getSalary());
    }

    private void printEmployeeNames() {
        long employeeId = Long.parseLong(scanner.nextLine());
        System.out.println(this.employeeService.findNamesById(employeeId));
    }

    private void printAllEmployees() {
        this.employeeService.findAll().forEach(System.out::println);
    }

    private void createEmployee() {
        String firstName = scanner.nextLine();
        BigDecimal salary = new BigDecimal(scanner.nextLine());
        LocalDate birthday = LocalDate.parse(scanner.nextLine());

//        long addressId = Long.parseLong(scanner.nextLine());

        String country = scanner.nextLine();
        String city = scanner.nextLine();
        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO data = new CreateEmployeeDTO(firstName, null, salary, birthday, address);
        Employee employee = this.employeeService.create(data);
        System.out.println(employee);
    }

    private void createAddress() {
        String country = scanner.nextLine();
        String city = scanner.nextLine();

        AddressDTO data = new AddressDTO(country, city);
        Address address = this.addressService.create(data);
        System.out.println(address);
    }
}
