package bg.softuni.supermarket.service.shop;


public interface ShopService {

    String addShop(String... shopDetails);

    String getAllSellers(String shopName);

    String getAllProducts(String shopName);
}
