package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
