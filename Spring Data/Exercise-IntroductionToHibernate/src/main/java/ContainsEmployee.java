import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        String[] inputName = new Scanner(System.in).nextLine().split(" ");

        Long result = entityManager.createQuery("SELECT COUNT(e) FROM Employee e" +
                        " WHERE e.firstName = :fn AND e.lastName = :ln", Long.class)
                .setParameter("fn", inputName[0])
                .setParameter("ln", inputName[1])
                .getSingleResult();

        if (result != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        entityManager.close();

    }
}

