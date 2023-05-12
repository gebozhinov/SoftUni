package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.laptop.ImportLaptopDTO;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static exam.constant.Message.INVALID_DATA;
import static exam.constant.Message.SUCCESSFULLY_IMPORTED_LAPTOP;
import static exam.constant.Paths.IMPORT_LAPTOPS_PATH;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String PRINT_OUTPUT = "Laptop - %s%n" +
            "*Cpu speed - %.2f%n" +
            "**Ram - %d%n" +
            "***Storage - %d%n" +
            "****Price - %.2f%n" +
            "#Shop name - %s%n" +
            "##Town - %s%n";
    private final LaptopRepository laptopRepository;

    private final ShopRepository shopRepository;
    private final Gson gson;

    private final ModelMapper modelMapper;

    private final ValidationUtils validationUtils;

    public LaptopServiceImpl(LaptopRepository laptopRepository,
                             ShopRepository shopRepository,
                             Gson gson,
                             ModelMapper modelMapper,
                             ValidationUtils validationUtils) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(IMPORT_LAPTOPS_PATH);
    }

    @Override
    public String importLaptops() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readLaptopsFileContent(), ImportLaptopDTO[].class))
                .forEach(importLaptopDTO -> {
                    boolean isValid = validationUtils.isValid(importLaptopDTO);

                    boolean isWarrantyType = !importLaptopDTO.getWarrantyType().equals("BASIC") &&
                            !importLaptopDTO.getWarrantyType().equals("PREMIUM") &&
                            !importLaptopDTO.getWarrantyType().equals("LIFETIME");

                    if (laptopRepository.findFirstByMacAddress(importLaptopDTO.getMacAddress()).isPresent() ||
                            isWarrantyType) {
                        isValid = false;
                    }

                    if (isValid) {
                        Laptop laptop = modelMapper.map(importLaptopDTO, Laptop.class);
                        Shop shop = shopRepository.findFirstByName(importLaptopDTO.getShop().getName())
                                .orElseThrow(NoSuchElementException::new);
                        laptop.setShop(shop);

                        laptopRepository.saveAndFlush(laptop);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_LAPTOP,
                                        laptop.getMacAddress(),
                                        laptop.getCpuSpeed(),
                                        laptop.getRam(),
                                        laptop.getStorage()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INVALID_DATA, "Laptop"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }

    @Override
    public String exportBestLaptops() {

        StringBuilder sb = new StringBuilder();

        List<Laptop> laptops = laptopRepository.getBestLaptops().orElseThrow(NoSuchElementException::new);
        laptops.forEach(laptop -> sb.append(String.format(PRINT_OUTPUT,
                laptop.getMacAddress(),
                laptop.getCpuSpeed(),
                laptop.getRam(),
                laptop.getStorage(),
                laptop.getPrice(),
                laptop.getShop().getName(),
                laptop.getShop().getTown().getName())));

        return sb.toString().trim();
    }
}
