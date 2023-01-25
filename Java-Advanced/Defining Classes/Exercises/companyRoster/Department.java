package definingClasses.exercises.companyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name, List<Employee> employeeList) {
        this.name = name;
        this.employeeList = new ArrayList<>();
        this.employeeList.addAll(employeeList);
    }

    public double calculateAverageSalary() {
        return employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }
    @Override
    public String toString() {
        return this.name;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }


}
