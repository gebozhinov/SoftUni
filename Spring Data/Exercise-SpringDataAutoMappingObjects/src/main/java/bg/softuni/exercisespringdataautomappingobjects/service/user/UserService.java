package bg.softuni.exercisespringdataautomappingobjects.service.user;

import bg.softuni.exercisespringdataautomappingobjects.model.entities.User;

import java.util.List;

public interface UserService {
    void register(String[] args);

    void login(String[] args);

    String logout();

    User findByEmail(String email);

    void purchase(String gameTitle);

    List<String> findOwnedGames();


}
