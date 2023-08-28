package bg.softuni.ShoppingList.model.mapper;

import bg.softuni.ShoppingList.model.dto.RegisterUserDTO;
import bg.softuni.ShoppingList.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "password", ignore = true)
    User registerUserDtoToUser(RegisterUserDTO registerUserDTO);

}
