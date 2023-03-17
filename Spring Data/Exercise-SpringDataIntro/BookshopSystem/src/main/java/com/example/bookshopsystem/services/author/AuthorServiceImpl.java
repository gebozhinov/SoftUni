package com.example.bookshopsystem.services.author;

import com.example.bookshopsystem.models.Author;
import com.example.bookshopsystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static com.example.bookshopsystem.constant.FilePath.AUTHORS_FILE_NAME;
import static com.example.bookshopsystem.constant.FilePath.RESOURCE_URL;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_URL + AUTHORS_FILE_NAME))
                .forEach(row -> {
                    String[] data = row.split("\\s+");
                    String firstName = data[0];
                    String lastName = data[1];
                    Author author = new Author.Builder()
                            .withFirstName(firstName)
                            .withLastName(lastName)
                            .build();

                    this.authorRepository.save(author);

                });
    }

    @Override
    public Author getRandomAuthor() {
        final long count = this.authorRepository.count();
        if (count != 0) {
            final long randomAuthorId = new Random().nextLong(1L, count) + 1L;
            return this.authorRepository.findAuthorById(randomAuthorId);
        }
        throw new RuntimeException();
    }

    @Override
    public List<Author> findDistinctByBooksBefore(LocalDate date) {
        return this.authorRepository.findDistinctByBooksReleaseDateBefore(date)
                .orElseThrow(NoSuchElementException::new);
    }
}
