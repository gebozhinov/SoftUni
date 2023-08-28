package bg.softuni.ShoppingList.repository;

import bg.softuni.ShoppingList.model.dto.product.Food;
import bg.softuni.ShoppingList.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(value = "SELECT * FROM products " +
            "WHERE name = :name",nativeQuery = true)
    Optional<Product> findByName(String name);

    @Query(value = "SELECT name, price FROM products " +
            "WHERE user_id = :id",nativeQuery = true)
    Optional<List<Food>> findAllFoods(Long id);
}

