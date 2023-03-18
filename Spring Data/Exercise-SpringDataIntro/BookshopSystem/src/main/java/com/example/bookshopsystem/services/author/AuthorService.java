package com.example.bookshopsystem.services.author;


import com.example.bookshopsystem.models.Author;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public interface AuthorService {

    void seedAuthors() throws IOException;
    Author getRandomAuthor();

    List<Author> findDistinctByBooksBefore(LocalDate date);
    List<Author> getAllAuthorsOrderByBooks();


}
