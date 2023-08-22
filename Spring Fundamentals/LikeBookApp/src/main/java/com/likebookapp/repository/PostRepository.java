package com.likebookapp.repository;

import com.likebookapp.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    @Query(value = "SELECT * FROM posts " +
            "WHERE user_id != :id",nativeQuery = true)
    Optional<List<Post>> findAllOtherPosts(Long id);

    @Query(value = "SELECT * FROM posts " +
            "WHERE user_id = :id",nativeQuery = true)
    Optional<List<Post>> findAllPosts(Long id);
}
