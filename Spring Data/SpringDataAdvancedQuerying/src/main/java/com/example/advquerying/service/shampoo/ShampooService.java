package com.example.advquerying.service.shampoo;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findShampoosBySizeOrderById(Size size);

    List<Shampoo> findShampoosBySizeOrIdOrderByPriceAsc(Size size, Long id);

    List<Shampoo> findShampoosByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Long countByPriceLessThan(BigDecimal price);

    List<String> findShampoosBrandByIngredients(List<String> name);

    List<Shampoo> findShampoosByIngredientsLessThan(int count);

}
