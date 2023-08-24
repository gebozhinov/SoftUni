package bg.softuni.Spotify.repository;

import bg.softuni.Spotify.model.dto.song.SongDTO;
import bg.softuni.Spotify.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {


    @Query(value = "SELECT sum(duration) FROM songs s " +
            "JOIN users_songs us ON s.id = us.song_id " +
            "WHERE us.user_id = :id",nativeQuery = true)
    Integer totalDurationOfPlaylist(long id);

    @Query(value = "SELECT s.performer, s.title, s.duration, s.id FROM songs s " +
            "JOIN users_songs us ON s.id = us.song_id " +
            "WHERE us.user_id = :id", nativeQuery = true)
    Optional<List<SongDTO>> findAllByLoggedUser(long id);

    @Query(value = "SELECT s.performer, s.title, s.duration, st.style_name as style, s.id FROM songs s " +
            "JOIN styles st ON s.style_id = st.id " +
            "WHERE st.style_name = 0",nativeQuery = true)
    Optional<List<SongDTO>> findAllPopSongs();

    @Query(value = "SELECT s.performer, s.title, s.duration, st.style_name as style, s.id FROM songs s " +
            "JOIN styles st ON s.style_id = st.id " +
            "WHERE st.style_name = 1",nativeQuery = true)
    Optional<List<SongDTO>> findAllRockSongs();

    @Query(value = "SELECT s.performer, s.title, s.duration, st.style_name as style, s.id FROM songs s " +
            "JOIN styles st ON s.style_id = st.id " +
            "WHERE st.style_name = 2",nativeQuery = true)
    Optional<List<SongDTO>> findAllJazzSongs();

}
