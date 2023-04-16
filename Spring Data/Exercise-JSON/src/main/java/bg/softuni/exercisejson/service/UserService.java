package bg.softuni.exercisejson.service;

import bg.softuni.exercisejson.model.dtos.user.UserAndProductWrapperDTO;
import bg.softuni.exercisejson.model.dtos.user.UserWithOneItemSoldDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserWithOneItemSoldDTO> findAllByProductsSold() throws IOException;
    UserAndProductWrapperDTO usersAndProducts() throws IOException;
}
