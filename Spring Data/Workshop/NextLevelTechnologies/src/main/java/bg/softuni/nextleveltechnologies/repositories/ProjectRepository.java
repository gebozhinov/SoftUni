package bg.softuni.nextleveltechnologies.repositories;

import bg.softuni.nextleveltechnologies.model.enitities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findFirstByName(String name);
}
