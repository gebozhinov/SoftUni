package bg.softuni.Pathfinder.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class RouteCreationDTO {

    private String name;
    private String description;
    private MultipartFile image;
    private String level;
    private String videoUrl;

    public RouteCreationDTO() {
    }

    public RouteCreationDTO(String name, String description, MultipartFile image, String level, String videoUrl) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.level = level;
        this.videoUrl = videoUrl;
    }

    public String getName() {
        return name;
    }

    public RouteCreationDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteCreationDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getImage() {
        return image;
    }

    public RouteCreationDTO setImage(MultipartFile image) {
        this.image = image;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public RouteCreationDTO setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteCreationDTO setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
