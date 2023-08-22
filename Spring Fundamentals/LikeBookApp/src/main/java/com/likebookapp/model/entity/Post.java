package com.likebookapp.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "likedPosts", fetch = FetchType.EAGER)
    private Set<User> userLikes;

    @ManyToOne
    private Mood mood;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    public Set<User> getUserLikes() {
        return userLikes;
    }

    public Post setUserLikes(Set<User> userLikes) {
        this.userLikes = userLikes;
        return this;
    }

    public Mood getMood() {
        return mood;
    }

    public Post setMood(Mood mood) {
        this.mood = mood;
        return this;
    }
}
