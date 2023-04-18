package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.CarInfoDTO;
import bg.softuni.cardealer.model.entities.Car;
import bg.softuni.cardealer.repository.CarRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.cardealer.config.Paths.CARS_FROM_MAKE_TOYOTA;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public List<CarInfoDTO> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make) throws IOException {
        List<Car> cars =
                this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make)
                        .orElseThrow(NoSuchElementException::new);

        List<CarInfoDTO> carInfoDTOS = cars.stream().map(car -> modelMapper.map(car, CarInfoDTO.class))
                .toList();

        FileWriter fileWriter = new FileWriter(CARS_FROM_MAKE_TOYOTA.toFile());
        gson.toJson(carInfoDTOS, fileWriter);

        fileWriter.close();

        return carInfoDTOS;
    }
}
