package com.example.usersystem.services;

import com.example.usersystem.models.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    List<User> findAllByEmailEndsWith(String endWith);

    int deactivateUsers(LocalDate date);

    void deleteUsers();

    void addUsers();
}
