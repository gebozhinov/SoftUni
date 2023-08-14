package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.dto.BrandDTO;
import bg.softuni.Mobilelele.model.entity.BrandEntity;
import bg.softuni.Mobilelele.model.mapper.BrandMapper;
import bg.softuni.Mobilelele.repository.BrandRepository;
import bg.softuni.Mobilelele.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BrandService {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final BrandMapper brandMapper;

    public BrandService(BrandRepository brandRepository,
                        ModelRepository modelRepository,
                        BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.brandMapper = brandMapper;
    }

    public List<BrandDTO> getAllBrands() {

        List<BrandEntity> brands = this.brandRepository.getAllBrands();

        List<BrandDTO> brandDTOS = brandMapper.brandEntityToBrandDTO(brands);

        brandDTOS.forEach(brand ->
                brand.getModels().forEach(model -> model.setId(this.modelRepository.getIdOfModelByName(model.getName()))));


        return brandDTOS;
    }



}
