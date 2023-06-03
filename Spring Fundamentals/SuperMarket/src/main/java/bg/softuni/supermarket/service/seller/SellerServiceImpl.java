package bg.softuni.supermarket.service.seller;

import bg.softuni.supermarket.domain.entities.Seller;
import bg.softuni.supermarket.domain.entities.Shop;
import bg.softuni.supermarket.repository.SellerRepository;
import bg.softuni.supermarket.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import static bg.softuni.supermarket.constant.Messages.*;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ShopRepository shopRepository;
    public SellerServiceImpl(SellerRepository sellerRepository,
                             ShopRepository shopRepository) {
        this.sellerRepository = sellerRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public String addSeller(String... sellerDetails) {

        String firstName = sellerDetails[0];
        if (firstName.length() < 2 || firstName.trim().isEmpty()) {
            return String.format(MINIMUM_TWO_CHARACTERS, "First name");
        }

        String lastName = sellerDetails[1];
        if (lastName.length() < 2 || lastName.trim().isEmpty()) {
            return String.format(MINIMUM_TWO_CHARACTERS, "Last name");
        }

        int age = Integer.parseInt(sellerDetails[2]);
        if (age < 18) {
            return MINIMUM_AGE;
        }

        double salary = Double.parseDouble(sellerDetails[3]);
        if (salary < 0) {
            return String.format(POSITIVE_NUMBER, "Salary");
        }

        String shopName = sellerDetails[4];
        Shop shop = shopRepository.getFirstByName(shopName).orElseThrow(NoSuchElementException::new);

        Seller seller = new Seller();
        seller.setFirstName(firstName);
        seller.setLastName(lastName);
        seller.setAge(age);
        seller.setSalary(BigDecimal.valueOf(salary));
        seller.setShop(shop);

        sellerRepository.saveAndFlush(seller);
        return String.format(SUCCESSFULLY_ADDED, "seller!");
    }

    @Override
    public String addManager(String[] sellerNames, String[] managerNames) {

        Seller seller = sellerRepository.findFirstByFirstNameAndLastName(sellerNames[0], sellerNames[1])
                .orElseThrow(NoSuchElementException::new);

        Seller manager = sellerRepository.findFirstByFirstNameAndLastName(managerNames[0], managerNames[1])
                .orElseThrow(NoSuchElementException::new);

        seller.setManager(manager);

        sellerRepository.saveAndFlush(seller);
        return String.format(SUCCESSFULLY_ADDED, "manager!");
    }
}
