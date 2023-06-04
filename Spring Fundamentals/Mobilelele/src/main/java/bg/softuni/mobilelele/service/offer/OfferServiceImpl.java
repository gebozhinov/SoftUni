package bg.softuni.mobilelele.service.offer;

import bg.softuni.mobilelele.repositories.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public void fillDb() {

    }

    @Override
    public boolean isDbFilled() {
        return this.offerRepository.count() > 0;
    }
}
