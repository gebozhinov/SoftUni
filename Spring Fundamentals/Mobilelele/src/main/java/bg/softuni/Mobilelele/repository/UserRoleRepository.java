package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    @Query(value = "SELECT * FROM roles " +
            "WHERE id = 1",nativeQuery = true)
    UserRoleEntity getUserRole();
}
