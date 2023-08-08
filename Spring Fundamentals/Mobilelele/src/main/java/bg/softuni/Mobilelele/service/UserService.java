package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.dto.UserLoginDTO;
import bg.softuni.Mobilelele.model.dto.UserRegisterDTO;
import bg.softuni.Mobilelele.model.entity.UserEntity;
import bg.softuni.Mobilelele.repository.UserRepository;
import bg.softuni.Mobilelele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }


    public boolean login(UserLoginDTO userLoginDTO) {

        Optional<UserEntity> user = userRepository.login(userLoginDTO.getUsername());

        if (user.isEmpty()) {
            LOGGER.info("User with username [{}] not found.", userLoginDTO.getUsername());
            return false;
        }


        var rawPassword = userLoginDTO.getPassword();
        var encodedPassword = user.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(user.get());
        } else {
            logout();
        }

        return success;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity user = new UserEntity()
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setUsername(userRegisterDTO.getUsername())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        UserEntity saved = this.userRepository.saveAndFlush(user);
        login(saved);

    }
    private void login(UserEntity user) {
        currentUser.setName(user.getFirstName() + " " + user.getLastName())
                .setLogged(true);
    }
    public void logout() {
        currentUser.clear();
    }

}
