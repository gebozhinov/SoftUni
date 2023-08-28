package bg.softuni.ShoppingList.repository;

import bg.softuni.ShoppingList.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "SELECT * FROM users " +
            "WHERE username = :username",nativeQuery = true)
    Optional<User> findByUsername(String username);
    @Query(value = "SELECT * FROM users " +
            "WHERE email = :email",nativeQuery = true)
    Optional<User> findByEmail(String email);
}
