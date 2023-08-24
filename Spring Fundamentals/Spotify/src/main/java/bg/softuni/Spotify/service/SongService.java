package bg.softuni.Spotify.service;

import bg.softuni.Spotify.model.dto.AddSongDTO;
import bg.softuni.Spotify.model.dto.song.SongDTOImpl;
import bg.softuni.Spotify.model.dto.song.SongDTO;
import bg.softuni.Spotify.model.entity.Song;
import bg.softuni.Spotify.model.entity.Style;
import bg.softuni.Spotify.model.entity.User;
import bg.softuni.Spotify.model.mapper.SongMapper;
import bg.softuni.Spotify.repository.SongRepository;
import bg.softuni.Spotify.repository.StyleRepository;
import bg.softuni.Spotify.repository.UserRepository;
import bg.softuni.Spotify.user.SessionUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    public int totalDurationOfPlaylist() {
        return this.songRepository.totalDurationOfPlaylist(this.sessionUser.getId());
    }

    public List<SongDTOImpl> findAllByLoggedUser() {
        List<SongDTO> songsDTOS = this.songRepository.findAllByLoggedUser(
                this.sessionUser.getId()
        ).orElse(new ArrayList<>());

        return getSongDTOS(songsDTOS);
    }

    public List<SongDTOImpl> findAllPopSongs() {
        List<SongDTO> allSongs = this.songRepository.findAllPopSongs().orElse(new ArrayList<>());

        return getSongDTOS(allSongs);
    }
    public List<SongDTOImpl> findAllRockSongs() {
        List<SongDTO> allSongs = this.songRepository.findAllRockSongs().orElse(new ArrayList<>());

        return getSongDTOS(allSongs);
    }

    public List<SongDTOImpl> findAllJazzSongs() {
        List<SongDTO> allSongs = this.songRepository.findAllJazzSongs().orElse(new ArrayList<>());

        return getSongDTOS(allSongs);
    }

    private List<SongDTOImpl> getSongDTOS(List<SongDTO> allSongs) {
        List<SongDTOImpl> songs = new ArrayList<>();

        for (SongDTO song : allSongs) {
            String performer = song.getPerformer();
            String title = song.getTitle();
            Integer duration = song.getDuration();

            SongDTOImpl popSongDTO = new SongDTOImpl();
            popSongDTO.setPerformer(performer);
            popSongDTO.setTitle(title);
            popSongDTO.setDuration(duration);

            songs.add(popSongDTO);
        }
        return songs;
    }

}
