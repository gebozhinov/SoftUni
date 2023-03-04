import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("school-db");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student("Test1");
        entityManager.persist(student);

        Student studentFromDb = entityManager.find(Student.class, 3);
        System.out.println(studentFromDb.getId() + " " + studentFromDb.getName());
        
        entityManager.getTransaction().commit();
        entityManager.clear();
    }
}
