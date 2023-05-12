package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.customer.ImportCustomerDTO;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static exam.constant.Message.INVALID_DATA;
import static exam.constant.Message.SUCCESSFULLY_IMPORTED_CUSTOMER;
import static exam.constant.Paths.IMPORT_CUSTOMERS_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final TownRepository townRepository;
    private final Gson gson;

    private final ModelMapper modelMapper;

    private final ValidationUtils validationUtils;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               TownRepository townRepository,
                               Gson gson,
                               ModelMapper modelMapper,
                               ValidationUtils validationUtils) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(IMPORT_CUSTOMERS_PATH);
    }

    @Override
    public String importCustomers() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCustomersFileContent(), ImportCustomerDTO[].class))
                .forEach(importCustomerDTO -> {
                    boolean isValid = validationUtils.isValid(importCustomerDTO);

                    if (customerRepository.findFirstByEmail(importCustomerDTO.getEmail()).isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Customer customer = modelMapper.map(importCustomerDTO, Customer.class);

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String date = importCustomerDTO.getRegisteredOn();
                        LocalDate registeredOn = LocalDate.parse(date, formatter);
                        customer.setRegisteredOn(registeredOn);

                        Town town = townRepository.findFirstByName(importCustomerDTO.getTown().getName())
                                .orElseThrow(NoSuchElementException::new);
                        customer.setTown(town);

                        customerRepository.saveAndFlush(customer);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_CUSTOMER,
                                        customer.getFirstName(),
                                        customer.getLastName(),
                                        customer.getEmail()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INVALID_DATA, "Customer"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
