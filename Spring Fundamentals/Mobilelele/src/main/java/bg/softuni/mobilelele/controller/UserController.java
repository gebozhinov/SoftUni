package bg.softuni.mobilelele.controller;

import bg.softuni.mobilelele.domain.dto.UserLoginDTO;
import bg.softuni.mobilelele.domain.dto.UserRegisterDTO;
import bg.softuni.mobilelele.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView viewLogin() {

        return super.view("auth-login");
    }

    @GetMapping("/register")
    public ModelAndView viewRegister() {
        return super.view("auth-register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterDTO userRegisterDTO) {



        this.userService.registerUser(userRegisterDTO);

        return super.redirect("users/login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginDTO userLoginDTO, HttpSession session) {

        this.userService.loginUser(userLoginDTO);

        session.setAttribute("user", userLoginDTO.getUsername());

        return super.redirect("");
    }

    @GetMapping("/logout")
    public ModelAndView logout() {

        this.userService.logout();

       return super.redirect("");
    }

}
