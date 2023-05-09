package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportApartmentsWrapper;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.NoSuchElementException;

import static softuni.exam.constant.Message.INCORRECT_DATA;
import static softuni.exam.constant.Message.SUCCESSFULLY_IMPORTED_APARTMENTS;
import static softuni.exam.constant.Paths.IMPORT_APARMENTS_PATH;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository,
                                TownRepository townRepository,
                                ModelMapper modelMapper,
                                ValidationUtils validationUtils) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(IMPORT_APARMENTS_PATH);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_APARMENTS_PATH.toFile();

        JAXBContext context = JAXBContext.newInstance(ImportApartmentsWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportApartmentsWrapper unmarshal = (ImportApartmentsWrapper) unmarshaller.unmarshal(file);
        unmarshal.getApartments()
                .forEach(apartment -> {
                    boolean isValid = validationUtils.isValid(apartment);

                    if (this.apartmentRepository.findFirstByAreaAndTown_TownName(
                            apartment.getArea(), apartment.getTown()).isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Apartment apartmentToSave = modelMapper.map(apartment, Apartment.class);
                        Town town = this.townRepository.getTownByTownName(apartment.getTown())
                                .orElseThrow(NoSuchElementException::new);
                        apartmentToSave.setTown(town);

                        this.apartmentRepository.saveAndFlush(apartmentToSave);
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_APARTMENTS,
                                        apartmentToSave.getApartmentType(),
                                        apartmentToSave.getArea()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "apartment"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
