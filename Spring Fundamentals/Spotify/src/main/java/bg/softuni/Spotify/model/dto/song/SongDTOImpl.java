package bg.softuni.Spotify.model.dto.song;

public class SongDTOImpl implements SongDTO {

    private String performer;
    private String title;
    private Integer duration;
    private Long id;

    @Override
    public String getPerformer() {
        return this.performer;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public Integer getDuration() {
        return this.duration;
    }

    @Override
    public Long getId() {
        return id;
    }


    public SongDTOImpl setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public SongDTOImpl setTitle(String title) {
        this.title = title;
        return this;
    }

    public SongDTOImpl setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public SongDTOImpl setId(Long id) {
        this.id = id;
        return this;
    }
}
