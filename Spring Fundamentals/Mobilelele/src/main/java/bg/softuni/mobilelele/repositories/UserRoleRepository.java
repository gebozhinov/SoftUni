package bg.softuni.mobilelele.repositories;

import bg.softuni.mobilelele.domain.entities.UserRole;
import bg.softuni.mobilelele.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

    UserRole findFirstByRole(Role role);
}
