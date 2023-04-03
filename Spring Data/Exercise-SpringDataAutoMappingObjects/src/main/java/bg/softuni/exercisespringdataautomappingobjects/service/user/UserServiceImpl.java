package bg.softuni.exercisespringdataautomappingobjects.service.user;

import bg.softuni.exercisespringdataautomappingobjects.model.dto.LoginUserDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.dto.RegisterUserDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.entities.Game;
import bg.softuni.exercisespringdataautomappingobjects.model.entities.User;
import bg.softuni.exercisespringdataautomappingobjects.repository.GameRepository;
import bg.softuni.exercisespringdataautomappingobjects.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static bg.softuni.exercisespringdataautomappingobjects.Constant.Validation.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final ModelMapper mapper;
    private User loggedUser;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.mapper = mapper;
    }

    @Override
    public void register(String[] args) {
        String email = args[1];
        String password = args[2];
        String confirmPassword = args[3];
        String fullName = args[4];

        RegisterUserDTO registerUserDto = new RegisterUserDTO(email, password, confirmPassword, fullName);
        User user = this.mapper.map(registerUserDto, User.class);
        if (userRepository.count() == 0) {
            user.setAdmin(true);
        }
        this.userRepository.save(user);

    }

    @Override
    @Transactional
    @Modifying
    public void login(String[] args) {
        String email = args[1];
        String password = args[2];
        LoginUserDTO loginUserDTO = new LoginUserDTO(email, password);

        User user = this.mapper.map(loginUserDTO, User.class);

        Optional<User> optionalUser = this.userRepository.findByEmail(user.getEmail());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException(INCORRECT_USERNAME_PASSWORD);
        }
        if (!optionalUser.get().getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException(INCORRECT_USERNAME_PASSWORD);
        }

        this.loggedUser = optionalUser.get();

        System.out.printf(SUCCESSFULLY_LOGGED + "%n", loggedUser.getFullName());
    }

    @Override
    public String logout() {
        if (loggedUser == null) {
            return CANNOT_LOG_OUT;
        }
        String name = loggedUser.getFullName();
        loggedUser = null;
        return String.format(LOG_OUT, name);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }
    @Transactional
    @Modifying
    @Override
    public void purchase(String gameTitle) {
        Game game = this.gameRepository.findByTitle(gameTitle).orElseThrow(NoSuchElementException::new);
        loggedUser.addGame(game);
        this.userRepository.save(loggedUser);
    }

    @Override
    public List<String> findOwnedGames() {
        return this.userRepository.findOwnedGames().orElseThrow(NoSuchElementException::new);
    }


}
