package bg.softuni.Battleships.repository;

import bg.softuni.Battleships.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM categories " +
            "WHERE name = :ordinalName",nativeQuery = true)
    Optional<Category> findByName(int ordinalName);
}
