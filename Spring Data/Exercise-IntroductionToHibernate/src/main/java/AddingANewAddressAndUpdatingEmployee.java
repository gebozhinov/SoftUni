import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");

        entityManager.persist(newAddress);

        String lastNameOfEmployee = new Scanner(System.in).nextLine();
        entityManager.createQuery("UPDATE Employee e SET e.address = :na " +
                        "WHERE e.lastName = :ln")
                        .setParameter("na", newAddress)
                .setParameter("ln", lastNameOfEmployee)
                .executeUpdate();



        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

