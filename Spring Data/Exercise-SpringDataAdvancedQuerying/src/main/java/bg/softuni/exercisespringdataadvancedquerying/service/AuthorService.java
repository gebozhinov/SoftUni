package bg.softuni.exercisespringdataadvancedquerying.service;

import bg.softuni.exercisespringdataadvancedquerying.model.entity.Author;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<Author> findAllByFirstNameEndsWith(String end);
}
