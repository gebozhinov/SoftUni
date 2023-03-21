package com.example.advquerying;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.service.ingredient.IngredientService;
import com.example.advquerying.service.shampoo.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;
    @Autowired
    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

//        List<Shampoo> shampoos = this.shampooService.findShampoosBySizeOrderById(Size.MEDIUM);
//        for (Shampoo shampoo : shampoos) {
//            System.out.println(shampoo.toString());
//        }

//        List<Shampoo> shampoos = this.shampooService.findShampoosBySizeOrIdOrderByPriceAsc(Size.MEDIUM, 10L);
//        for (Shampoo shampoo : shampoos) {
//            System.out.println(shampoo.toString());
//        }

//        List<Shampoo> shampoos =
//                this.shampooService.findShampoosByPriceGreaterThanOrderByPriceDesc(new BigDecimal(5));
//        for (Shampoo shampoo : shampoos) {
//            System.out.println(shampoo.toString());
//        }

//        List<Ingredient> ingredients = this.ingredientService.findIngredientsByNameStartsWith("M");
//        for (Ingredient ingredient : ingredients) {
//            System.out.println(ingredient.getName());
//        }

//        List<String> list = List.of("Lavender", "Herbs", "Apple");
//        List<Ingredient> ingredients = this.ingredientService.findByNameInOrderByPriceAsc(list);
//        for (Ingredient ingredient : ingredients) {
//            System.out.println(ingredient.getName());
//        }

//        System.out.println(this.shampooService.countByPriceLessThan(new BigDecimal("8.50")));

//        List<String> ingredients = List.of("Berry", "Mineral-Collagen");
//        List<String> shampoos = this.shampooService.findShampoosBrandByIngredients(ingredients);
//        for (String shampoo : shampoos) {
//            System.out.println(shampoo);
//        }

        List<Shampoo> shampoos = this.shampooService.findShampoosByIngredientsLessThan(2);
        for (Shampoo shampoo : shampoos) {
            System.out.println(shampoo.getBrand());
        }
    }
}
