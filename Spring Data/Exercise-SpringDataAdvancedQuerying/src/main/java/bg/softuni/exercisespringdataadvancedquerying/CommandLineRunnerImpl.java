package bg.softuni.exercisespringdataadvancedquerying;

import bg.softuni.exercisespringdataadvancedquerying.model.dto.TotalNumberOfBookCopies;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.AgeRestriction;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.Book;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.EditionType;
import bg.softuni.exercisespringdataadvancedquerying.service.AuthorService;
import bg.softuni.exercisespringdataadvancedquerying.service.BookService;
import bg.softuni.exercisespringdataadvancedquerying.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

//        printAllBookTitlesByAgeRestriction(new Scanner(System.in));
//        printTitlesOfGoldenEditionBooksWithLessThan5000Copies();
//        printTitleAndPriceOfBookWithPriceLowerOrHigherThan();
//        printTitleOfBooksThatAreNotReleasedInGivenYear(new Scanner(System.in));
//        printBooksReleasedBeforeDate(new Scanner(System.in));
//        printAuthorNames(new Scanner(System.in));
//        printTitleOfBooksWhichContainsGivenString(new Scanner(System.in));
//        printBookTitleByAuthorsLastNameStartsWith(new Scanner(System.in));
//        printCountOfBooksWithTitleLongerThan(new Scanner(System.in));
        printTotalBookCopies();

    }
    private void printTotalBookCopies() {
        this.bookService.getTotalBookCopies()
                .forEach(book -> System.out.println(book.getAuthor().getFirstName() + " " + book.getCopies()));
    }
    private void printCountOfBooksWithTitleLongerThan(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(this.bookService.getCountOfBooksWithTitleLongerThan(number));
    }
    private void printBookTitleByAuthorsLastNameStartsWith(Scanner scanner) {
        String start = scanner.nextLine();
        this.bookService.findAllByAuthorLastNameStartingWith(start)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }
    private void printTitleOfBooksWhichContainsGivenString(Scanner scanner) {
        String contains = scanner.nextLine();
        this.bookService.findAllByTitleContaining(contains)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);

    }
    private void printAuthorNames(Scanner scanner) {
        String end = scanner.nextLine();
        this.authorService.findAllByFirstNameEndsWith(end)
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
    }
    private void printBooksReleasedBeforeDate(Scanner scanner) {
        String[] date = scanner.nextLine().split("-");
        int year = Integer.parseInt(date[2]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[0]);
        this.bookService.findAllBooksByReleaseDateBefore(LocalDate.of(year, month, day))
                .forEach(book -> System.out.printf("%s %s %.2f%n", book.getTitle(), book.getEditionType(), book.getPrice()));
    }
    private void printTitleOfBooksThatAreNotReleasedInGivenYear(Scanner scanner) {
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate localDate1 = LocalDate.of(year, 1, 1);
        LocalDate localDate2 = LocalDate.of(year, 12, 31);
        this.bookService.findAllByReleaseDateBeforeOrReleaseDateAfter(localDate1, localDate2)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }
    private void printTitleAndPriceOfBookWithPriceLowerOrHigherThan() {
        this.bookService.
                findAllByPriceIsLessThanOrPriceIsGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(book -> System.out.printf("%s - $%.2f%n", book.getTitle(), book.getPrice()));

    }

    private void printTitlesOfGoldenEditionBooksWithLessThan5000Copies() {
        this.bookService.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void printAllBookTitlesByAgeRestriction(Scanner scanner) {
        String ageRestriction = scanner.nextLine();
        AgeRestriction ageRestriction1 = AgeRestriction.valueOf(ageRestriction.toUpperCase());
        bookService.findAllByAgeRestrictionEquals(ageRestriction1)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
