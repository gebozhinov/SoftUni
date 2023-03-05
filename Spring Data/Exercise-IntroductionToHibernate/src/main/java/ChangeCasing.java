import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();


        entityManager.getTransaction().begin();
        List<Town> towns = entityManager.createQuery("SELECT t FROM Town t", Town.class).getResultList();

        for (Town town : towns) {
            String townName = town.getName();
            if (town.getName().length() <= 5) {
                town.setName(townName.toUpperCase());
                entityManager.persist(town);
            }
        }


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
