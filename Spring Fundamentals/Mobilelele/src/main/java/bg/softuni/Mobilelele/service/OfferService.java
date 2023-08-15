package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.dto.AddOfferDTO;
import bg.softuni.Mobilelele.model.entity.ModelEntity;
import bg.softuni.Mobilelele.model.entity.OfferEntity;
import bg.softuni.Mobilelele.model.entity.UserEntity;
import bg.softuni.Mobilelele.model.mapper.OfferMapper;
import bg.softuni.Mobilelele.repository.ModelRepository;
import bg.softuni.Mobilelele.repository.OfferRepository;
import bg.softuni.Mobilelele.repository.UserRepository;
import bg.softuni.Mobilelele.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;

    private final ModelRepository modelRepository;
    private final CurrentUser currentUser;
    private final OfferMapper offerMapper;


    public OfferService(OfferRepository offerRepository,
                        UserRepository userRepository,
                        ModelRepository modelRepository,
                        CurrentUser currentUser,
                        OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {

        OfferEntity newOffer = offerMapper.addOfferDTOToOfferEntity(addOfferDTO);

        UserEntity seller = userRepository.login(currentUser.getUsername()).orElseThrow();

        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);

    }
}
