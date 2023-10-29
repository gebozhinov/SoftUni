package bg.softuni.Pathfinder.model.dto;

public class CommentDTO {
    private String text;

    public String getText() {
        return text;
    }

    public CommentDTO setText(String text) {
        this.text = text;
        return this;
    }
}
