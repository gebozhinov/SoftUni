package com.example.football.service.impl;

import com.example.football.models.dto.ImportPlayerWrapper;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

import static com.example.football.constant.Message.INCORRECT_DATA;
import static com.example.football.constant.Message.SUCCESSFULLY_IMPORTED_PLAYER;
import static com.example.football.constant.Paths.IMPORT_PLAYERS_PATH;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PRINT_OUTPUT = "Player - %s %s%n" +
            "\tPosition - %s%n" +
            "\tTeam - %s%n" +
            "\tStadium - %s%n";

    private final PlayerRepository playerRepository;

    private final TownRepository townRepository;

    private final TeamRepository teamRepository;

    private final StatRepository statRepository;

    private final ModelMapper modelMapper;

    private final ValidationUtils validationUtils;

    public PlayerServiceImpl(PlayerRepository playerRepository,
                             TownRepository townRepository,
                             TeamRepository teamRepository,
                             StatRepository statRepository,
                             ModelMapper modelMapper,
                             ValidationUtils validationUtils) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }


    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(IMPORT_PLAYERS_PATH);
    }

    @Override
    public String importPlayers() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_PLAYERS_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(ImportPlayerWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportPlayerWrapper unmarshal = (ImportPlayerWrapper) unmarshaller.unmarshal(file);
        unmarshal.getPlayers().forEach(importPlayerDTO -> {
            boolean isValid = validationUtils.isValid(importPlayerDTO);

            if (playerRepository.findFirstByEmail(importPlayerDTO.getEmail()).isPresent()) {
                isValid = false;
            }

            if (isValid) {
                Player player = modelMapper.map(importPlayerDTO, Player.class);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String date = importPlayerDTO.getBirthdate();
                LocalDate birthdate = LocalDate.parse(date, formatter);

                Town town = this.townRepository.findFirstByName(importPlayerDTO.getTown().getName())
                        .orElseThrow(NoSuchElementException::new);
                Team team = this.teamRepository.findFirstByName(importPlayerDTO.getTeam().getName())
                        .orElseThrow(NoSuchElementException::new);
                Stat stat = this.statRepository.findById(importPlayerDTO.getStat().getId())
                        .orElseThrow(NoSuchElementException::new);

                player.setTown(town);
                player.setTeam(team);
                player.setStat(stat);
                player.setBirthdate(birthdate);

                this.playerRepository.saveAndFlush(player);

                sb.append(String.format(SUCCESSFULLY_IMPORTED_PLAYER,
                                player.getFirstName(),
                                player.getLastName(),
                                player.getPosition().toString()))
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format(INCORRECT_DATA, "Player"))
                        .append(System.lineSeparator());
            }

        });

        return sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {

        List<Player> players = this.playerRepository.findBestPlayers(LocalDate.of(1995, 1, 1),
                        LocalDate.of(2003, 1, 1))
                .orElseThrow(NoSuchElementException::new);

        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(String.format(PRINT_OUTPUT,
                    player.getFirstName(),
                    player.getLastName(),
                    player.getPosition().toString(),
                    player.getTeam().getName(),
                    player.getTeam().getStadiumName()));
        }
        return sb.toString().trim();
    }
}
