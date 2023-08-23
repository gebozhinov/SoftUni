package bg.softuni.Spotify.model.mapper;

import bg.softuni.Spotify.model.dto.RegisterUserDTO;
import bg.softuni.Spotify.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "password", ignore = true)
    User registerUserDTOToUser(RegisterUserDTO registerUserDTO);
}
