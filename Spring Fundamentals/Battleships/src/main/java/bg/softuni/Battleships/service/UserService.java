package bg.softuni.Battleships.service;

import bg.softuni.Battleships.model.User;
import bg.softuni.Battleships.model.dto.LoginUserDTO;
import bg.softuni.Battleships.model.dto.RegisterUserDTO;
import bg.softuni.Battleships.model.mapper.RegisterUserMapper;
import bg.softuni.Battleships.repository.UserRepository;
import bg.softuni.Battleships.user.SessionUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RegisterUserMapper registerUserMapper;
    private final PasswordEncoder passwordEncoder;
    private final SessionUser sessionUser;

    public UserService(UserRepository userRepository,
                       RegisterUserMapper registerUserMapper,
                       PasswordEncoder passwordEncoder,
                       SessionUser sessionUser) {
        this.userRepository = userRepository;
        this.registerUserMapper = registerUserMapper;
        this.passwordEncoder = passwordEncoder;
        this.sessionUser = sessionUser;
    }

    public void registerAndLogin(RegisterUserDTO registerUserDTO) {

        User user = this.registerUserMapper.registerUserDTOToUser(registerUserDTO)
                .setPassword(this.passwordEncoder.encode(registerUserDTO.getPassword()));
        this.userRepository.save(user);

        this.login(user);

    }

    private void login(User user) {
        this.sessionUser
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setFullName(user.getFullName())
                .setLogged(true);
    }

    public boolean login(LoginUserDTO loginUserDTO) {

        Optional<User> optionalUser =
                this.userRepository.findByUsername(loginUserDTO.getUsername());

        if (optionalUser.isEmpty()) {
            return false;
        }

        String rawPassword = loginUserDTO.getPassword();
        String encodedPassword = optionalUser.get().getPassword();

        boolean matches = this.passwordEncoder.matches(rawPassword, encodedPassword);

        if (matches) {
            this.login(optionalUser.get());
            return true;
        } else {
            return false;
        }

    }
    public void logout() {
        this.sessionUser.clear();
    }
}
