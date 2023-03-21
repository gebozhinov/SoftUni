package com.example.advquerying.service.shampoo;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findShampoosBySizeOrderById(Size size) {
        return shampooRepository.findShampoosBySizeOrderById(size).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Shampoo> findShampoosBySizeOrIdOrderByPriceAsc(Size size, Long id) {
        return shampooRepository.findShampoosBySizeOrLabelIdOrderByPriceAsc(size, id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Shampoo> findShampoosByPriceGreaterThanOrderByPriceDesc(BigDecimal price) {
        return shampooRepository.findShampoosByPriceGreaterThanOrderByPriceDesc(price)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Long countByPriceLessThan(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<String> findShampoosBrandByIngredients(List<String> name) {
        List<String> resultList = new ArrayList<>();
        List<Shampoo> shampoos = this.shampooRepository.findShampoosByIngredientsIn(name)
                .orElseThrow(NoSuchElementException::new);
        for (Shampoo shampoo : shampoos) {
            if (!resultList.contains(shampoo.getBrand())) {
                resultList.add(shampoo.getBrand());
            }
        }
        return resultList;
    }

    @Override
    public List<Shampoo> findShampoosByIngredientsLessThan(int count) {
        return this.shampooRepository.findShampoosByIngredientsLessThan(count);
    }
}
