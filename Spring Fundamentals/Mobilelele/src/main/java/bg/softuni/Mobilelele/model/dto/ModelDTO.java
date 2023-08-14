package bg.softuni.Mobilelele.model.dto;

public class ModelDTO {

    private Long modelId;
    private String name;

    public Long getId() {
        return modelId;
    }

    public ModelDTO setId(Long brandId) {
        this.modelId = brandId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelDTO setName(String name) {
        this.name = name;
        return this;
    }
}
