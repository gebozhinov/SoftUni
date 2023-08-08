package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service

public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


}
