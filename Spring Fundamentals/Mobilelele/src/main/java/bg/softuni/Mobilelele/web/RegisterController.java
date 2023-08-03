package bg.softuni.Mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users/register")
public class RegisterController extends BaseController {

    @GetMapping
    public ModelAndView register() {
        return super.view("auth-register");
    }
}
