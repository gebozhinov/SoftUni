import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            System.out.printf("%s, %s - %d employees%n",address.getText(), address.getTown().getName(), address.getEmployees().size());
        }

        entityManager.close();
    }
}
