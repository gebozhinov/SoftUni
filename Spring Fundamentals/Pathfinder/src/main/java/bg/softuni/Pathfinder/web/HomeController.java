package bg.softuni.Pathfinder.web;

import bg.softuni.Pathfinder.model.Route;
import bg.softuni.Pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String home(Model model) {

        Route route = routeService.getMostCommented();

        model.addAttribute("mostCommented", route);

        return "index";
    }

}
