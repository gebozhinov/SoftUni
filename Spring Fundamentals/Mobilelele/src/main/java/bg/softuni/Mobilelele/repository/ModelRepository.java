package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {


    @Query(value = "SELECT id FROM models " +
            "WHERE name = :modelName",nativeQuery = true)
    Long getIdOfModelByName(String modelName);

    @Query(value = "SELECT * FROM models " +
            "WHERE id = :id", nativeQuery = true)
    Optional<ModelEntity> findById(Long id);
}
