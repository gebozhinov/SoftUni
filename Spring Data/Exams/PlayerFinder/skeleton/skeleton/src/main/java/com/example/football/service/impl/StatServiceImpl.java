package com.example.football.service.impl;

import com.example.football.models.dto.ImportStatWrapper;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.example.football.constant.Message.INCORRECT_DATA;
import static com.example.football.constant.Message.SUCCESSFULLY_IMPORTED_STAT;
import static com.example.football.constant.Paths.IMPORT_STATS_PATH;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public StatServiceImpl(StatRepository statRepository,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }


    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(IMPORT_STATS_PATH);
    }

    @Override
    public String importStats() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_STATS_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(ImportStatWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportStatWrapper unmarshal = (ImportStatWrapper) unmarshaller.unmarshal(file);
        unmarshal.getStats()
                .forEach(importStatDTO -> {
                    boolean isValid = validationUtils.isValid(importStatDTO);

                    if (statRepository.findFirstByPassingAndShootingAndEndurance(
                                    importStatDTO.getPassing(),
                                    importStatDTO.getShooting(),
                                    importStatDTO.getEndurance())
                            .isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Stat stat = modelMapper.map(importStatDTO, Stat.class);
                        statRepository.saveAndFlush(stat);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_STAT,
                                        stat.getPassing(),
                                        stat.getShooting(),
                                        stat.getEndurance()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "Stat"))
                                .append(System.lineSeparator());
                    }

                });

        return sb.toString().trim();
    }
}
