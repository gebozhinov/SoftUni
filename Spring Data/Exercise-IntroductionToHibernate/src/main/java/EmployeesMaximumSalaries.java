import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


public class EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        List<Object[]> resultList = entityManager.createQuery("SELECT d.name, MAX(e.salary) AS total FROM Department d " +
                        "JOIN Employee e ON d.id = e.department.id " +
                        "GROUP BY d.name " +
                        "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000")
                .getResultList();



        for (Object[] o : resultList) {
            String departmentName = (String) o[0];
            BigDecimal maxSalary = (BigDecimal) o[1];
            System.out.printf("%s %s%n", departmentName, maxSalary);
        }

        entityManager.close();

    }
}

