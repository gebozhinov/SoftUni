package bg.softuni.Spotify.model.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddSongDTO {

    @NotBlank(message = "Performer should not be blank.")
    @Size(min = 3, max = 20, message = "Performer should be between 3 and 20 characters.")
    private String performer;
    @NotBlank(message = "Title should not be blank.")
    @Size(min = 3, max = 20, message = "Title should be between 3 and 20 characters.")
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Release date should not be in future.")
    private LocalDate releaseDate;
    @NotNull(message = "Duration should not be null.")
    @Positive(message = "Duration should be positive number (zero is consider invalid).")
    private Integer duration;
    @Min(value = 0, message = "Select style.")
    private int style = -1;

    public String getPerformer() {
        return performer;
    }

    public AddSongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AddSongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AddSongDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public AddSongDTO setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public int getStyle() {
        return style;
    }

    public AddSongDTO setStyle(int style) {
        this.style = style;
        return this;
    }
}
