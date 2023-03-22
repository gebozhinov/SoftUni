package com.example.advquerying.service.ingredient;

import com.example.advquerying.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> findIngredientsByNameStartsWith(String letter);
    List<Ingredient> findByNameInOrderByPriceAsc(List<String> names);

    void deleteByName(String name);

    void updateAllPrice();

    void updateAllPriceByName(List<String> names);

}
