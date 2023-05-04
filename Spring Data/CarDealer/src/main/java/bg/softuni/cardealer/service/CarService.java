package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.car.CarDTO;
import bg.softuni.cardealer.model.dtos.car.CarInfoDTO;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public interface CarService {

    List<CarInfoDTO> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make) throws IOException, JAXBException;

    List<CarDTO> findAllWithParts() throws IOException, JAXBException;
}
