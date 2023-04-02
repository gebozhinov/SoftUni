package bg.softuni.exercisespringdataautomappingobjects.repository;

import bg.softuni.exercisespringdataautomappingobjects.model.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findById(long id);
}
