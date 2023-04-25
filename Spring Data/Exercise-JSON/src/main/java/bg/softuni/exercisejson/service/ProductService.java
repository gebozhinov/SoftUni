package bg.softuni.exercisejson.service;

import bg.softuni.exercisejson.model.dtos.product.ProductDTO;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllByPriceInRange(BigDecimal low, BigDecimal high) throws IOException, JAXBException;
}
