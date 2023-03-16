package com.example.bookshopsystem;


import com.example.bookshopsystem.services.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(AuthorService authorService) {
        this.authorService = authorService;
    }


    @Override
    public void run(String... args) throws Exception {
      this.authorService.seedAuthors();
    }
}
