package bg.softuni.Pathfinder.model.view;

public class RouteIndexView {
    private Long id;
    private String name;
    private String imageUrl;
    private String description;

    public RouteIndexView(){}

    public RouteIndexView(Long id, String name, String imageUrl, String description) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public RouteIndexView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteIndexView setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RouteIndexView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteIndexView setDescription(String description) {
        this.description = description;
        return this;
    }
}
