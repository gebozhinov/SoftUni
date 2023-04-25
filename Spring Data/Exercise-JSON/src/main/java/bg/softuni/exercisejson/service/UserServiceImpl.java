package bg.softuni.exercisejson.service;

import bg.softuni.exercisejson.model.dtos.user.UserAndProductDTO;
import bg.softuni.exercisejson.model.dtos.user.wrappers.UserAndProductWrapperDTO;
import bg.softuni.exercisejson.model.dtos.user.UserDTO;
import bg.softuni.exercisejson.model.dtos.user.UserWithOneItemSoldDTO;
import bg.softuni.exercisejson.model.dtos.user.wrappers.UserWithOneItemSoldWrapper;
import bg.softuni.exercisejson.repository.UserRepository;
import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static bg.softuni.exercisejson.config.Paths.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public List<UserWithOneItemSoldDTO> findAllByProductsSold() throws IOException, JAXBException {
        List<UserWithOneItemSoldDTO> users = this.userRepository.findAllByProductsSold().orElseThrow(NoSuchElementException::new)
                .stream()
                .map(user -> modelMapper.map(user, UserWithOneItemSoldDTO.class)).toList();

        for (UserWithOneItemSoldDTO user : users) {
            user.getProductsSold().removeIf(productSold -> productSold.getBuyerIdLastName() == null);
        }

        FileWriter fileWriter = new FileWriter(EXPORT_USERS_WITH_MIN_ONE_PRODUCT_SOLD.toFile());
        gson.toJson(users, fileWriter);
        fileWriter.close();


        UserWithOneItemSoldWrapper userWithOneItemSoldWrapper = new UserWithOneItemSoldWrapper(users);
        File file = EXPORT_USERS_WITH_MIN_ONE_PRODUCT_SOLD_XML.toFile();
        JAXBContext context = JAXBContext.newInstance(UserWithOneItemSoldWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(userWithOneItemSoldWrapper, file);

        return users;
    }

    @Override
    public UserAndProductWrapperDTO usersAndProducts() throws IOException, JAXBException {

        final List<UserAndProductDTO> usersAndProducts = this.userRepository
                .findAllByProductsSoldIsNotNullOrderByFirstName()
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .map(UserDTO::toUserAndProductDTO)
                .collect(Collectors.toList());

        final UserAndProductWrapperDTO usersWithProductsWrapperDto = new UserAndProductWrapperDTO(usersAndProducts);

        FileWriter fileWriter = new FileWriter(EXPORT_USERS_AND_PRODUCTS.toFile());
        gson.toJson(usersWithProductsWrapperDto, fileWriter);
        fileWriter.close();

        File file = EXPORT_USERS_AND_PRODUCTS_XML.toFile();
        JAXBContext context = JAXBContext.newInstance(UserAndProductWrapperDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(usersWithProductsWrapperDto, file);

        return usersWithProductsWrapperDto;
    }
}
