package bg.softuni.Battleships.repository;

import bg.softuni.Battleships.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query(value = "SELECT * FROM ships " +
            "WHERE name = :name",nativeQuery = true)
    Optional<Ship> findByName(String name);

    @Query(value = "SELECT * FROM ships " +
            "WHERE user_id = :id",nativeQuery = true)
    Optional<List<Ship>> getOwnerShips(Long id);

    @Query(value = "SELECT * FROM ships " +
            "WHERE user_id != :id",nativeQuery = true)
    Optional<List<Ship>> getEnemyShips(Long id);

    @Query(value = "SELECT * FROM ships " +
            "ORDER BY name, health, power",nativeQuery = true)
    Optional<List<Ship>> getAllShips();

}
