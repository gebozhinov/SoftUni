package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entity.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findFirstByUsername(String username);


    // If this query don't work change the sql mode in MySQL by this command ->
    // SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
    @Query("SELECT DISTINCT u FROM User u " +
            "JOIN u.posts p " +
            "ORDER BY p.size desc, u.id ")
    Optional<List<User>> usersWithPosts();

}
