package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportOfferWrapper;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.enums.ApartmentType;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.INCORRECT_DATA;
import static softuni.exam.constant.Message.SUCCESSFULLY_IMPORTED_OFFERS;
import static softuni.exam.constant.Paths.IMPORT_OFFERS_PATH;

@Service
public class OfferServiceImpl implements OfferService {

    private final String PRINT_FORMAT = "Agent %s %s with offer №%d:%n" +
            "-Apartment area: %.2f%n" +
            "--Town: %s%n" +
            "---Price: %.2f$";

    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository,
                            AgentRepository agentRepository,
                            ApartmentRepository apartmentRepository,
                            ValidationUtils validationUtils,
                            ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(IMPORT_OFFERS_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_OFFERS_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(ImportOfferWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportOfferWrapper unmarshal = (ImportOfferWrapper) unmarshaller.unmarshal(file);

        unmarshal.getOffers().forEach(offer -> {
            boolean isValid = validationUtils.isValid(offer);

            Optional<Agent> agentByFirstName =
                    this.agentRepository.getAgentByFirstName(offer.getAgent().getName());
            if (agentByFirstName.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                Offer offerToSave = modelMapper.map(offer, Offer.class);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String date = offer.getPublishedOn();
                LocalDate publishedOn = LocalDate.parse(date, formatter);
                offerToSave.setPublishedOn(publishedOn);

                offerToSave.setAgent(agentByFirstName.get());

                Apartment apartment = this.apartmentRepository.getById(offer.getApartment().getId());
                offerToSave.setApartment(apartment);

                this.offerRepository.saveAndFlush(offerToSave);

                sb.append(String.format(SUCCESSFULLY_IMPORTED_OFFERS,
                                offerToSave.getPrice()))
                        .append(System.lineSeparator());

            } else {
                sb.append(String.format(INCORRECT_DATA, "offer"))
                        .append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }

    @Override
    public String exportOffers() {

        List<Offer> offers = this.offerRepository
                .findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType.three_rooms)
                .orElseThrow(NoSuchElementException::new);

        return offers.stream().map(offer -> String.format(PRINT_FORMAT,
                        offer.getAgent().getFirstName(),
                        offer.getAgent().getLastName(),
                        offer.getId(),
                        offer.getApartment().getArea(),
                        offer.getApartment().getTown().getTownName(),
                        offer.getPrice()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
