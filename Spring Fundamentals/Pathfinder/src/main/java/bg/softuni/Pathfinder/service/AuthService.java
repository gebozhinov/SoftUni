package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.User;
import bg.softuni.Pathfinder.model.dto.UserRegistrationDTO;
import bg.softuni.Pathfinder.repository.AuthRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository,
                       PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void register(UserRegistrationDTO userRegistrationDTO) {

        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            throw new RuntimeException("password.match");
        }

        Optional<User> userByEmail = authRepository.findByEmail(userRegistrationDTO.getEmail());
        if (userByEmail.isPresent()) {
            throw new RuntimeException("email>exist");
        }


        User user = new User()
                .setUsername(userRegistrationDTO.getUsername())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()))
                .setEmail(userRegistrationDTO.getEmail())
                .setAge(userRegistrationDTO.getAge())
                .setFullName(userRegistrationDTO.getFullName());

        authRepository.save(user);
    }

    public User findUserByUsername(String username) {
       return this.authRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
