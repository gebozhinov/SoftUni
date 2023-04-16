package bg.softuni.exercisejson.repository;

import bg.softuni.exercisejson.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM products_shop.users " +
            "ORDER BY RAND() LIMIT 1 ", nativeQuery = true)
    Optional<User> getRandomEntity();

    @Query("SELECT u FROM User u " +
            "WHERE u.productsBought IS NOT EMPTY " +
            "ORDER BY u.lastName, u.firstName")
    Optional<List<User>> findAllByProductsSold();

    Optional<List<User>> findAllByProductsSoldIsNotNullOrderByFirstName();


}
