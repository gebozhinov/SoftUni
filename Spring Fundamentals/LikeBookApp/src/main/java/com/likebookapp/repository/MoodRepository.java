package com.likebookapp.repository;

import com.likebookapp.model.entity.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {


    @Query(value = "SELECT * FROM moods " +
            "WHERE mood_name = :moodName",nativeQuery = true)
    Optional<Mood> findByMoodName(String moodName);
}
