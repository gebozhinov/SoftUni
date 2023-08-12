package bg.softuni.Mobilelele.model.mapper;

import bg.softuni.Mobilelele.model.dto.UserRegisterDTO;
import bg.softuni.Mobilelele.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    @Mapping(target = "password", ignore = true)
    UserEntity userRegisterDTOToUser(UserRegisterDTO userRegisterDTO);
}
