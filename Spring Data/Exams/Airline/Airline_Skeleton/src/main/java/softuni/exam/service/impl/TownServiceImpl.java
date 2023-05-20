package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.town.TownImportDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static softuni.exam.constant.Message.INVALID_DATA;
import static softuni.exam.constant.Message.SUCCESSFULLY_IMPORTED_TOWN;
import static softuni.exam.constant.Paths.IMPORT_TOWNS_PATH;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final Gson gson;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
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

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownImportDTO[].class))
                .forEach(townImportDTO -> {
                    boolean isValid = validationUtil.isValid(townImportDTO);

                    if (isValid) {
                        Town town = modelMapper.map(townImportDTO, Town.class);
                        townRepository.saveAndFlush(town);
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_TOWN,
                                        town.getName(),
                                        town.getPopulation()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INVALID_DATA, "Town"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
