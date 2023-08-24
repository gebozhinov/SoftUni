package bg.softuni.Spotify.web;

import bg.softuni.Spotify.model.dto.LoginUserDTO;
import bg.softuni.Spotify.model.dto.RegisterUserDTO;
import bg.softuni.Spotify.service.UserService;
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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerUser")
    public RegisterUserDTO registerUserDTO() {
        return new RegisterUserDTO();
    }
    @ModelAttribute("loginUser")
    public LoginUserDTO loginUserDTO() {
        return new LoginUserDTO();
    }

    @GetMapping("/register")
    public String register() {
        if (this.userService.isUserLogged()) {
            return "redirect:/";
        }
        return "/register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterUserDTO registerUserDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (this.userService.isUserLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("registerUser", registerUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUser",
                    bindingResult);
            return "redirect:/register";
        }

        this.userService.register(registerUserDTO);

        return "/home";
    }

    @GetMapping("/login")
    public String login() {
        if (this.userService.isUserLogged()) {
            return "redirect:/";
        }
        return "/login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginUserDTO loginUserDTO, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (this.userService.isUserLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginUser", loginUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginUser",
                    bindingResult);
            return "redirect:/login";
        }

        if (this.userService.login(loginUserDTO)) {

            return "redirect:/home";
        }

        bindingResult.addError(new ObjectError("loginUser", "Incorrect username or password."));
        redirectAttributes.addFlashAttribute("loginUser", loginUserDTO);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginUser",
                bindingResult);
        return "redirect:/login";

    }
}
