package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.sale.SaleDTO;
import bg.softuni.cardealer.model.entities.Sale;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public interface SaleService {

    List<SaleDTO> getAll() throws IOException, JAXBException;
}
