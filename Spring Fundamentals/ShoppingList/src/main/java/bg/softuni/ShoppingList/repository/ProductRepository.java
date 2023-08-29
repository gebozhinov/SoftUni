package bg.softuni.ShoppingList.repository;

import bg.softuni.ShoppingList.model.dto.product.ProductInfo;
import bg.softuni.ShoppingList.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(value = "SELECT * FROM products " +
            "WHERE name = :name",nativeQuery = true)
    Optional<Product> findByName(String name);
    @Query(value = "SELECT * FROM products", nativeQuery = true)
    Optional<List<Product>> findAllProducts();

    @Query(value = "SELECT id, name, price FROM products " +
            "WHERE category_id = 1" ,nativeQuery = true)
    Optional<List<ProductInfo>> findAllFoods();

    @Query(value = "SELECT id, name, price FROM products " +
            "WHERE category_id = 2" ,nativeQuery = true)
    Optional<List<ProductInfo>> findAllDrinks();

    @Query(value = "SELECT id, name, price FROM products " +
            "WHERE category_id = 3" ,nativeQuery = true)
    Optional<List<ProductInfo>> findAllHousehold();
    @Query(value = "SELECT id, name, price FROM products " +
            "WHERE category_id = 4" ,nativeQuery = true)
    Optional<List<ProductInfo>> findAllOther();

    @Query(value = "SELECT sum(price) FROM products",nativeQuery = true)
    BigDecimal findPriceSumOfAllProducts();
}

