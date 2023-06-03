package bg.softuni.supermarket;


import bg.softuni.supermarket.domain.entities.Seller;
import bg.softuni.supermarket.repository.ShopRepository;
import bg.softuni.supermarket.service.category.CategoryService;
import bg.softuni.supermarket.service.product.ProductService;
import bg.softuni.supermarket.service.seller.SellerService;
import bg.softuni.supermarket.service.shop.ShopService;
import bg.softuni.supermarket.service.town.TownService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Component
public class DataInitializer implements CommandLineRunner {

    private static final String OPTIONS = """
            Choose option from:
            1 - for Add Category
            2 - for Add Town
            3 - for Add Shop
            4 - for Add Seller
            5 - for Add Product
            6 - for Set seller new manager
            7 - for Distributing product in shops
            8 - for Showing all sellers in Shop
            9 - for Showing all products in Shop
            10 - for End Program""";
    private final Scanner scanner;
    private final CategoryService categoryService;
    private final TownService townService;
    private final ShopService shopService;
    private final SellerService sellerService;
    private final ProductService productService;

    public DataInitializer(Scanner scanner,
                           CategoryService categoryService,
                           TownService townService,
                           ShopService shopService,
                           SellerService sellerService,
                           ProductService productService) {
        this.scanner = scanner;
        this.categoryService = categoryService;
        this.townService = townService;
        this.shopService = shopService;
        this.sellerService = sellerService;
        this.productService = productService;


    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Hi\n" + OPTIONS);

        int option = Integer.parseInt(scanner.nextLine());
        while (option != 10) {
            switch (option) {
                case 1 -> {
                    System.out.println("Enter category Name:");
                    String categoryName = scanner.nextLine();
                    System.out.println(categoryService.addCategory(categoryName));
                }
                case 2 -> {
                    System.out.println("Enter town Name:");
                    String townName = scanner.nextLine();
                    System.out.println(townService.addTown(townName));
                }
                case 3 -> {
                    System.out.println("Enter shop details in format: name address town");
                    String[] shopDetails = scanner.nextLine().split(" ");
                    System.out.println(shopService.addShop(shopDetails));
                }
                case 4 -> {
                    System.out.println("Enter seller details in format: firstName lastName age salary shopName");
                    String[] sellerDetails = scanner.nextLine().split(" ");
                    System.out.println(sellerService.addSeller(sellerDetails));
                }
                case 5 -> {
                    System.out.println("Enter product details in format: price bestBefore(dd-MM-yyyy) categoryName");
                    String[] productDetails = scanner.nextLine().split(" ");
                    System.out.println(productService.addProduct(productDetails));
                }
                case 6 -> {
                    System.out.println("Enter seller first and last names:");
                    String[] sellerNames = scanner.nextLine().split(" ");
                    System.out.println("Enter manager first and last names:");
                    String[] managerNames = scanner.nextLine().split(" ");
                    System.out.println(sellerService.addManager(sellerNames, managerNames));
                }
                case 7 -> {
                    System.out.println("Enter product name:");
                    String productName = scanner.nextLine();
                    System.out.println("Enter product distribution in Shops names in format [shopName1 shopName2 ... ]");
                    String[] shopNames = scanner.nextLine().split(" ");
                    System.out.println(productService.addProductDistribution(productName, shopNames));
                }
                case 8 -> {
                    System.out.println("Enter shop name:");
                    String shopName = scanner.nextLine();
                    System.out.println(shopService.getAllSellers(shopName));
                }
                case 9 -> {
                    System.out.println("Enter shop name:");
                    String shopName = scanner.nextLine();
                    System.out.println(shopService.getAllProducts(shopName));
                }
            }

            option = Integer.parseInt(scanner.nextLine());

        }

    }
}
