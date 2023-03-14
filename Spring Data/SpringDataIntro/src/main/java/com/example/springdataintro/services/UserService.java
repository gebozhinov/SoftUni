package com.example.springdataintro.services;


import com.example.springdataintro.models.User;

public interface UserService {

    void register(String username, int age);

    User findByUsername(String username);
}
