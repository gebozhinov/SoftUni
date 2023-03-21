package com.example.advquerying.repository;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    Optional<List<Shampoo>> findShampoosBySizeOrderById(Size size);

    Optional<List<Shampoo>> findShampoosBySizeOrLabelIdOrderByPriceAsc(Size size, Long id);

    Optional<List<Shampoo>> findShampoosByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Optional<Long> countByPriceLessThan(BigDecimal price);
    @Query("SELECT s FROM Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i.name IN :name")
    Optional<List<Shampoo>> findShampoosByIngredientsIn(List<String> name);

    @Query("SELECT s FROM Shampoo AS s " +
            "WHERE s.ingredients.size < :count")
    List<Shampoo> findShampoosByIngredientsLessThan(int count);
}
