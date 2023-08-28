package bg.softuni.ShoppingList.web;

import bg.softuni.ShoppingList.service.UserService;
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
        if (this.userService.isLogged()) {
            return "/home";
        }
        return "/index";
    }

    @GetMapping("/home")
    public String home() {
        if (this.userService.isLogged()) {
            return "/index";
        }
        return "/home";
    }
}
