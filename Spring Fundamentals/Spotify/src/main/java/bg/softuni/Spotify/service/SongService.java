package bg.softuni.Spotify.service;

import bg.softuni.Spotify.model.dto.AddSongDTO;
import bg.softuni.Spotify.model.entity.Song;
import bg.softuni.Spotify.model.entity.Style;
import bg.softuni.Spotify.model.entity.User;
import bg.softuni.Spotify.model.mapper.SongMapper;
import bg.softuni.Spotify.repository.SongRepository;
import bg.softuni.Spotify.repository.StyleRepository;
import bg.softuni.Spotify.repository.UserRepository;
import bg.softuni.Spotify.user.SessionUser;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final StyleRepository styleRepository;
    private final UserRepository userRepository;
    private final SessionUser sessionUser;
    private final SongMapper songMapper;

    public SongService(SongRepository songRepository,
                       StyleRepository styleRepository,
                       UserRepository userRepository,
                       SessionUser sessionUser,
                       SongMapper songMapper) {
        this.songRepository = songRepository;
        this.styleRepository = styleRepository;
        this.userRepository = userRepository;
        this.sessionUser = sessionUser;
        this.songMapper = songMapper;
    }

    public void add(AddSongDTO addSongDTO) {

        Style style = this.styleRepository.findByStyleName(addSongDTO.getStyle()).get();

        Song song = this.songMapper.addSongDTOToSong(addSongDTO)
                .setStyle(style);

        User user = this.userRepository.findById(this.sessionUser.getId()).get();

        user.getPlaylist().add(song);
        if (song.getUsers() == null) {
            song.setUsers(new HashSet<>());
        }
        song.getUsers().add(user);

        this.songRepository.save(song);
        this.userRepository.save(user);

    }
}
