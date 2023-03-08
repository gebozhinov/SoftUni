import entities.Bike;
import entities.Car;
import entities.Plane;
import entities.Vehicle;
import hasEntities.Article;
import hasEntities.PlateNumber;
import hasEntities.Truck;
import hasEntities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("relations");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

//        Vehicle car = new Car("Mini Cooper S", "Petrol", 4);
//        Vehicle bike = new Bike();
//        Vehicle plane = new Plane("Boeing", "Kerosene", 250);
//
//        entityManager.persist(car);
//        entityManager.persist(bike);
//        entityManager.persist(plane);
//
//
//        PlateNumber plateNumber = new PlateNumber("1234");
//        Truck truck1 = new Truck(plateNumber);
//        Truck truck2 = new Truck(plateNumber);
//
//        entityManager.persist(plateNumber);
//        entityManager.persist(truck1);
//        entityManager.persist(truck2);

        Article article = new Article("Article Test");
        User author = new User("Author Test");

        author.addArticle(article);
        article.setAuthor(author);
        entityManager.persist(author);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
