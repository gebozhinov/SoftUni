package exam.december2020.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).get();
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name))
                .findFirst().get();
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:", name)).append(String.format("%n"));
        employees.forEach(e -> sb.append(e).append(String.format("%n")));
        return sb.toString().trim();
    }
}
