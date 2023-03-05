import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesFromDepartment {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = :dp " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("dp", "Research and Development")
                .getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }
        entityManager.close();

    }
}

