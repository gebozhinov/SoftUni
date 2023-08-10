package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.model.dto.UserLoginDTO;
import bg.softuni.Mobilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {

        this.userService.login(userLoginDTO);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

}
