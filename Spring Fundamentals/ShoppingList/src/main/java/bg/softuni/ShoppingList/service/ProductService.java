package bg.softuni.ShoppingList.service;

import bg.softuni.ShoppingList.model.dto.AddProductDTO;
import bg.softuni.ShoppingList.model.dto.product.ProductInfo;
import bg.softuni.ShoppingList.model.dto.product.ProductInfoImpl;
import bg.softuni.ShoppingList.model.entity.Category;
import bg.softuni.ShoppingList.model.entity.Product;
import bg.softuni.ShoppingList.model.entity.User;
import bg.softuni.ShoppingList.model.mapper.ProductMapper;
import bg.softuni.ShoppingList.repository.CategoryRepository;
import bg.softuni.ShoppingList.repository.ProductRepository;
import bg.softuni.ShoppingList.repository.UserRepository;
import bg.softuni.ShoppingList.user.SessionUser;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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


        Product product = this.productMapper.addProductDtoToProduct(addProductDTO)
                .setCategory(category);

        this.productRepository.save(product);

    }

    public List<ProductInfoImpl> findAllFoods() {


        List<ProductInfo> foods = this.productRepository.findAllFoods().orElse(new ArrayList<>());

        return getProductInfos(foods);

    }
    public List<ProductInfoImpl> findAllDrinks() {


        List<ProductInfo> drinks = this.productRepository.findAllDrinks().orElse(new ArrayList<>());

        return getProductInfos(drinks);

    }
    public List<ProductInfoImpl> findAllHousehold() {


        List<ProductInfo> household = this.productRepository.findAllHousehold().orElse(new ArrayList<>());

        return getProductInfos(household);

    }
    public List<ProductInfoImpl> findAllOther() {


        List<ProductInfo> other = this.productRepository.findAllOther().orElse(new ArrayList<>());

        return getProductInfos(other);

    }

    public void buyProduct(Long id) {
        Product product = this.productRepository.findById(id).get();
        User user = this.userRepository.findById(this.sessionUser.getId()).get();

        if (user.getProducts().isEmpty()) {
            user.setProducts(new HashSet<>());
        }

        user.getProducts().add(product);
        this.userRepository.save(user);



    }

    public void buyAllProducts() {
        List<Product> products = this.productRepository.findAllProducts().orElse(new ArrayList<>());

        User user = this.userRepository.findById(this.sessionUser.getId()).get();

        if (user.getProducts().isEmpty()) {
            user.setProducts(new HashSet<>());
        }

        user.getProducts().addAll(products);
        this.userRepository.save(user);
    }
    private List<ProductInfoImpl> getProductInfos(List<ProductInfo> drinksList) {
        List<ProductInfoImpl> drinks = new ArrayList<>();
        for (ProductInfo productInfo : drinksList) {
            ProductInfoImpl product = new ProductInfoImpl();
            product.setId(productInfo.getId());
            product.setName(productInfo.getName());
            product.setPrice(productInfo.getPrice());
            drinks.add(product);

        }
        return drinks;
    }

}
