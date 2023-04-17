package bg.softuni.cardealer.repository;

import bg.softuni.cardealer.model.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("SELECT s FROM Supplier s " +
            "ORDER BY rand() LIMIT 1 ")
    Optional<Supplier> getRandomSupplier();
}
