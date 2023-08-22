package com.likebookapp.util.mapper;

import com.likebookapp.model.dto.RegisterUserDTO;
import com.likebookapp.model.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-22T17:47:43+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User registerUserDTOToUser(RegisterUserDTO registerUserDTO) {
        if ( registerUserDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( registerUserDTO.getUsername() );
        user.setEmail( registerUserDTO.getEmail() );

        return user;
    }
}
