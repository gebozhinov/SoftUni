package bg.softuni.nextleveltechnologies.controllers;

import bg.softuni.nextleveltechnologies.model.dtos.LoginDTO;
import bg.softuni.nextleveltechnologies.model.enitities.User;
import bg.softuni.nextleveltechnologies.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("users/login")
    public String doLogin(LoginDTO loginDTO) {

        Optional<User> login = this.userService.login(loginDTO);

        if (login.isPresent()) {
            return "redirect:/home";
        }

        return "user/login";
    }

    @GetMapping("users/register")
    public String register() {
        return "user/register";
    }

}
