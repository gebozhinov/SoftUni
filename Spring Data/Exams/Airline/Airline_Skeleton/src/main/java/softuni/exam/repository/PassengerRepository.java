package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Passenger;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Optional<Passenger> findFirstByEmail(String email);

    @Query("SELECT DISTINCT p FROM Passenger p " +
            "JOIN p.tickets t " +
            "ORDER BY t.size desc, p.email")
    Optional<List<Passenger>> getPassengersOrderByTicketsCountDescendingThenByEmail();
    
}
