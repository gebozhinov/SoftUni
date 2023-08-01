package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.model.entity.BrandEntity;
import bg.softuni.Mobilelele.repository.BrandRepository;
import bg.softuni.Mobilelele.service.BrandService;
import org.springframework.stereotype.Service;

@Service

public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public String addBrand(BrandEntity brand) {

        this.brandRepository.saveAndFlush(brand);

        return "Successfully added brand";
    }
}
