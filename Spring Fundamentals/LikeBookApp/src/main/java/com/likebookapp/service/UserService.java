package com.likebookapp.service;

import com.likebookapp.model.dto.LoginUserDTO;
import com.likebookapp.model.dto.RegisterUserDTO;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.util.mapper.UserMapper;
import com.likebookapp.util.session.SessionUser;
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

        this.userRepository.saveAndFlush(user);
        this.login(user);

    }

    public boolean login(LoginUserDTO loginUserDTO) {

        Optional<User> optionalUser = this.userRepository.findByUsername(loginUserDTO.getUsername());

        if (optionalUser.isEmpty()) {
            return false;
        }

        String rawPassword = loginUserDTO.getPassword();
        String encodedPassword = optionalUser.get().getPassword();

        boolean matcher = this.passwordEncoder.matches(rawPassword, encodedPassword);

        if (matcher) {
            this.login(optionalUser.get());
            return true;
        }
        return false;
    }
    private void login(User user) {
        this.sessionUser.setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setLogged(true);
    }

    public void logout() {
        this.sessionUser.clear();
    }
}
