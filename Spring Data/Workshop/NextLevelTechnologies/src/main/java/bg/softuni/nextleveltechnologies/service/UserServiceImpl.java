package bg.softuni.nextleveltechnologies.service;

import bg.softuni.nextleveltechnologies.model.dtos.LoginDTO;
import bg.softuni.nextleveltechnologies.model.enitities.User;
import bg.softuni.nextleveltechnologies.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> login(LoginDTO loginDTO) {

        return this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
    }
}
