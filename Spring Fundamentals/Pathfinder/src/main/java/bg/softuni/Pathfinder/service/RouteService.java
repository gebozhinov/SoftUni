package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.Route;
import bg.softuni.Pathfinder.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {


    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getMostCommented() {

        return routeRepository.getMostCommented();
    }

    public List<Route> getAllRoutes() {
        return this.routeRepository.findAll();
    }

    public Route getRouteDetails(Long id) {
        return this.routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This route does not exist!"));
    }
}
