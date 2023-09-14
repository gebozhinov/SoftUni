package bg.softuni.Mobilelele.service;


import bg.softuni.Mobilelele.model.dto.UserRegisterDTO;
import bg.softuni.Mobilelele.model.entity.UserEntity;
import bg.softuni.Mobilelele.model.mapper.UserMapper;
import bg.softuni.Mobilelele.repository.UserRepository;
import bg.softuni.Mobilelele.repository.UserRoleRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    public UserService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }



    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity user = userMapper.userRegisterDTOToUser(userRegisterDTO)
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()))
                .setRole(this.userRoleRepository.getUserRole());

        UserEntity saved = this.userRepository.saveAndFlush(user);
        login(saved);

    }
    private void login(UserEntity user) {
        // todo
    }


}
