package bg.softuni.exercisespringdataadvancedquerying.repository;

import bg.softuni.exercisespringdataadvancedquerying.model.dto.TotalNumberOfBookCopies;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.AgeRestriction;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.Book;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    Optional<List<Book>> findAllByAgeRestrictionEquals(AgeRestriction ageRestriction);

    Optional<List<Book>> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    Optional<List<Book>> findAllByPriceIsLessThanOrPriceIsGreaterThan(BigDecimal less, BigDecimal greater);

    Optional<List<Book>> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate localDate1, LocalDate localDate2);

    Optional<List<Book>> findAllBooksByReleaseDateBefore(LocalDate localDate);

    Optional<List<Book>> findAllByTitleContaining(String contains);

    Optional<List<Book>> findAllByAuthorLastNameStartingWith(String start);

    @Query("SELECT COUNT(b) FROM Book b " +
            "WHERE length(b.title) > :number")
    Optional<Integer> getCountOfBooksWithTitleLongerThan(Integer number);

    @Query("SELECT b.author, sum(b.copies) as co FROM Book b " +
            "GROUP BY b.author " +
            "ORDER BY co desc ")
    Optional<List<Book>> getTotalBookCopies();


}
