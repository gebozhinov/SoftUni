package bg.softuni.Pathfinder.repository;

import bg.softuni.Pathfinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {


    @Query(value = "SELECT * FROM users " +
            "WHERE email = :email", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
