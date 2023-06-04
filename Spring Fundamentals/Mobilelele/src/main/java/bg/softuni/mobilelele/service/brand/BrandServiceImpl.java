package bg.softuni.mobilelele.service.brand;

import bg.softuni.mobilelele.repositories.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public void fillDb() {

    }

    @Override
    public boolean isDbFilled() {
        return this.brandRepository.count() > 0;
    }
}
