package encapsulation.lab.salaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva.", firstName, lastName, salary);
    }

    public void increaseSalary(double bonus) {
        if (age >= 30) {
            salary += bonus / 100 * salary;
        } else {
            salary += bonus / 200 * salary;
        }
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
