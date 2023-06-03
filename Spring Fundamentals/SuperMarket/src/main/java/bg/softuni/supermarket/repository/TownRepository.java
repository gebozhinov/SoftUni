package bg.softuni.supermarket.repository;

import bg.softuni.supermarket.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Optional<Town> findFirstByName(String name);
}
