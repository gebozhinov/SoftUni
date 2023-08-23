package bg.softuni.Spotify.model.mapper;

import bg.softuni.Spotify.model.dto.AddSongDTO;
import bg.softuni.Spotify.model.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongMapper {



    @Mapping(target = "style", ignore = true)
    Song addSongDTOToSong(AddSongDTO addSongDTO);
}
