import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

//        Student student = new Student();
//        student.setName("Tosho");
//        session.persist(student);

//        Student studentFromDb = session.get(Student.class, 2);
//        System.out.println(studentFromDb.getId() + " " + studentFromDb.getName());

//        List<Student> students =
//                session.createQuery("FROM Student WHERE name = 'Tosho1'", Student.class)
//                        .stream().toList();
//        for (Student student : students) {
//            System.out.println(student.getId() + " " + student.getName());
//        }

        session.getTransaction().commit();
        session.close();

    }
}
