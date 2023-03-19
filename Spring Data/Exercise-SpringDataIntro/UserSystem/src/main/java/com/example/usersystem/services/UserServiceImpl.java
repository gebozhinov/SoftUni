package com.example.usersystem.services;

import com.example.usersystem.models.User;
import com.example.usersystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllByEmailEndsWith(String endWith) {
        return userRepository.findAllByEmailEndingWith(endWith).orElseThrow(NoSuchElementException::new);

    }

    @Override
    public int deactivateUsers(LocalDate date) {
        List<User> users = this.userRepository.findAllByLastTimeLoginInAfter(date).orElseThrow(NoSuchElementException::new);
        users.forEach(user -> user.setDeleted(true));
        return users.size();
    }

    @Override
    public void deleteUsers() {
       userRepository.deleteUserByDeletedTrue();

    }

    @Override
    public void addUsers() {
        for (int i = 1; i <= 1000; i++) {
            this.userRepository.save(User.builder()
                    .username("username" + i)
                    .password("pasSword%" + i)
                    .email("mail" + i + "x@abv.bg")
                    .age(i % 120 + 1)
                    .firstName("First" + i)
                    .lastName("Last" + i)
                    .registeredOn(LocalDate.of(2005, 1, 1))
                    .lastTimeLoginIn(LocalDate.of(2009, 1 , 1))
                    .deleted(false)
                    .build());
        }
    }


}
