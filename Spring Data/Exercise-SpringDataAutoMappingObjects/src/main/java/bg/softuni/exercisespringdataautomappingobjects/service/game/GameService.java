package bg.softuni.exercisespringdataautomappingobjects.service.game;

import bg.softuni.exercisespringdataautomappingobjects.model.entities.Game;

import java.util.Optional;

public interface GameService {

    void add(String[] args);
    void edit(String[] args) throws NoSuchFieldException;
    Game findById(long id);

    String delete(long id);

}
