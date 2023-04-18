package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.customer.CustomerDTO;
import bg.softuni.cardealer.model.entities.Customer;
import bg.softuni.cardealer.repository.CustomerRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.cardealer.config.Paths.EXPORT_ORDERED_CUSTOMERS;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public List<Customer> getAllCustomers() throws IOException {
        List<Customer> customers = this.customerRepository.getAllCustomers().orElseThrow(NoSuchElementException::new);
        FileWriter fileWriter = new FileWriter(EXPORT_ORDERED_CUSTOMERS.toFile());

        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
            String birthdate = customer.getBirthDate().toString();
            customerDTO.setBirthDate(birthdate);

            customerDTOS.add(customerDTO);

        }

        gson.toJson(customerDTOS, fileWriter);
        fileWriter.close();
        return customers;
    }
}