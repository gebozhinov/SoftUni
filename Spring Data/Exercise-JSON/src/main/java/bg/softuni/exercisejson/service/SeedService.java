package bg.softuni.exercisejson.service;

import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {

    void seedUsers() throws IOException, JAXBException;
    void seedProducts() throws IOException, JAXBException;
    void seedCategories() throws IOException, JAXBException;

    default void seedDatabase() throws IOException, JAXBException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
