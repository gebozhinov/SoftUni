package bg.softuni.Pathfinder.web;

import bg.softuni.Pathfinder.model.Picture;
import bg.softuni.Pathfinder.model.Route;
import bg.softuni.Pathfinder.model.view.RouteIndexView;
import bg.softuni.Pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String getAllRoutes(Model model) {
        List<RouteIndexView> routes = this.routeService.getAllRoutes()
                .stream().map(r -> new RouteIndexView(
                        r.getId(),
                        r.getName(),
                        findFirstImageUrl(r.getPictures()),
                        r.getDescription()
                )).toList();

        model.addAttribute("routes", routes);

       return "routes";
    }

    public String findFirstImageUrl(Set<Picture> pictures) {
     return  pictures.stream().findFirst().map(Picture::getUrl).orElse("N/A");
    }
}
