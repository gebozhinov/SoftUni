package com.example.football.service.impl;

import com.example.football.models.dto.ImportTeamDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtils;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static com.example.football.constant.Message.INCORRECT_DATA;
import static com.example.football.constant.Message.SUCCESSFULLY_IMPORTED_TEAM;
import static com.example.football.constant.Paths.IMPORT_TEAMS_PATH;
import static com.example.football.constant.Paths.IMPORT_TOWNS_PATH;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    private final TownRepository townRepository;
    private final Gson gson;

    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public TeamServiceImpl(TeamRepository teamRepository,
                           TownRepository townRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(IMPORT_TEAMS_PATH);
    }

    @Override
    public String importTeams() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent(), ImportTeamDTO[].class))
                .forEach(importTeamDTO -> {
                    boolean isValid = validationUtils.isValid(importTeamDTO);

                    if (teamRepository.findFirstByName(importTeamDTO.getName()).isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Team team = modelMapper.map(importTeamDTO, Team.class);
                        Town town = townRepository.findFirstByName(importTeamDTO.getTownName())
                                .orElseThrow(NoSuchElementException::new);
                        team.setTown(town);
                        teamRepository.saveAndFlush(team);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_TEAM, team.getName(), team.getFanBase()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "Team"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
