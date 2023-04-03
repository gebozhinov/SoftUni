package bg.softuni.exercisespringdataautomappingobjects.repository;

import bg.softuni.exercisespringdataautomappingobjects.model.dto.GameDetailsDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.dto.GameInfoDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findById(long id);

    @Query("SELECT NEW bg.softuni.exercisespringdataautomappingobjects.model.dto.GameInfoDTO(g.title, g.price) " +
            "FROM Game g ")
    Optional<List<GameInfoDTO>> findAllGames();

    @Query("SELECT NEW bg.softuni.exercisespringdataautomappingobjects.model.dto.GameDetailsDTO(" +
            "g.title, g.price, g.description, g.releaseDate) " +
            "FROM Game g " +
            "WHERE g.title = :title")
    Optional<GameDetailsDTO> findGameDetails(String title);

    Optional<Game> findByTitle(String title);

}
