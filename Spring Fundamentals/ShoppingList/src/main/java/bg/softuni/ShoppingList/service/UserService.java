package bg.softuni.ShoppingList.service;

import bg.softuni.ShoppingList.model.dto.LoginUserDTO;
import bg.softuni.ShoppingList.model.dto.RegisterUserDTO;
import bg.softuni.ShoppingList.model.entity.User;
import bg.softuni.ShoppingList.model.mapper.UserMapper;
import bg.softuni.ShoppingList.repository.UserRepository;
import bg.softuni.ShoppingList.user.SessionUser;
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

        User user = this.userMapper.registerUserDtoToUser(registerUserDTO)
                .setPassword(this.passwordEncoder.encode(registerUserDTO.getPassword()));

        this.login(user);
        this.userRepository.save(user);

    }
    private void login(User user) {
        this.sessionUser.setId(user.getId())
                .setUsername(user.getUsername())
                .setLogged(true);
    }
    public boolean login(LoginUserDTO loginUserDTO) {

        Optional<User> user = this.userRepository.findByUsername(loginUserDTO.getUsername());
        if (user.isEmpty()) {
            return false;
        }

        String rawPassword = loginUserDTO.getPassword();
        String encodedPassword = user.get().getPassword();

        boolean matches = this.passwordEncoder.matches(rawPassword, encodedPassword);
        if (!matches) {
            return false;
        }

        this.login(user.get());
        return true;
    }
    public void logout() {
        this.sessionUser.clear();
    }
    public boolean isLogged() {
        return this.sessionUser.isLogged();
    }
}
