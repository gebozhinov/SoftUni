package bg.softuni.supermarket.service.shop;

import bg.softuni.supermarket.domain.entities.Product;
import bg.softuni.supermarket.domain.entities.Seller;
import bg.softuni.supermarket.domain.entities.Shop;
import bg.softuni.supermarket.domain.entities.Town;
import bg.softuni.supermarket.repository.ShopRepository;
import bg.softuni.supermarket.repository.TownRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.supermarket.constant.Messages.*;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final TownRepository townRepository;

    public ShopServiceImpl(ShopRepository shopRepository,
                           TownRepository townRepository) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
    }

    @Override
    public String addShop(String... shopDetails) {

        String shopName = shopDetails[0];
        if (shopName.length() < 2 || shopName.trim().isBlank()) {
            return String.format(MINIMUM_TWO_CHARACTERS, "Name");
        }

        String address = shopDetails[1];
        if (address.length() < 2) {
            return String.format(MINIMUM_TWO_CHARACTERS, "Address");
        }

        if (shopRepository.getFirstByName(shopName).isPresent()) {
            return String.format(ALREADY_USED, "Shop");
        }

        String townName = shopDetails[2];
        Town town = townRepository.findFirstByName(townName).orElseThrow(NoSuchElementException::new);

        Shop shop = new Shop();
        shop.setName(shopName);
        shop.setAddress(address);
        shop.setTown(town);

        shopRepository.saveAndFlush(shop);
        return String.format(SUCCESSFULLY_ADDED, "shop!");
    }

    @Override
    public String getAllSellers(String shopName) {

        StringBuilder sb = new StringBuilder();
        List<Seller> sellers =
                shopRepository.getAllSellers(shopName).orElseThrow(NoSuchElementException::new);
        for (Seller seller : sellers) {
            sb.append(seller.getFirstName())
                    .append(" ")
                    .append(seller.getLastName())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String getAllProducts(String shopName) {

        StringBuilder sb = new StringBuilder();
        List<Product> products =
                shopRepository.getAllProducts(shopName).orElseThrow(NoSuchElementException::new);
        for (Product product : products) {
            sb.append(product.getName())
                    .append(" - ")
                    .append(product.getPrice())
                    .append(" $")
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
