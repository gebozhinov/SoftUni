package bg.softuni.exercisespringdataautomappingobjects.service.game;

import bg.softuni.exercisespringdataautomappingobjects.model.dto.GameDetailsDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.dto.GameInfoDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.entities.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {

    void add(String[] args);
    void edit(String[] args) throws NoSuchFieldException;
    Game findById(long id);

    String delete(long id);

    List<GameInfoDTO> findAllGames();

    GameDetailsDTO findGameDetails(String title);



}
