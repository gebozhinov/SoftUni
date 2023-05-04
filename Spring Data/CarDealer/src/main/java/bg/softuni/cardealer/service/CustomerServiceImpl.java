package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.customer.wrapper.CustomerInfoWrapper;
import bg.softuni.cardealer.model.dtos.customer.CustomerDTO;
import bg.softuni.cardealer.model.dtos.customer.CustomerInfoDTO;
import bg.softuni.cardealer.model.dtos.customer.CustomerTotalSaleDTO;
import bg.softuni.cardealer.model.dtos.customer.wrapper.CustomerTotalSaleWrapper;
import bg.softuni.cardealer.model.entities.Customer;
import bg.softuni.cardealer.repository.CustomerRepository;
import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.cardealer.config.Paths.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public List<Customer> getAllCustomers() throws IOException, JAXBException {
        List<Customer> customers = this.customerRepository.getAllCustomers().orElseThrow(NoSuchElementException::new);
        FileWriter fileWriter = new FileWriter(EXPORT_ORDERED_CUSTOMERS.toFile());

        List<CustomerDTO> customerDTOS = new ArrayList<>();
        List<CustomerInfoDTO> customerInfoDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            String birthdate = customer.getBirthDate().toString();

            CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
            customerDTO.setBirthDate(birthdate);
            customerDTOS.add(customerDTO);

            CustomerInfoDTO customerInfoDTO = mapper.map(customer, CustomerInfoDTO.class);
            customerInfoDTO.setBirthDate(birthdate);
            customerInfoDTOS.add(customerInfoDTO);
        }
        gson.toJson(customerDTOS, fileWriter);
        fileWriter.close();


        CustomerInfoWrapper customerWrapper = new CustomerInfoWrapper(customerInfoDTOS);
        File file = EXPORT_ORDERED_CUSTOMERS_XML.toFile();
        JAXBContext context = JAXBContext.newInstance(CustomerInfoWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(customerWrapper, file);

        return customers;
    }

    @Override
    public List<CustomerTotalSaleDTO> getTotalSalesByCustomer() throws IOException, JAXBException {
        List<Customer> customers =
                this.customerRepository.getTotalSalesByCustomer().orElseThrow(NoSuchElementException::new);
        customers.forEach(Customer::calculateSpentMoney);

        List<CustomerTotalSaleDTO> customerTotalSaleDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerTotalSaleDTO customerTotalSaleDTO = mapper.map(customer, CustomerTotalSaleDTO.class);
            customerTotalSaleDTO.setBoughtCars(customer.getSales().size());
            customerTotalSaleDTOS.add(customerTotalSaleDTO);
        }

        List<CustomerTotalSaleDTO> sortedCustomers = customerTotalSaleDTOS.stream()
                .sorted(Comparator.comparing(CustomerTotalSaleDTO::getSpentMoney).reversed()
                        .thenComparing(CustomerTotalSaleDTO::getBoughtCars)).toList();

        FileWriter fileWriter = new FileWriter(TOTAL_SALES_BY_CUSTOMER.toFile());
        gson.toJson(sortedCustomers, fileWriter);
        fileWriter.close();

        File file = TOTAL_SALES_BY_CUSTOMER_XML.toFile();
        CustomerTotalSaleWrapper customerTotalSaleWrapper = new CustomerTotalSaleWrapper(sortedCustomers);
        JAXBContext context = JAXBContext.newInstance(CustomerTotalSaleWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(customerTotalSaleWrapper, file);

        return sortedCustomers;
    }
}
