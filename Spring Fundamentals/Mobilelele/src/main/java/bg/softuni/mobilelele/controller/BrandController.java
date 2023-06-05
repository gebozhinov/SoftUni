package bg.softuni.mobilelele.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/brands")
public class BrandController extends BaseController {

    @GetMapping("/all")
    public ModelAndView viewAllModels() {
     return super.view("brands");
    }
}
