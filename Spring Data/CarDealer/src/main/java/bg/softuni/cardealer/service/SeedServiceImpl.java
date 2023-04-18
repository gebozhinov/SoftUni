package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.customer.CustomerDTO;
import bg.softuni.cardealer.model.dtos.SupplierDTO;
import bg.softuni.cardealer.model.entities.*;
import bg.softuni.cardealer.repository.*;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static bg.softuni.cardealer.config.Paths.*;


@Service
public class SeedServiceImpl implements SeedService {

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public SeedServiceImpl(ModelMapper modelMapper, Gson gson,
                           SupplierRepository supplierRepository,
                           PartRepository partRepository,
                           CarRepository carRepository,
                           CustomerRepository customerRepository,
                           SaleRepository saleRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if (this.supplierRepository.count() == 0) {
            FileReader fileReader = new FileReader(IMPORT_SUPPLIERS_PATH.toFile());

            SupplierDTO[] supplierDTOS = gson.fromJson(fileReader, SupplierDTO[].class);
            List<Supplier> suppliers = Arrays.stream(supplierDTOS)
                    .map(supplierDTO -> modelMapper.map(supplierDTO, Supplier.class))
                    .toList();

            this.supplierRepository.saveAllAndFlush(suppliers);
            fileReader.close();
        }

    }

    @Override
    public void seedParts() throws IOException {
        if (partRepository.count() == 0) {
            FileReader fileReader = new FileReader(IMPORT_PARTS_PATH.toFile());
            Part[] parts = gson.fromJson(fileReader, Part[].class);


            for (Part part : parts) {
                Supplier supplier = this.supplierRepository.getRandomSupplier().orElseThrow(NoSuchElementException::new);
                part.setSupplier(supplier);
            }

            this.partRepository.saveAllAndFlush(Arrays.stream(parts).toList());
            fileReader.close();
        }
    }

    @Override
    public void seedCars() throws IOException {
        if (carRepository.count() == 0) {
            FileReader fileReader = new FileReader(IMPORT_CARS_PATH.toFile());
            Car[] cars = gson.fromJson(fileReader, Car[].class);

            Random random = new Random();
            for (Car car : cars) {
                int num = random.nextInt(3, 6);
                Set<Part> parts = this.partRepository.getRandomParts(num).orElseThrow(NoSuchElementException::new);
                parts.forEach(car::addPart);
            }

            this.carRepository.saveAllAndFlush(Arrays.stream(cars).toList());
            fileReader.close();
        }
    }

    @Override
    public void seedCustomers() throws IOException {
        if (customerRepository.count() == 0) {
            FileReader fileReader = new FileReader(IMPORT_CUSTOMERS_PATH.toFile());
            CustomerDTO[] customerDTOS = gson.fromJson(fileReader, CustomerDTO[].class);

            List<Customer> customers = new ArrayList<>();
            for (CustomerDTO customerDTO : customerDTOS) {
                String birthdate = customerDTO.getBirthDate().split("T")[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate parsedBirthdate = LocalDate.parse(birthdate, formatter);
                Customer customer = modelMapper.map(customerDTO, Customer.class);
                customer.setBirthDate(parsedBirthdate);
                customers.add(customer);
            }

            this.customerRepository.saveAllAndFlush(customers);
            fileReader.close();
        }
    }

    @Override
    public void seedSales() {
        if (saleRepository.count() == 0) {
            final int tableSalesRows = 50;

            List<Sale> sales = new ArrayList<>();
            List<Double> discounts = List.of(0.0, 5.0, 10.0, 15.0, 20.0, 30.0, 40.0, 50.0);
            Random random = new Random();
            for (int i = 0; i < tableSalesRows; i++) {
                Car car = carRepository.getRandomCar().orElseThrow(NoSuchElementException::new);
                Customer customer = customerRepository.getRandomCustomer().orElseThrow(NoSuchElementException::new);

                int randomNum = random.nextInt(0, 8);
                double discount = discounts.get(randomNum);

                Sale sale = new Sale();
                sale.setCar(car);
                sale.setCustomer(customer);
                sale.setDiscount(discount);
                sales.add(sale);
            }

            saleRepository.saveAllAndFlush(sales);
        }
    }
}
