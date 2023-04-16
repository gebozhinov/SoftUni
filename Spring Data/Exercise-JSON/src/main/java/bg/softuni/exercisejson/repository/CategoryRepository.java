package bg.softuni.exercisejson.repository;

import bg.softuni.exercisejson.model.dtos.category.CategoriesByProductCountDTO;
import bg.softuni.exercisejson.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT * FROM products_shop.categories " +
            "ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Category> getRandomEntity();

    @Query("SELECT NEW bg.softuni.exercisejson.model.dtos.category.CategoriesByProductCountDTO" +
            "(c.name, count(p.id), avg(p.price), sum(p.price)) " +
            "FROM Product p " +
            "JOIN p.categories c " +
            "GROUP BY c.id " +
            "ORDER BY count(p.id) desc ")
    Optional<List<CategoriesByProductCountDTO>> getAllByProductsCount();
}
