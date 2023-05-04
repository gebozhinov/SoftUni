package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.customer.CustomerTotalSaleDTO;
import bg.softuni.cardealer.model.entities.Customer;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomers() throws IOException, JAXBException;

    List<CustomerTotalSaleDTO> getTotalSalesByCustomer() throws IOException, JAXBException;
}
