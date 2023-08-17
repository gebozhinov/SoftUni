package bg.softuni.Battleships.model.mapper;

import bg.softuni.Battleships.model.User;
import bg.softuni.Battleships.model.dto.RegisterUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegisterUserMapper {


    @Mapping(target = "password", ignore = true)
    User registerUserDTOToUser(RegisterUserDTO registerUserDTO);

}
