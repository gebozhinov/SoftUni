package com.example.football.service.impl;

import com.example.football.models.dto.ImportTownDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtils;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static com.example.football.constant.Message.INCORRECT_DATA;
import static com.example.football.constant.Message.SUCCESSFULLY_IMPORTED_TOWN;
import static com.example.football.constant.Paths.IMPORT_TOWNS_PATH;


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

        Arrays.stream(this.gson.fromJson(readTownsFileContent(), ImportTownDTO[].class))
                .forEach(importTownDTO -> {
                    boolean isValid = validationUtils.isValid(importTownDTO);

                    if (townRepository.findFirstByName(importTownDTO.getName()).isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Town town = modelMapper.map(importTownDTO, Town.class);
                        townRepository.saveAndFlush(town);
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_TOWN, town.getName(), town.getPopulation()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "Town")).append(System.lineSeparator());
                    }
                });
        return sb.toString().trim();
    }
}
