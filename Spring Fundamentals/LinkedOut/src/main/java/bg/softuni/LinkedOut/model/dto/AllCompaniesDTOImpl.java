package bg.softuni.LinkedOut.model.dto;

public class AllCompaniesDTOImpl {

    private String name;
    private String town;
    private String description;


    public String getName() {
        return name;
    }

    public AllCompaniesDTOImpl setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public AllCompaniesDTOImpl setTown(String town) {
        this.town = town;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AllCompaniesDTOImpl setDescription(String description) {
        this.description = description;
        return this;
    }
}
