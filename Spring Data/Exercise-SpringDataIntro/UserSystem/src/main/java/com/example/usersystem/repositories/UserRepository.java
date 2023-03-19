package com.example.usersystem.repositories;

import com.example.usersystem.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> findAllByEmailEndingWith(String endWith);

    Optional<List<User>> findAllByLastTimeLoginInAfter(LocalDate date);
    @Transactional
    void deleteUserByDeletedTrue();

}
