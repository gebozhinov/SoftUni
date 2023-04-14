package bg.softuni.exercisejson.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {

    void seedUsers() throws IOException;
    void seedProducts() throws IOException;
    void seedCategories() throws IOException;

    default void seedDatabase() throws IOException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
