package bg.softuni.exercisespringdataautomappingobjects.service.user;

import bg.softuni.exercisespringdataautomappingobjects.model.dto.LoginUserDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.dto.RegisterUserDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.entities.User;
import bg.softuni.exercisespringdataautomappingobjects.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static bg.softuni.exercisespringdataautomappingobjects.Constant.Validation.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private String loggedUserName;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
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
        this.loggedUserName = optionalUser.get().getFullName();
        System.out.printf(SUCCESSFULLY_LOGGED + "%n", optionalUser.get().getFullName());
    }

    @Override
    public String logout() {
        if (this.loggedUserName == null) {
            return CANNOT_LOG_OUT;
        }

        return String.format(LOG_OUT, loggedUserName);
    }
}
