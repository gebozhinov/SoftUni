package com.likebookapp.model.entity;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(targetEntity = Post.class, mappedBy = "user")
    private Set<Post> posts;

    @ManyToMany
    @JoinTable(name = "users_likes",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> likedPosts;
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public User setPosts(Set<Post> posts) {
        this.posts = posts;
        return this;
    }

    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public User setLikedPosts(Set<Post> likedPosts) {
        this.likedPosts = likedPosts;
        return this;
    }
}
