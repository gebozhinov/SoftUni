package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.Route;
import bg.softuni.Pathfinder.repository.RouteRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService {


    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getMostCommented() {

        return routeRepository.getMostCommented();
    }
}
