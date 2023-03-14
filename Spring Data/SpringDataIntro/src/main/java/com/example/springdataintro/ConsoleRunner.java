package com.example.springdataintro;

import com.example.springdataintro.models.User;
import com.example.springdataintro.services.AccountService;
import com.example.springdataintro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.register("first", 22);
        User user = this.userService.findByUsername("first");
        this.accountService.depositMoney(BigDecimal.TEN, user.getId());
        this.accountService.withdrawMoney(BigDecimal.ONE, user.getId());
    }
}
