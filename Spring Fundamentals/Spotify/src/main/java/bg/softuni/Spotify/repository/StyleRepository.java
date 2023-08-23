package bg.softuni.Spotify.repository;

import bg.softuni.Spotify.model.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {


    @Query(value = "SELECT * FROM styles " +
            "WHERE style_name = :style",nativeQuery = true)
    Optional<Style> findByStyleName(int style);

}
