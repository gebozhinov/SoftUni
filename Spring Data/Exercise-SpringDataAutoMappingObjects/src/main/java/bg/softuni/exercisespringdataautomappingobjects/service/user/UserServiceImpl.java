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
import java.util.Set;

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


    @Override
    public List<String> findOwnedGames() {
        return this.userRepository.findOwnedGames().orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    @Modifying
    @Override
    public void addItem(String title) {
        Game game = this.gameRepository.findByTitle(title).orElseThrow(NoSuchElementException::new);
        if (isGameAlreadyAdded(game)) {
            throw new IllegalArgumentException(String.format("%s owns this game", this.loggedUser.getFullName()));
        }
        loggedUser.addItem(game);
        this.userRepository.save(loggedUser);
    }

    @Transactional
    @Modifying
    @Override
    public void removeItem(String title) {
        Game game = this.gameRepository.findByTitle(title).orElseThrow(NoSuchElementException::new);
        for (Game currenGame : loggedUser.getShoppingCart()) {
            if (currenGame.getTitle().equals(game.getTitle())) {
                loggedUser.removeItem(currenGame);
            }
        }
        this.userRepository.save(loggedUser);
    }

    @Override
    public String buyItem() {
        Set<Game> shoppingCart = loggedUser.getShoppingCart();
        loggedUser.getGames().addAll(shoppingCart);
        this.userRepository.save(loggedUser);

        StringBuilder sb = new StringBuilder();
        shoppingCart.forEach(game -> sb.append("-")
                .append(game.getTitle())
                .append(System.lineSeparator()));
        return sb.toString().trim();
    }
    private boolean isGameAlreadyAdded(Game gameToAdd) {
        for (Game game : this.loggedUser.getGames()) {
            if (game.getTitle().equals(gameToAdd.getTitle())) {
                return true;
            }
        }
        return false;
    }
}
