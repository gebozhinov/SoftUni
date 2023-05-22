package bg.softuni.nextleveltechnologies.service;

import bg.softuni.nextleveltechnologies.model.dtos.LoginDTO;
import bg.softuni.nextleveltechnologies.model.enitities.User;

import java.util.Optional;

public interface UserService {

    Optional<User> login(LoginDTO loginDTO);

}
