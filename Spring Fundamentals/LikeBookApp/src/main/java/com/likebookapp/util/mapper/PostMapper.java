package com.likebookapp.util.mapper;

import com.likebookapp.model.dto.AddPostDTO;
import com.likebookapp.model.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {


    Post addPostDTOToPost(AddPostDTO addPostDTO);

}
