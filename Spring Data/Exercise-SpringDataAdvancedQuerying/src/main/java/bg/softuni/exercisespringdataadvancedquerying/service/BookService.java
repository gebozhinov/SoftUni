package bg.softuni.exercisespringdataadvancedquerying.service;

import bg.softuni.exercisespringdataadvancedquerying.model.dto.BookInformation;
import bg.softuni.exercisespringdataadvancedquerying.model.dto.TotalBookCopies;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.AgeRestriction;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.Book;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> findAllByAgeRestrictionEquals(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceIsLessThanOrPriceIsGreaterThan(BigDecimal less, BigDecimal greater);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate localDate1, LocalDate localDate2);

    List<Book> findAllBooksByReleaseDateBefore(LocalDate localDate);

    List<Book> findAllByTitleContaining(String contains);

    List<Book> findAllByAuthorLastNameStartingWith(String start);

    Integer getCountOfBooksWithTitleLongerThan(Integer number);

    List<TotalBookCopies> getTotalBookCopies();

    List<BookInformation> getBookInformation(String title);

    Integer increaseBookCopies(LocalDate date, int addCopies);

    void deleteByCopiesIsLessThan(Integer copies);

    int totalAmountOfBooksByAuthor(String name);


}
