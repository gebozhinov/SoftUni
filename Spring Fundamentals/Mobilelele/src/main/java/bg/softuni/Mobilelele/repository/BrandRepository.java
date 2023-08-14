package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    @Query(value = "SELECT * FROM brands ",nativeQuery = true)
    List<BrandEntity> getAllBrands();
}
