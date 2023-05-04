package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.supplier.LocalSuppliersDTO;
import bg.softuni.cardealer.model.entities.Supplier;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public interface SupplierService {

    List<LocalSuppliersDTO> findAllByImporterIsFalse() throws IOException, JAXBException;
}
