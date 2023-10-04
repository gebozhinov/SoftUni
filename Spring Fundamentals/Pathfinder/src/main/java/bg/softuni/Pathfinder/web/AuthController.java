package bg.softuni.Pathfinder.web;

import bg.softuni.Pathfinder.model.User;
import bg.softuni.Pathfinder.model.dto.UserRegistrationDTO;
import bg.softuni.Pathfinder.model.view.UserProfileView;
import bg.softuni.Pathfinder.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @ModelAttribute
    public UserRegistrationDTO initModel() {
        return new UserRegistrationDTO();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/register")
    public String register() {

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO userRegistrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);

            return "redirect:/register";
        }

        authService.register(userRegistrationDTO);

        return "redirect:/";
    }

    @GetMapping("profile")
    public String profile(Principal principal, Model model) {

        User user = this.authService.findUserByUsername(principal.getName());
        UserProfileView profileView = new UserProfileView(
                user.getFullName(),
                user.getUsername(),
                user.getAge(),
                user.getLevel() == null ? "NONE" : user.getLevel().name()
        );

        model.addAttribute("user", profileView);

        return "profile";
    }
}
