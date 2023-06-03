package bg.softuni.supermarket.service.category;

import bg.softuni.supermarket.domain.entities.Category;
import bg.softuni.supermarket.repository.CategoryRepository;
import bg.softuni.supermarket.util.ValidationUtil;
import org.springframework.stereotype.Service;

import static bg.softuni.supermarket.constant.Messages.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String addCategory(String categoryName) {

        boolean isValid = categoryName.length() >= 2 && !categoryName.trim().isEmpty();


        if (!isValid) {
            return String.format(MINIMUM_TWO_CHARACTERS, "Name");
        } else if (categoryRepository.getFirstByName(categoryName).isPresent()) {
            return String.format(ALREADY_USED, "Category");
        }

        Category category = new Category();
        category.setName(categoryName);

        categoryRepository.saveAndFlush(category);

        return String.format(SUCCESSFULLY_ADDED, "category!");

    }
}
