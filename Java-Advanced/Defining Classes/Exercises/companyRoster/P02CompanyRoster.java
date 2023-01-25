package definingClasses.exercises.companyRoster;

import java.util.*;

public class P02CompanyRoster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Department> departmentMap = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 6:
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        int employeeAge = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, employeeAge);
                    } else {
                        String employeeEmail = tokens[4];
                        employee = new Employee(name, salary, position, department, employeeEmail);
                    }
                    break;
            }

            departmentMap.putIfAbsent(department, new Department(department, new ArrayList<>()));
            departmentMap.get(department).getEmployeeList().add(employee);

        }

        Department highestPaidDep = departmentMap.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().calculateAverageSalary()))
                .get()
                .getValue();
        System.out.println("Highest Average Salary: " + highestPaidDep);

        highestPaidDep.getEmployeeList().stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

    }
}
