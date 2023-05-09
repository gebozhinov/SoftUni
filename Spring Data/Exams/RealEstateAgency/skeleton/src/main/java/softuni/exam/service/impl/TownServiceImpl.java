package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportTownDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static softuni.exam.constant.Message.INCORRECT_DATA;
import static softuni.exam.constant.Message.SUCCESSFULLY_IMPORTED_TOWNS;
import static softuni.exam.constant.Paths.IMPORT_TOWNS_PATH;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;
    public TownServiceImpl(TownRepository townRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils) {
        this.townRepository = townRepository;
        this.gson = gson;
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
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), ImportTownDTO[].class))
                .forEach(importTownDTO -> {
                    boolean isValid = validationUtils.isValid(importTownDTO);

                    if (this.townRepository.getTownByTownName(importTownDTO.getTownName()).isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        this.townRepository.saveAndFlush(modelMapper.map(importTownDTO, Town.class));
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_TOWNS,
                                importTownDTO.getTownName(),
                                importTownDTO.getPopulation()));
                        sb.append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "town")).append(System.lineSeparator());
                    }

                });

        return sb.toString().trim();
    }
}
