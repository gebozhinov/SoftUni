import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.Scanner;

public class GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        Integer employeeId = Integer.parseInt(new Scanner(System.in).nextLine());

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.id = :empId", Employee.class)
                .setParameter("empId", employeeId)
                .getSingleResult();

        System.out.println(employee.getFirstName() + " " + employee.getLastName() + " - " + employee.getJobTitle());
        employee.getProjects().stream().sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.println(p.getName()));


        entityManager.close();
    }

}
