package bg.softuni.cardealer.service;


import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface SeedService {

    void seedSuppliers() throws IOException, JAXBException;
    void seedParts() throws IOException, JAXBException;
    void seedCars() throws IOException, JAXBException;
    void seedCustomers() throws IOException, JAXBException;
    void seedSales();

    default void seedDatabase() throws IOException, JAXBException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }

}
