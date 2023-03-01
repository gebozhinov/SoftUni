import entities.Student;
import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Connector.createConnection("root", "1234", "soft_uni");

        Connection connection = Connector.getConnection();

        EntityManager<User> userManager = new EntityManager<>(connection);
//        User user = new User("First", 32, LocalDate.now());
//        userManager.persist(user);
//
        EntityManager<Student> studentManager = new EntityManager<>(connection);
//        Student student = new Student("Ivan");
//        studentManager.persist(student);

        User first = userManager.findFirst(User.class);

        System.out.println(first.getId() + " " + first.getUsername());

        Student first1 = studentManager.findFirst(Student.class, "name = 'test'");

        System.out.println(first1.getId() + " " + first1.getName());

        userManager.find(User.class, "age > 18 AND registration_date > '2022-06-06'")
                .forEach(u -> System.out.println(u.toString()));

    }
}
