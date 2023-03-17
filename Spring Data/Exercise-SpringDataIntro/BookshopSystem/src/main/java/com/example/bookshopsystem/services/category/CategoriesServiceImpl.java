package com.example.bookshopsystem.services.category;

import com.example.bookshopsystem.models.Category;
import com.example.bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.example.bookshopsystem.constant.FilePath.CATEGORIES_FILE_NAME;
import static com.example.bookshopsystem.constant.FilePath.RESOURCE_URL;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoriesServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_URL + CATEGORIES_FILE_NAME))
                .stream()
                .filter(row -> !row.isBlank())
                .forEach(name -> {
                    Category category = new Category.Builder()
                            .withName(name)
                            .build();
                    this.categoryRepository.save(category);
                });

    }

    @Override
    public Category getRandomCategory() {
        final long count =  this.categoryRepository.count();
        if (count != 0) {
            final long randomCategoryId = new Random().nextLong(1L, count) + 1L;
            return this.categoryRepository.findById(randomCategoryId).orElseThrow(NullPointerException::new);
        }
        throw new RuntimeException();
    }
}
