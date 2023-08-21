package com.likebookapp.util.mapper;

import com.likebookapp.model.dto.RegisterUserDTO;
import com.likebookapp.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    User registerUserDTOToUser(RegisterUserDTO registerUserDTO);

}
