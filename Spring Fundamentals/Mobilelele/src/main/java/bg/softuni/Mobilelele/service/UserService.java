package bg.softuni.Mobilelele.service;


import bg.softuni.Mobilelele.model.dto.UserRegisterDTO;
import bg.softuni.Mobilelele.model.entity.UserEntity;
import bg.softuni.Mobilelele.model.mapper.UserMapper;
import bg.softuni.Mobilelele.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }



    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity user = userMapper.userRegisterDTOToUser(userRegisterDTO)
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        UserEntity saved = this.userRepository.saveAndFlush(user);
        login(saved);

    }
    private void login(UserEntity user) {
        // todo
    }


}
