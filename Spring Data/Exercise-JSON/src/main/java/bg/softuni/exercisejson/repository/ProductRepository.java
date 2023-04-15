package bg.softuni.exercisejson.repository;

import bg.softuni.exercisejson.model.dtos.product.ProductDTO;
import bg.softuni.exercisejson.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT NEW bg.softuni.exercisejson.model.dtos.product.ProductDTO(p.name, p.price, " +
            "concat(p.sellerId.firstName, ' ', p.sellerId.lastName)) " +
            "FROM Product p " +
            "WHERE p.price > :low AND p.price < :high AND p.buyerId = null " +
            "ORDER BY p.price")
    Optional<List<ProductDTO>> findAllByPriceInRange(BigDecimal low, BigDecimal high);
}
