package bg.softuni.exercisejson;

import bg.softuni.exercisejson.service.CategoryService;
import bg.softuni.exercisejson.service.ProductService;
import bg.softuni.exercisejson.service.SeedService;
import bg.softuni.exercisejson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MainRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;
    @Autowired
    public MainRunner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedDatabase();
//        productService.findAllByPriceInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
//        userService.findAllByProductsSold();
//        categoryService.getAllByProductsCount();
//        userService.usersAndProducts();
    }
}
