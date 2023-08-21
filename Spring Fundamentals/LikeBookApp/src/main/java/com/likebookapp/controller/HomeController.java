package com.likebookapp.controller;

import com.likebookapp.util.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final SessionUser sessionUser;

    public HomeController(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }

    @GetMapping("/")
    public String index() {
        if (sessionUser.isLogged()) {
            return "/home";
        }
        return "/index";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }
}
