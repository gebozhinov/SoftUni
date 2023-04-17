package bg.softuni.cardealer.repository;

import bg.softuni.cardealer.model.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    @Query(value = "SELECT * FROM car_dealer.parts " +
            "ORDER BY rand() LIMIT ?", nativeQuery = true)
    Optional<Set<Part>> getRandomParts(int num);
}
