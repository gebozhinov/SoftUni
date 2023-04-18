package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.CarInfoDTO;
import bg.softuni.cardealer.model.entities.Car;

import java.io.IOException;
import java.util.List;

public interface CarService {

    List<CarInfoDTO> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make) throws IOException;
}
