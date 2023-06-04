package bg.softuni.mobilelele.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {

    @GetMapping
    public ModelAndView view() {

        return super.view("index");
    }
}
