import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        List<String> resultList = entityManager.createQuery("SELECT e.firstName FROM Employee e " +
                "WHERE e.salary > 50000", String.class).getResultList();

        for (String employee : resultList) {
            System.out.println(employee);
        }

        entityManager.close();

    }
}
