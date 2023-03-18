package com.example.bookshopsystem.services.book;

import com.example.bookshopsystem.models.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;
    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}
