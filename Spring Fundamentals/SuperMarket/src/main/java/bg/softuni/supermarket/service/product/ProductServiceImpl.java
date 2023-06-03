package bg.softuni.supermarket.service.product;

import bg.softuni.supermarket.domain.entities.Category;
import bg.softuni.supermarket.domain.entities.Product;
import bg.softuni.supermarket.domain.entities.Shop;
import bg.softuni.supermarket.repository.CategoryRepository;
import bg.softuni.supermarket.repository.ProductRepository;
import bg.softuni.supermarket.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import static bg.softuni.supermarket.constant.Messages.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final ShopRepository shopRepository;
    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              ShopRepository shopRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public String addProduct(String... productDetails) {

        String productName = productDetails[0];
        if (productName.length() < 2 || productName.trim().isEmpty()) {
            return String.format(MINIMUM_TWO_CHARACTERS, "Product name");
        }

        double price = Double.parseDouble(productDetails[1]);
        if (price < 0) {
            return String.format(POSITIVE_NUMBER, "Price");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String str = productDetails[2];
        LocalDate bestBefore = LocalDate.parse(str, formatter);

        String categoryName = productDetails[3];
        Category category = categoryRepository.getFirstByName(categoryName).orElseThrow(NoSuchElementException::new);

        Product product = new Product();
        product.setName(productName);
        product.setPrice(BigDecimal.valueOf(price));
        product.setBestBefore(bestBefore);
        product.setCategory(category);

        productRepository.saveAndFlush(product);

        return String.format(SUCCESSFULLY_ADDED, "product!");
    }

    @Override
    public String addProductDistribution(String productName, String... shopNames) {

        Product product = productRepository.findFirstByName(productName)
                .orElseThrow(NoSuchElementException::new);

        Set<Shop> shops = new HashSet<>();
        for (String shopName : shopNames) {
            Shop shop = shopRepository.getFirstByName(shopName).orElseThrow(NoSuchElementException::new);
            shops.add(shop);
        }

        product.setShops(shops);
        productRepository.saveAndFlush(product);
        return String.format(SUCCESSFULLY_ADDED, "product distribution!");
    }
}
