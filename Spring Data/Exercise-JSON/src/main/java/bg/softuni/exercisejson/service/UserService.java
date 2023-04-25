package bg.softuni.exercisejson.service;

import bg.softuni.exercisejson.model.dtos.user.wrappers.UserAndProductWrapperDTO;
import bg.softuni.exercisejson.model.dtos.user.UserWithOneItemSoldDTO;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserWithOneItemSoldDTO> findAllByProductsSold() throws IOException, JAXBException;
    UserAndProductWrapperDTO usersAndProducts() throws IOException, JAXBException;
}
