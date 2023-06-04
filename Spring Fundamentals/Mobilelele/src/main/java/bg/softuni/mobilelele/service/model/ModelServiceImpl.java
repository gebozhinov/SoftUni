package bg.softuni.mobilelele.service.model;

import bg.softuni.mobilelele.repositories.ModelRepository;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    @Override
    public void fillDb() {

    }

    @Override
    public boolean isDbFilled() {
        return this.modelRepository.count() > 0;
    }
}
