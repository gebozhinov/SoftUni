package bg.softuni.Pathfinder.web;

import bg.softuni.Pathfinder.model.Picture;
import bg.softuni.Pathfinder.model.Route;
import bg.softuni.Pathfinder.model.dto.RouteCreationDTO;
import bg.softuni.Pathfinder.model.enums.UserLevel;
import bg.softuni.Pathfinder.model.view.RouteDetailsView;
import bg.softuni.Pathfinder.model.view.RouteIndexView;
import bg.softuni.Pathfinder.service.AuthService;
import bg.softuni.Pathfinder.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final AuthService authService;
    public RouteController(RouteService routeService, AuthService authService) {
        this.routeService = routeService;
        this.authService = authService;
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

    @GetMapping("{id}")
    public String getRouteDetails(@PathVariable("id") Long id, Model model) {
        Route route = this.routeService.getRouteDetails(id);
        RouteDetailsView routeDetailsView = new RouteDetailsView(
                route.getId(),
                route.getName(),
                route.getDescription(),
                route.getAuthor().getUsername(),
                route.getLevel().name(),
                route.getPictures().stream().map(Picture::getUrl).collect(Collectors.toList()),
                route.getVideoUrl()
        );


        model.addAttribute("route", routeDetailsView);
        return "route-details";
    }

    @GetMapping("/new")
    public String addRoute() {

        return "add-route";
    }

    @PostMapping("/new")
    public String addRoute(Principal principal, @Valid RouteCreationDTO routeCreationDTO) {

        Route route = new Route();
        route.setAuthor(this.authService.findUserByUsername(principal.getName()));
        route.setName(routeCreationDTO.getName());
        route.setDescription(routeCreationDTO.getDescription());
        route.setVideoUrl(routeCreationDTO.getVideoUrl());
        route.setLevel(getLevel(routeCreationDTO.getLevel()));

        routeService.createRoute(route, routeCreationDTO.getImage());
        return "redirect:/routes/" + route.getId();

    }
    public String findFirstImageUrl(Set<Picture> pictures) {
     return  pictures.stream().findFirst().map(Picture::getUrl).orElse("N/A");
    }

    private UserLevel getLevel(String key) {
        if (key == null) {
            return UserLevel.BEGINNER;
        }

        return UserLevel.levelMap.get(key);
    }
}
