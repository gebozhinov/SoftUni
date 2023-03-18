package com.example.bookshopsystem.services.book;

import com.example.bookshopsystem.models.Book;
import com.example.bookshopsystem.models.enums.AgeRestriction;
import com.example.bookshopsystem.models.enums.EditionType;
import com.example.bookshopsystem.repositories.BookRepository;
import com.example.bookshopsystem.services.author.AuthorService;
import com.example.bookshopsystem.services.category.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.bookshopsystem.constant.FilePath.BOOKS_FILE_NAME;
import static com.example.bookshopsystem.constant.FilePath.RESOURCE_URL;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoriesService categoriesService;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoriesService categoriesService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoriesService = categoriesService;
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_URL + BOOKS_FILE_NAME))
                .forEach(row -> {
                    String[] data = row.split("\\s+");
                    String title = Arrays.stream(data)
                            .skip(5)
                            .collect(Collectors.joining(" "));
                    Book book = new Book.Builder()
                            .withTitle(title)
                            .withEditionType(EditionType.values()[Integer.parseInt(data[0])])
                            .withReleaseDate(LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .withCopies(Integer.parseInt(data[2]))
                            .withPrice(new BigDecimal(data[3]))
                            .withAgeRestriction(AgeRestriction.values()[Integer.parseInt(data[4])])
                            .withAuthor(authorService.getRandomAuthor())
                            .withCategory(categoriesService.getRandomCategory())
                            .build();

                    this.bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllByReleaseDateAfter(LocalDate date) {

        return this.bookRepository
                        .findAllByReleaseDateAfter(date)
                        .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        return this.bookRepository.findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName)
                .orElseThrow(NoSuchElementException::new);

    }
}
