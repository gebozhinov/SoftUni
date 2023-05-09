package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportAgentDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static softuni.exam.constant.Message.INCORRECT_DATA;
import static softuni.exam.constant.Message.SUCCESSFULLY_IMPORTED_AGENTS;
import static softuni.exam.constant.Paths.IMPORT_AGENTS_PATH;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public AgentServiceImpl(AgentRepository agentRepository,
                            TownRepository townRepository,
                            Gson gson,
                            ModelMapper modelMapper,
                            ValidationUtils validationUtils) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(IMPORT_AGENTS_PATH);
    }

    @Override
    public String importAgents() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readAgentsFromFile(), ImportAgentDTO[].class))
                .forEach(importAgentDTO -> {
                    boolean isValid = validationUtils.isValid(importAgentDTO);

                    if (this.agentRepository.getAgentByFirstName(importAgentDTO.getFirstName()).isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Agent agent = modelMapper.map(importAgentDTO, Agent.class);

                        Town town = this.townRepository.getTownByTownName(importAgentDTO.getTown())
                                .orElseThrow(NoSuchElementException::new);
                        agent.setTown(town);

                        this.agentRepository.saveAndFlush(agent);
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_AGENTS,
                                        agent.getFirstName(),
                                        agent.getLastName()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "agent"))
                                .append(System.lineSeparator());
                    }
                });


        return sb.toString().trim();
    }
}
