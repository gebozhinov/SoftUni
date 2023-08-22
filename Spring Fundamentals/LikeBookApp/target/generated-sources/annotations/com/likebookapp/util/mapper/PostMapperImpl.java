package com.likebookapp.util.mapper;

import com.likebookapp.model.dto.AddPostDTO;
import com.likebookapp.model.entity.Post;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-22T17:47:43+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post addPostDTOToPost(AddPostDTO addPostDTO) {
        if ( addPostDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setContent( addPostDTO.getContent() );

        return post;
    }
}
