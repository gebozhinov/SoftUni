package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.car.CarImportXmlDTO;
import bg.softuni.cardealer.model.dtos.car.wrapper.CarImportXmlWrapper;
import bg.softuni.cardealer.model.dtos.customer.CustomerDTO;
import bg.softuni.cardealer.model.dtos.customer.wrapper.CustomerWrapper;
import bg.softuni.cardealer.model.dtos.part.PartDTO;
import bg.softuni.cardealer.model.dtos.part.PartWrapper;
import bg.softuni.cardealer.model.dtos.supplier.SupplierBaseInfoDTO;
import bg.softuni.cardealer.model.dtos.supplier.wrapper.SupplierBaseInfoWrapper;
import bg.softuni.cardealer.model.entities.*;
import bg.softuni.cardealer.repository.*;
import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
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
    public void seedSuppliers() throws IOException, JAXBException {
        if (this.supplierRepository.count() == 0) {
            // JSON
//            FileReader fileReader = new FileReader(IMPORT_SUPPLIERS_PATH.toFile());
//            SupplierBaseInfoDTO[] supplierDTOS = gson.fromJson(fileReader, SupplierBaseInfoDTO[].class);
//            List<Supplier> suppliers = Arrays.stream(supplierDTOS)
//                    .map(supplierDTO -> modelMapper.map(supplierDTO, Supplier.class))
//                    .toList();

            // XML
            FileReader fileReader = new FileReader(IMPORT_SUPPLIERS_PATH_XML.toFile());
            JAXBContext context = JAXBContext.newInstance(SupplierBaseInfoWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SupplierBaseInfoWrapper supplierBaseInfoWrapper = (SupplierBaseInfoWrapper) unmarshaller.unmarshal(fileReader);


            List<Supplier> suppliers = supplierBaseInfoWrapper.getSuppliers().stream()
                    .map(supplierBaseInfoDTO -> modelMapper.map(supplierBaseInfoDTO, Supplier.class))
                    .toList();

            this.supplierRepository.saveAllAndFlush(suppliers);
            fileReader.close();
        }

    }

    @Override
    public void seedParts() throws IOException, JAXBException {
        if (partRepository.count() == 0) {

            // JSON
//            FileReader fileReader = new FileReader(IMPORT_PARTS_PATH.toFile());
//            Part[] parts = gson.fromJson(fileReader, Part[].class);

            // XML
            FileReader fileReader = new FileReader(IMPORT_PARTS_PATH_XML.toFile());
            JAXBContext context = JAXBContext.newInstance(PartWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PartWrapper unmarshal = (PartWrapper) unmarshaller.unmarshal(fileReader);
            List<Part> parts = unmarshal.getParts().stream()
                    .map(partDTO -> modelMapper.map(partDTO, PartDTO.class))
                    .map(part -> modelMapper.map(part, Part.class))
                    .toList();


            for (Part part : parts) {
                Supplier supplier = this.supplierRepository.getRandomSupplier().orElseThrow(NoSuchElementException::new);
                part.setSupplier(supplier);
            }

            // JSON
//            this.partRepository.saveAllAndFlush(Arrays.stream(parts).toList());

            // XML
            this.partRepository.saveAllAndFlush(parts);
            fileReader.close();
        }
    }

    @Override
    public void seedCars() throws IOException, JAXBException {
        if (carRepository.count() == 0) {

            // JSON
//            FileReader fileReader = new FileReader(IMPORT_CARS_PATH.toFile());
//            Car[] cars = gson.fromJson(fileReader, Car[].class);

            // XML
            FileReader fileReader = new FileReader(IMPORT_CARS_PATH_XML.toFile());
            JAXBContext context = JAXBContext.newInstance(CarImportXmlWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CarImportXmlWrapper carImportXmlWrapper = (CarImportXmlWrapper) unmarshaller.unmarshal(fileReader);
            List<Car> cars = carImportXmlWrapper.getCars().stream()
                    .map(carImportXmlDTO -> modelMapper.map(carImportXmlDTO, CarImportXmlDTO.class))
                    .map(car -> modelMapper.map(car, Car.class))
                    .toList();


            Random random = new Random();
            for (Car car : cars) {
                int num = random.nextInt(3, 6);
                Set<Part> parts = this.partRepository.getRandomParts(num).orElseThrow(NoSuchElementException::new);
                parts.forEach(car::addPart);
            }

            // JSON
//            this.carRepository.saveAllAndFlush(Arrays.stream(cars).toList());

            // XML
            this.carRepository.saveAllAndFlush(cars);
            fileReader.close();
        }
    }

    @Override
    public void seedCustomers() throws IOException, JAXBException {
        if (customerRepository.count() == 0) {

            // JSON
//            FileReader fileReader = new FileReader(IMPORT_CUSTOMERS_PATH.toFile());
//            CustomerDTO[] customerDTOS = gson.fromJson(fileReader, CustomerDTO[].class);

            // XML
            FileReader fileReader = new FileReader(IMPORT_CUSTOMERS_PATH_XML.toFile());
            JAXBContext context = JAXBContext.newInstance(CustomerWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CustomerWrapper customerWrapper = (CustomerWrapper) unmarshaller.unmarshal(fileReader);
            List<CustomerDTO> customerDTOS = customerWrapper.getCustomers().stream()
                    .map(customerDTO -> modelMapper.map(customerDTO, CustomerDTO.class))
                    .toList();


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
