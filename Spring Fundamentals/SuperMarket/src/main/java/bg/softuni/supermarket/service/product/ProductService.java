package bg.softuni.supermarket.service.product;

public interface ProductService {

    String addProduct(String... productDetails);

    String addProductDistribution(String productName, String... shopNames);
}
