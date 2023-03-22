package com.example.advquerying.repository;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<List<Ingredient>> findIngredientsByNameStartsWith(String letter);

    Optional<List<Ingredient>> findByNameInOrderByPriceAsc(List<String> names);
    @Modifying
    @Query("DELETE FROM Ingredient i " +
            "WHERE i.name = :name")
    void deleteByName(String name);
    @Modifying
    @Query("UPDATE Ingredient i " +
            "SET i.price = i.price * 1.1")
    void updateAllPrice();
    @Modifying
    @Query("UPDATE Ingredient i " +
            "SET i.price = i.price * 1.1 " +
            "WHERE i.name IN :names")
    void updateAllPriceByName(List<String> names);
}
