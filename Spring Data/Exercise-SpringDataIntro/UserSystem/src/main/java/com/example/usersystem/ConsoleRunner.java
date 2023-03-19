package com.example.usersystem;

import com.example.usersystem.models.User;
import com.example.usersystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email provider: ");
        String emailProvider = scanner.nextLine();
        List<User> users = userService.findAllByEmailEndsWith(emailProvider);
        if (users.isEmpty()) {
            System.out.println("No users found with email domain " + emailProvider);
        } else {
            users.forEach(user -> System.out.println(user.getUsername() + " " + user.getEmail()));
        }

        int deactivateUsers = userService.deactivateUsers(LocalDate.of(2010, 1, 1));
        System.out.println("Deactivated users: " + deactivateUsers);

        userService.addUsers();

//        userService.deleteUsers();
    }
}
