package bg.softuni.Pathfinder.model.view;

import java.util.List;

public class RouteDetailsView {

    private Long id;
    private String name;
    private String description;
    private String authorName;
    private String level;
    private List<String> pictureUrl;
    private String videoUrl;

    public RouteDetailsView(Long id, String name,
                            String description,
                            String authorName,
                            String level,
                            List<String> pictureUrl,
                            String videoUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.authorName = authorName;
        this.level = level;
        this.pictureUrl = pictureUrl;
        this.videoUrl = videoUrl;
    }

    public RouteDetailsView() {
    }

    public Long getId() {
        return id;
    }

    public RouteDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteDetailsView setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public RouteDetailsView setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public RouteDetailsView setLevel(String level) {
        this.level = level;
        return this;
    }

    public List<String> getPictureUrl() {
        return pictureUrl;
    }

    public RouteDetailsView setPictureUrl(List<String> pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteDetailsView setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
