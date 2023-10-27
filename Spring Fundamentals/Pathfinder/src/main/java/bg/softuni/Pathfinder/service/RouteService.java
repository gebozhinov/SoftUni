package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.Picture;
import bg.softuni.Pathfinder.model.Route;
import bg.softuni.Pathfinder.repository.RouteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Service
public class RouteService {


    private final RouteRepository routeRepository;
    private final ImageCloudService imageCloudService;
    public RouteService(RouteRepository routeRepository, ImageCloudService imageCloudService) {
        this.routeRepository = routeRepository;
        this.imageCloudService = imageCloudService;
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

    public Route createRoute(Route route, MultipartFile imageFile) {

        String pictureUrl = this.imageCloudService.saveImage(imageFile);

        Picture picture = new Picture();
        picture.setRoute(route);
        picture.setAuthor(route.getAuthor());
        picture.setTitle(imageFile.getOriginalFilename());
        picture.setUrl(pictureUrl);

        route.setPictures(Collections.singleton(picture));

        this.routeRepository.save(route);

        return route;

    }
}
