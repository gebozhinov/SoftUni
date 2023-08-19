package bg.softuni.Battleships.web;

import bg.softuni.Battleships.model.dto.LoginUserDTO;
import bg.softuni.Battleships.model.dto.RegisterUserDTO;
import bg.softuni.Battleships.service.UserService;
import bg.softuni.Battleships.user.SessionUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {


    private final UserService userService;

    private final SessionUser sessionUser;

    public UserController(UserService userService,
                          SessionUser sessionUser) {
        this.userService = userService;
        this.sessionUser = sessionUser;
    }


    @ModelAttribute("registerUser")
    public RegisterUserDTO registerUserDTO() {
        return new RegisterUserDTO();
    }

    @ModelAttribute("loginUser")
    public LoginUserDTO loginUserDTO() {
        return new LoginUserDTO();
    }

    @GetMapping("/login")
    public String login() {
        if (sessionUser.isLogged()) {
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginUserDTO loginUserDTO, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (sessionUser.isLogged()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginUser", loginUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginUser",
                    bindingResult);
            return "redirect:/login";
        }


        boolean isLogged = this.userService.login(loginUserDTO);

        if (!isLogged) {
            bindingResult.addError(new ObjectError("Error", "Enter valid username or password"));
            redirectAttributes.addFlashAttribute("loginUser", true);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginUser",
                    bindingResult);
            return "redirect:/login";
        } else {
            return "redirect:/home";
        }

    }

    @GetMapping("/register")
    public String register() {

        if (sessionUser.isLogged()) {
            return "redirect:/home";
        }

        return "register";
    }
    @PostMapping("/register")
    public String register(@Valid RegisterUserDTO registerUserDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (sessionUser.isLogged()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("registerUser", registerUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUser",
                    bindingResult);

            return "redirect:/register";
        }

        this.userService.registerAndLogin(registerUserDTO);

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        this.userService.logout();
        return "redirect:/";
    }
}
