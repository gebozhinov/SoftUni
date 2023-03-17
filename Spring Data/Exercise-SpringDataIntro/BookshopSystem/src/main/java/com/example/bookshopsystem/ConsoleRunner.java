package com.example.bookshopsystem;


import com.example.bookshopsystem.models.Author;
import com.example.bookshopsystem.models.Book;
import com.example.bookshopsystem.services.author.AuthorService;
import com.example.bookshopsystem.services.book.BookService;
import com.example.bookshopsystem.services.category.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoriesService categoriesService;

    @Autowired
    public ConsoleRunner(AuthorService authorService, BookService bookService, CategoriesService categoriesService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoriesService = categoriesService;
    }


    @Override
    public void run(String... args) throws Exception {

        this.authorService.seedAuthors();
        this.categoriesService.seedCategories();
        this.bookService.seedBooks();

        List<Book> bookList = this.bookService.findAllByReleaseDateAfter(LocalDate.of(2000, 1, 1));
        bookList.forEach(book -> System.out.println(book.getTitle()));

        List<Author> authors = this.authorService.findDistinctByBooksBefore(LocalDate.of(1990, 1,1));
        authors.forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));


    }
}
