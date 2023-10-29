package bg.softuni.Pathfinder.repository;

import bg.softuni.Pathfinder.model.Comments;
import bg.softuni.Pathfinder.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {

    List<Comments> findAllByRoute(Route route);

}
