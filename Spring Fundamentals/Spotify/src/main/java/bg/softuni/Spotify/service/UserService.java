package bg.softuni.Spotify.service;

import bg.softuni.Spotify.model.dto.LoginUserDTO;
import bg.softuni.Spotify.model.dto.RegisterUserDTO;
import bg.softuni.Spotify.model.entity.User;
import bg.softuni.Spotify.model.mapper.UserMapper;
import bg.softuni.Spotify.repository.UserRepository;
import bg.softuni.Spotify.user.SessionUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final SessionUser sessionUser;
    public UserService(UserRepository userRepository,
                       UserMapper userMapper,
                       PasswordEncoder passwordEncoder,
                       SessionUser sessionUser) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.sessionUser = sessionUser;
    }

    public void register(RegisterUserDTO registerUserDTO) {

        User user = this.userMapper.registerUserDTOToUser(registerUserDTO)
                .setPassword(this.passwordEncoder.encode(registerUserDTO.getPassword()));

        this.userRepository.save(user);

        this.login(user);


    }

    public boolean login(LoginUserDTO loginUserDTO) {

        Optional<User> optionalUser = this.userRepository.findByUsername(loginUserDTO.getUsername());

        if (optionalUser.isEmpty()) {
            return false;
        }

        String encodedPassword = optionalUser.get().getPassword();
        String rawPassword = loginUserDTO.getPassword();

        boolean matches = this.passwordEncoder.matches(rawPassword, encodedPassword);

        if (matches) {
            this.login(optionalUser.get());
            return true;
        }

        return false;
    }

    private void login(User user) {
        this.sessionUser
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setLogged(true);

    }
}
