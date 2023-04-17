package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.SupplierDTO;
import bg.softuni.cardealer.model.entities.Car;
import bg.softuni.cardealer.model.entities.Part;
import bg.softuni.cardealer.model.entities.Supplier;
import bg.softuni.cardealer.repository.CarRepository;
import bg.softuni.cardealer.repository.PartRepository;
import bg.softuni.cardealer.repository.SupplierRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static bg.softuni.cardealer.config.Paths.*;


@Service
public class SeedServiceImpl implements SeedService {

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;
    private final CarRepository carRepository;

    @Autowired
    public SeedServiceImpl(ModelMapper modelMapper, Gson gson,
                           SupplierRepository supplierRepository,
                           PartRepository partRepository,
                           CarRepository carRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
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
    public void seedCustomers() {

    }

    @Override
    public void seedSales() {

    }
}
