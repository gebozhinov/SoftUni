package com.example.bookshopsystem.services.category;

import com.example.bookshopsystem.models.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoriesService {
    void seedCategories() throws IOException;
    Category getRandomCategory();
}
