package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.car.CarDTO;
import bg.softuni.cardealer.model.dtos.car.CarInfoDTO;
import bg.softuni.cardealer.model.dtos.car.CarWithPartsDTO;
import bg.softuni.cardealer.model.dtos.car.wrapper.CarInfoWrapper;
import bg.softuni.cardealer.model.dtos.car.wrapper.CarsWithPartsWrapper;
import bg.softuni.cardealer.model.entities.Car;
import bg.softuni.cardealer.repository.CarRepository;
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
import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.cardealer.config.Paths.*;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public List<CarInfoDTO> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make) throws IOException, JAXBException {
        List<Car> cars =
                this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make)
                        .orElseThrow(NoSuchElementException::new);

        List<CarInfoDTO> carInfoDTOS = cars.stream().map(car -> modelMapper.map(car, CarInfoDTO.class))
                .toList();

        FileWriter fileWriter = new FileWriter(CARS_FROM_MAKE_TOYOTA.toFile());
        gson.toJson(carInfoDTOS, fileWriter);
        fileWriter.close();

        File file = CARS_FROM_MAKE_TOYOTA_XML.toFile();
        CarInfoWrapper carInfoWrapper = new CarInfoWrapper(carInfoDTOS);
        JAXBContext context = JAXBContext.newInstance(CarInfoWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(carInfoWrapper, file);

        return carInfoDTOS;
    }

    @Override
    public List<CarDTO> findAllWithParts() throws IOException, JAXBException {
        List<Car> cars = this.carRepository.findAll();
        List<CarDTO> carDTOS = cars.stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
                .toList();
        FileWriter fileWriter = new FileWriter(EXPORT_CARS_WITH_PARTS.toFile());
        gson.toJson(carDTOS, fileWriter);
        fileWriter.close();

        List<CarWithPartsDTO> CarWithPartsDTO =
                cars.stream().map(car -> modelMapper.map(car, CarWithPartsDTO.class))
                .toList();
        File file = EXPORT_CARS_WITH_PARTS_XML.toFile();
        CarsWithPartsWrapper carsWithPartsWrapper = new CarsWithPartsWrapper(CarWithPartsDTO);
        JAXBContext context = JAXBContext.newInstance(CarsWithPartsWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(carsWithPartsWrapper, file);

        return carDTOS;
    }
}
