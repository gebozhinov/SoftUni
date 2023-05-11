package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findFirstByEmail(String email);

    @Query("SELECT p FROM Player p " +
            "WHERE p.birthdate >= :min AND p.birthdate <= :max " +
            "ORDER BY p.stat.shooting desc , p.stat.passing desc, " +
            "p.stat.endurance desc, p.lastName")
    Optional<List<Player>> findBestPlayers(LocalDate min, LocalDate max);

}
