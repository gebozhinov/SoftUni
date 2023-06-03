package bg.softuni.supermarket.service.seller;

public interface SellerService {

    String addSeller(String... sellerDetails);

    String addManager(String[] sellerNames, String[] managerNames);
}
