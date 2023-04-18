package bg.softuni.cardealer.repository;

import bg.softuni.cardealer.model.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c " +
            "ORDER BY rand() LIMIT 1")
    Optional<Car> getRandomCar();

    Optional<List<Car>> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
