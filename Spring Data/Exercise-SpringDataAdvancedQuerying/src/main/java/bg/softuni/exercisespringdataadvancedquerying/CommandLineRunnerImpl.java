package bg.softuni.exercisespringdataadvancedquerying;

import bg.softuni.exercisespringdataadvancedquerying.model.dto.BookInformation;
import bg.softuni.exercisespringdataadvancedquerying.model.dto.TotalBookCopies;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.AgeRestriction;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.Book;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.EditionType;
import bg.softuni.exercisespringdataadvancedquerying.model.entity.Month;
import bg.softuni.exercisespringdataadvancedquerying.service.AuthorService;
import bg.softuni.exercisespringdataadvancedquerying.service.BookService;
import bg.softuni.exercisespringdataadvancedquerying.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

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
//        printTotalBookCopies();
//        printBookInformation(new Scanner(System.in));
//        printIncreasedBookCopies(new Scanner(System.in));
//        deleteBooks(new Scanner(System.in));
        printTotalAmountOfBooksByAuthor(new Scanner(System.in));
    }

    private void printTotalAmountOfBooksByAuthor(Scanner scanner) {
        String name = scanner.nextLine();
        int amountOfBooks = this.bookService.totalAmountOfBooksByAuthor(name);
        System.out.printf("%s has written %d books%n", name, amountOfBooks);
    }
    // 13.	* Remove Books
    private void deleteBooks(Scanner scanner) {
        Integer copies = Integer.parseInt(scanner.nextLine());
        this.bookService.deleteByCopiesIsLessThan(copies);
    }

    // 12.	* Increase Book Copies
    private void printIncreasedBookCopies(Scanner scanner) {
        String[] date = scanner.nextLine().split(" ");
        int copies = Integer.parseInt(scanner.nextLine());

        int year = Integer.parseInt(date[2]);
        int month = Month.valueOf(date[1].toUpperCase()).getValue();
        int day = Integer.parseInt(date[0]);

        Integer increasedCopies = this.bookService.increaseBookCopies(LocalDate.of(year, month, day), copies);
        System.out.println(increasedCopies);
    }
    // 11.	Reduced Book
    private void printBookInformation(Scanner scanner) {
        String title = scanner.nextLine();
        this.bookService.getBookInformation(title)
                .stream().map(BookInformation::toString)
                .forEach(System.out::println);
    }

    // 10.	Total Book Copies
    private void printTotalBookCopies() {
        List<TotalBookCopies> totalBookCopies = this.bookService.getTotalBookCopies();
        Map<String, Integer> copies = new LinkedHashMap<>();
        for (TotalBookCopies totalBookCopy : totalBookCopies) {
            String name = totalBookCopy.getFullName();
            int copy = totalBookCopy.getCopies();
            if (copies.containsKey(name)) {
                int currentCopies = copies.get(name);
                copies.put(name, copy + currentCopies);
            } else {
                copies.put(name, copy);
            }
        }
        Map<String, Integer> sorted = new LinkedHashMap<>();
        copies.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

        sorted.forEach((k, v) -> System.out.println(k + " " + v));
    }

    // 9.	Count Books
    private void printCountOfBooksWithTitleLongerThan(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(this.bookService.getCountOfBooksWithTitleLongerThan(number));
    }

    // 8.	Book Titles Search
    private void printBookTitleByAuthorsLastNameStartsWith(Scanner scanner) {
        String start = scanner.nextLine();
        this.bookService.findAllByAuthorLastNameStartingWith(start)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    // 7.	Books Search
    private void printTitleOfBooksWhichContainsGivenString(Scanner scanner) {
        String contains = scanner.nextLine();
        this.bookService.findAllByTitleContaining(contains)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);

    }

    // 6.	Authors Search
    private void printAuthorNames(Scanner scanner) {
        String end = scanner.nextLine();
        this.authorService.findAllByFirstNameEndsWith(end)
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
    }

    // 5.	Books Released Before Date
    private void printBooksReleasedBeforeDate(Scanner scanner) {
        String[] date = scanner.nextLine().split("-");
        int year = Integer.parseInt(date[2]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[0]);
        this.bookService.findAllBooksByReleaseDateBefore(LocalDate.of(year, month, day))
                .forEach(book -> System.out.printf("%s %s %.2f%n", book.getTitle(), book.getEditionType(), book.getPrice()));
    }

    // 4.	Not Released Books
    private void printTitleOfBooksThatAreNotReleasedInGivenYear(Scanner scanner) {
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate localDate1 = LocalDate.of(year, 1, 1);
        LocalDate localDate2 = LocalDate.of(year, 12, 31);
        this.bookService.findAllByReleaseDateBeforeOrReleaseDateAfter(localDate1, localDate2)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    // 3.	Books by Price
    private void printTitleAndPriceOfBookWithPriceLowerOrHigherThan() {
        this.bookService.
                findAllByPriceIsLessThanOrPriceIsGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(book -> System.out.printf("%s - $%.2f%n", book.getTitle(), book.getPrice()));

    }

    // 2.	Golden Books
    private void printTitlesOfGoldenEditionBooksWithLessThan5000Copies() {
        this.bookService.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    // 1.	Books Titles by Age Restriction
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
