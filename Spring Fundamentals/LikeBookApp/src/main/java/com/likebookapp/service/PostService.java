package com.likebookapp.service;

import com.likebookapp.model.dto.AddPostDTO;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.util.mapper.PostMapper;
import com.likebookapp.util.session.SessionUser;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final MoodRepository moodRepository;
    private final PostMapper postMapper;
    private final SessionUser sessionUser;

    public PostService(PostRepository postRepository,
                       UserRepository userRepository,
                       MoodRepository moodRepository,
                       PostMapper postMapper,
                       SessionUser sessionUser) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.moodRepository = moodRepository;
        this.postMapper = postMapper;
        this.sessionUser = sessionUser;
    }

    public void addPost(AddPostDTO addPostDTO) {

        User user = this.userRepository.findById(sessionUser.getId()).get();
        Mood mood = this.moodRepository.findByMoodName(addPostDTO.getMoodName().toString()).get();

        Post post = this.postMapper.addPostDTOToPost(addPostDTO)
                .setUser(user)
                .setMood(mood);

        this.postRepository.saveAndFlush(post);

    }

    public List<Post> getAllOtherPosts() {

        return this.postRepository.findAllOtherPosts(sessionUser.getId()).orElse(null);
    }

    public List<Post> getAllPosts() {

        return this.postRepository.findAllPosts(sessionUser.getId()).orElse(null);
    }

    public void likePost(Long id) {
        Post post = this.postRepository.findById(id).get();
        User user = this.userRepository.findById(this.sessionUser.getId()).get();
        post.getUserLikes().add(user);
        user.getLikedPosts().add(post);

        this.postRepository.save(post);
        this.userRepository.save(user);
    }
}
