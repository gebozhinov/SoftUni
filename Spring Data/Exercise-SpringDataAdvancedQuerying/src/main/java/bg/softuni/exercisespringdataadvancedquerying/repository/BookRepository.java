package bg.softuni.exercisespringdataadvancedquerying.repository;

import bg.softuni.exercisespringdataadvancedquerying.model.dto.BookInformation;
import bg.softuni.exercisespringdataadvancedquerying.model.dto.TotalBookCopies;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.AgeRestriction;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.Book;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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


    @Query("SELECT new bg.softuni.exercisespringdataadvancedquerying.model.dto.TotalBookCopies " +
            "(concat(b.author.firstName, ' ', b.author.lastName) , b.copies) " +
            "FROM Book b " +
            "ORDER BY b.copies DESC ")
    Optional<List<TotalBookCopies>> getTotalBookCopies();

    @Query("SELECT NEW bg.softuni.exercisespringdataadvancedquerying.model.dto.BookInformation " +
            "(b.title, b.editionType, b.ageRestriction, b.price) " +
            "FROM Book b " +
            "WHERE b.title = :title")
    Optional<List<BookInformation>> getBookInformation(String title);

    @Transactional
    @Modifying
    @Query("UPDATE Book b " +
            "SET b.copies = b.copies + :addCopies " +
            "WHERE b.releaseDate > :date")
    Optional<Integer> increaseBookCopies(LocalDate date, int addCopies);

    @Transactional
    @Modifying
    void deleteByCopiesIsLessThan(Integer copies);


//    DELIMITER $$
//    CREATE PROCEDURE total_amount_of_books_by_author(IN name VARCHAR(50), OUT count_out int)
//    BEGIN
//    SELECT COUNT(b.copies) INTO count_out
//    FROM books b
//    JOIN authors a on a.id = b.author_id
//    WHERE concat(a.first_name, ' ',a.last_name ) = name;
//    END $$

    @Procedure(value = "total_amount_of_books_by_author")
    int totalAmountOfBooksByAuthor(String name);

}
