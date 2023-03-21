package com.example.advquerying.service.ingredient;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findIngredientsByNameStartsWith(String letter) {
        return this.ingredientRepository.findIngredientsByNameStartsWith(letter)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Ingredient> findByNameInOrderByPriceAsc(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPriceAsc(names)
                .orElseThrow(NoSuchElementException::new);
    }
}
