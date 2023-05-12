package exam.service.impl;

import exam.model.dto.town.ImportTownWrapper;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import static exam.constant.Message.INVALID_DATA;
import static exam.constant.Message.SUCCESSFULLY_IMPORTED_TOWN;
import static exam.constant.Paths.IMPORT_TOWNS_PATH;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;
    public TownServiceImpl(TownRepository townRepository,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(IMPORT_TOWNS_PATH);
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_TOWNS_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(ImportTownWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportTownWrapper unmarshal = (ImportTownWrapper) unmarshaller.unmarshal(file);
        unmarshal.getTowns().forEach(importTownDTO -> {
            boolean isValid = validationUtils.isValid(importTownDTO);

            if (isValid) {
                Town town = modelMapper.map(importTownDTO, Town.class);
                townRepository.saveAndFlush(town);

                sb.append(String.format(SUCCESSFULLY_IMPORTED_TOWN, town.getName()))
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format(INVALID_DATA, "Town"))
                        .append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }
}
