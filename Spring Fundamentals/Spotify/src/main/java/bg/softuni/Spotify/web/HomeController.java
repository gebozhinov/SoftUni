package bg.softuni.Spotify.web;

import bg.softuni.Spotify.service.UserService;
import bg.softuni.Spotify.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        if (userService.isUserLogged()) {
            return "/home";
        }
        return "/index";
    }

    @GetMapping("/home")
    public String home() {
        if (userService.isUserLogged()) {
            return "/home";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        if (userService.isUserLogged()) {
            this.userService.logout();
            return "redirect:/";
        }
        return "/index";
    }
}
