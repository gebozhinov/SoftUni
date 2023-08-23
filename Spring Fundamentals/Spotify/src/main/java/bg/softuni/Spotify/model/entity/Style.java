package bg.softuni.Spotify.model.entity;

import bg.softuni.Spotify.model.enums.StyleName;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "style_name", unique = true, nullable = false)
    private StyleName styleName;
    @Column(columnDefinition = "text")
    private String description;
    @OneToMany(targetEntity = Song.class, mappedBy = "style")
    private Set<Song> songs;

    public Long getId() {
        return id;
    }

    public StyleName getStyleName() {
        return styleName;
    }

    public Style setStyleName(StyleName styleName) {
        this.styleName = styleName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Style setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public Style setSongs(Set<Song> songs) {
        this.songs = songs;
        return this;
    }
}
