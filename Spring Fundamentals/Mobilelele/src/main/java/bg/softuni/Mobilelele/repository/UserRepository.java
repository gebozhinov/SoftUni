package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM users " +
            "WHERE username = :username",nativeQuery = true)
    Optional<UserEntity> login(String username);
}
