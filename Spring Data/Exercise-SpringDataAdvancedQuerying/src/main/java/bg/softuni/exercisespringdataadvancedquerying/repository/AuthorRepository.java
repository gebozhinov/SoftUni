package bg.softuni.exercisespringdataadvancedquerying.repository;

import bg.softuni.exercisespringdataadvancedquerying.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();

    Optional<List<Author>> findAllByFirstNameEndsWith(String end);
}
