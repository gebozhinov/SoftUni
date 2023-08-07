package bg.softuni.Pathfinder.repository;

import bg.softuni.Pathfinder.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query(value = "SELECT r.*, count(r.id) FROM routes r " +
            "JOIN comments c ON r.id = c.route_id " +
            "GROUP BY r.id " +
            "ORDER BY count(r.id) DESC " +
            "LIMIT 1 ", nativeQuery = true)
    Route getMostCommented();
}
