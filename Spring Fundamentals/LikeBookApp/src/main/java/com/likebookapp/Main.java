package com.likebookapp;

import com.likebookapp.model.entity.Post;
import com.likebookapp.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final PostRepository postRepository;

    public Main(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Post post = postRepository.findById(1L).get();
        System.out.println();
    }
}
