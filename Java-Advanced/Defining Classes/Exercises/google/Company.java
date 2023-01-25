package definingClasses.exercises.google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String getName() {
        return this.name;
    }
    public String getDepartment() {
        return this.department;
    }
    public double getSalary() {
        return this.salary;
    }
}
