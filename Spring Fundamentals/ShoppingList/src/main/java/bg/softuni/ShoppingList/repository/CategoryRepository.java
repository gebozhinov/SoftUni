package bg.softuni.ShoppingList.repository;

import bg.softuni.ShoppingList.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM categories " +
            "WHERE name = :name", nativeQuery = true)
    Optional<Category> findByOrdinalName(int name);
}
