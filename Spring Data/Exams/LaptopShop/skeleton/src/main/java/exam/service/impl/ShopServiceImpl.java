package exam.service.impl;

import exam.model.dto.shop.ImportShopWrapper;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.NoSuchElementException;

import static exam.constant.Message.INVALID_DATA;
import static exam.constant.Message.SUCCESSFULLY_IMPORTED_SHOP;
import static exam.constant.Paths.IMPORT_SHOPS_PATH;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public ShopServiceImpl(ShopRepository shopRepository,
                           TownRepository townRepository,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(IMPORT_SHOPS_PATH);
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_SHOPS_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(ImportShopWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportShopWrapper unmarshal = (ImportShopWrapper) unmarshaller.unmarshal(file);
        unmarshal.getShops().forEach(importShopDTO -> {
            boolean isValid = validationUtils.isValid(importShopDTO);

            if (shopRepository.findFirstByName(importShopDTO.getName()).isPresent()) {
                isValid = false;
            }

            if (isValid) {
                Shop shop = modelMapper.map(importShopDTO, Shop.class);

                Town town = townRepository.findFirstByName(importShopDTO.getTown().getName())
                        .orElseThrow(NoSuchElementException::new);

                shop.setTown(town);
                shopRepository.saveAndFlush(shop);

                sb.append(String.format(SUCCESSFULLY_IMPORTED_SHOP, shop.getName(), shop.getIncome()))
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format(INVALID_DATA, "Shop"))
                        .append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }
}
