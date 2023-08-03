package bg.softuni.Mobilelele;

import bg.softuni.Mobilelele.model.entity.BrandEntity;
import bg.softuni.Mobilelele.service.BrandService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner  {

    private final BrandService brandService;

    public DataInitializer(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public void run(String... args) throws Exception {

//        BrandEntity brand = new BrandEntity();
//        brand.setCreated(LocalDate.now());
//        brand.setModified(LocalDate.now());
//        brand.setName("Audi");
//
//        brandService.addBrand(brand);

    }
}
