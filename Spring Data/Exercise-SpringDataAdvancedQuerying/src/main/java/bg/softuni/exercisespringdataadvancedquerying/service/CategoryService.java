package bg.softuni.exercisespringdataadvancedquerying.service;

import bg.softuni.exercisespringdataadvancedquerying.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
