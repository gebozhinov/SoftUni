import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String town = new Scanner(System.in).nextLine();

        Long deletedAddresses = entityManager.createQuery("SELECT COUNT(a.text) FROM Town t " +
                        "JOIN Address a ON t.id = a.town.id " +
                        "WHERE t.name = :townName " +
                        "GROUP BY t.id", Long.class)
                .setParameter("townName", town)
                .getSingleResult();


        entityManager.createQuery("UPDATE Address a " +
                        "SET a.town = null " +
                        "WHERE a.town.id = :townName")
                .setParameter("townName", getTownId(entityManager, town)).executeUpdate();


        entityManager.createQuery("DELETE FROM Town t" +
                        " WHERE t.name = :townName")
                .setParameter("townName", town).executeUpdate();


        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.printf("%d address in %s deleted%n",deletedAddresses, town);

    }

    public static Integer getTownId(EntityManager entityManager, String townName) {
        return entityManager.createQuery("SELECT t.id FROM Town t " +
                        "WHERE t.name = :tn", Integer.class)
                .setParameter("tn", townName)
                .getSingleResult();
    }
}
