package bg.softuni.exercisejson.service;

import bg.softuni.exercisejson.model.dtos.category.wrappers.CategoryImportWrapper;
import bg.softuni.exercisejson.model.dtos.product.wrappers.ProductImportWrapper;
import bg.softuni.exercisejson.model.dtos.user.wrappers.UserImportWrapper;
import bg.softuni.exercisejson.model.entities.Category;
import bg.softuni.exercisejson.model.entities.Product;
import bg.softuni.exercisejson.model.entities.User;
import bg.softuni.exercisejson.repository.CategoryRepository;
import bg.softuni.exercisejson.repository.ProductRepository;
import bg.softuni.exercisejson.repository.UserRepository;
import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;

import static bg.softuni.exercisejson.config.Paths.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ModelMapper modelmapper;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository, Gson gson, ModelMapper modelmapper) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.modelmapper = modelmapper;
    }

    @Override
    public void seedUsers() throws IOException, JAXBException {
        if (userRepository.count() == 0) {
//            FileReader fileReader = new FileReader(SEED_USERS_PATH.toFile());
            FileReader fileReader = new FileReader(SEED_USERS_XML_PATH.toFile());
//            List<User> users = Arrays.stream(gson.fromJson(fileReader, UserImportDTO[].class))
//                    .map(userImportDTO -> modelmapper.map(userImportDTO, User.class))
//                    .toList();

            JAXBContext context = JAXBContext.newInstance(UserImportWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            UserImportWrapper userImportWrapper = (UserImportWrapper) unmarshaller.unmarshal(fileReader);

            List<User> users = userImportWrapper.getUsers().stream()
                    .map(userImportDTO -> modelmapper.map(userImportDTO, User.class))
                    .toList();

            this.userRepository.saveAllAndFlush(users);
            fileReader.close();
        }
    }

    @Override
    public void seedCategories() throws IOException, JAXBException {
        if (categoryRepository.count() == 0) {
//            FileReader fileReader = new FileReader(SEED_CATEGORIES_PATH.toFile());
            FileReader fileReader = new FileReader(SEED_CATEGORIES_XML_PATH.toFile());

//            List<Category> categories = Arrays.stream(gson.fromJson(fileReader, CategoryImportDTO[].class))
//                    .map(categoryImportDTO -> modelmapper.map(categoryImportDTO, Category.class))
//                    .toList();

            JAXBContext context = JAXBContext.newInstance(CategoryImportWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CategoryImportWrapper unmarshal = (CategoryImportWrapper) unmarshaller.unmarshal(fileReader);
            List<Category> categories = unmarshal.getCategories().stream()
                    .map(categoryImportDTO -> modelmapper.map(categoryImportDTO, Category.class))
                    .toList();
            this.categoryRepository.saveAllAndFlush(categories);
            fileReader.close();
        }
    }

    @Override
    public void seedProducts() throws IOException, JAXBException {
        if (productRepository.count() == 0) {
//            FileReader fileReader = new FileReader(SEED_PRODUCTS_PATH.toFile());
            FileReader fileReader = new FileReader(SEED_PRODUCTS_XML_PATH.toFile());

//            List<Product> products = Arrays.stream(gson.fromJson(fileReader, ProductImportDTO[].class))
//                    .map(productImportDTO -> modelmapper.map(productImportDTO, Product.class))
//                    .map(this::setRandomCategory)
//                    .map(this::setRandomBuyer)
//                    .map(this::setRandomSeller)
//                    .toList();

            JAXBContext context = JAXBContext.newInstance(ProductImportWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ProductImportWrapper unmarshal = (ProductImportWrapper) unmarshaller.unmarshal(fileReader);
            List<Product> products = unmarshal.getProducts().stream()
                    .map(productImportDTO -> modelmapper.map(productImportDTO, Product.class))
                    .map(this::setRandomCategory)
                    .map(this::setRandomBuyer)
                    .map(this::setRandomSeller)
                    .toList();

            this.productRepository.saveAllAndFlush(products);
            fileReader.close();
        }
    }

    private Product setRandomCategory(Product product) {
        Random random = new Random();
        int numberOfCategories = random.nextInt((int) this.categoryRepository.count());

        Set<Category> categories = new HashSet<>();

        IntStream.range(0, numberOfCategories)
                .forEach(number -> {
                    Category category = this.categoryRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
                    categories.add(category);
                });

        product.setCategories(categories);

        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
            User buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

            while (buyer.equals(product.getSellerId())) {
                buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
            }
            product.setBuyerId(buyer);
        }
        return product;
    }

    private Product setRandomSeller(Product product) {
        User seller = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
        product.setSellerId(seller);
        return product;
    }
}
