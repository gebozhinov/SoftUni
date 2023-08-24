package bg.softuni.Spotify.web;

import bg.softuni.Spotify.user.SessionUser;
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
        return "/index";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/logout")
    public String logout() {
        this.sessionUser.clear();
        return "/index";
    }
}
