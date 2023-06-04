package bg.softuni.mobilelele.service.user;

import bg.softuni.mobilelele.domain.dto.LoggedUser;
import bg.softuni.mobilelele.domain.dto.UserLoginDTO;
import bg.softuni.mobilelele.domain.dto.UserRegisterDTO;
import bg.softuni.mobilelele.domain.dto.model.UserRoleModel;
import bg.softuni.mobilelele.domain.entities.User;
import bg.softuni.mobilelele.domain.entities.UserRole;
import bg.softuni.mobilelele.domain.enums.Role;
import bg.softuni.mobilelele.repositories.UserRepository;
import bg.softuni.mobilelele.repositories.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           ModelMapper modelMapper,
                           LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }


    @Override
    public void fillDb() {

    }

    @Override
    public boolean isDbFilled() {
        return this.userRepository.count() > 0;
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = modelMapper.map(userRegisterDTO, User.class);
        UserRole role = userRoleRepository.findFirstByRole(Role.valueOf(userRegisterDTO.getRole()));
        user.setRole(role);

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void loginUser(UserLoginDTO userLoginDTO) {

        User userToLogin = this.userRepository.findFirstByUsername(userLoginDTO.getUsername())
                .orElseThrow(NoSuchElementException::new);
        User user = modelMapper.map(userLoginDTO, User.class);

        if (!user.getPassword().equals(userToLogin.getPassword())) {
            throw new IllegalArgumentException("Incorrect password");
        }

        UserRole role =
                userRoleRepository.findFirstByRole(Role.valueOf(userToLogin.getRole().getRole().toString()));

        UserRoleModel map = modelMapper.map(role, UserRoleModel.class);

        this.loggedUser
                .setId(userToLogin.getId())
                .setUsername(userToLogin.getUsername())
                .setRoleModel(map);


    }

    @Override
    public void logout() {
        this.loggedUser.clearField();
    }
}
