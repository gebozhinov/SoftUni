package bg.softuni.ShoppingList.service;

import bg.softuni.ShoppingList.model.dto.AddProductDTO;
import bg.softuni.ShoppingList.model.dto.product.Food;
import bg.softuni.ShoppingList.model.dto.product.FoodImpl;
import bg.softuni.ShoppingList.model.entity.Category;
import bg.softuni.ShoppingList.model.entity.Product;
import bg.softuni.ShoppingList.model.entity.User;
import bg.softuni.ShoppingList.model.mapper.ProductMapper;
import bg.softuni.ShoppingList.repository.CategoryRepository;
import bg.softuni.ShoppingList.repository.ProductRepository;
import bg.softuni.ShoppingList.repository.UserRepository;
import bg.softuni.ShoppingList.user.SessionUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;
    private final SessionUser sessionUser;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          UserRepository userRepository,
                          ProductMapper productMapper,
                          SessionUser sessionUser) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.productMapper = productMapper;
        this.sessionUser = sessionUser;
    }


    public void add(AddProductDTO addProductDTO) {

        Category category = this.categoryRepository.findByOrdinalName(addProductDTO.getCategory()).orElse(null);
        User user = this.userRepository.findByUsername(this.sessionUser.getUsername()).orElse(null);

        Product product = this.productMapper.addProductDtoToProduct(addProductDTO)
                .setCategory(category)
                .setUser(user);

        this.productRepository.save(product);

    }

    public List<FoodImpl> findAllFoods() {


        List<Food> foodList = this.productRepository.findAllFoods(this.sessionUser.getId()).orElse(new ArrayList<>());

        List<FoodImpl> foods = new ArrayList<>();
        for (Food food : foodList) {
            FoodImpl foodImpl = new FoodImpl();
            foodImpl.setName(food.getName());
            foodImpl.setPrice(food.getPrice());
            foods.add(foodImpl);

        }
        return foods;

    }

}
