package bg.softuni.supermarket.repository;

import bg.softuni.supermarket.domain.entities.Product;
import bg.softuni.supermarket.domain.entities.Seller;
import bg.softuni.supermarket.domain.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    Optional<Shop> getFirstByName(String name);

    @Query("SELECT se FROM Shop s " +
            "JOIN s.sellers se " +
            "WHERE s.name = :shopName")
    Optional<List<Seller>> getAllSellers(String shopName);

    @Query("SELECT p FROM Shop s " +
            "JOIN s.products p " +
            "WHERE s.name = :shopName")
    Optional<List<Product>> getAllProducts(String shopName);
}
