package bg.softuni.exercisespringdataautomappingobjects.service.user;

public interface UserService {
    void register(String[] args);

    void login(String[] args);

    String logout();
}
