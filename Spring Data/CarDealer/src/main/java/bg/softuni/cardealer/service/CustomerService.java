package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.entities.Customer;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomers() throws IOException;
}
