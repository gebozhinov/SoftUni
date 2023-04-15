package bg.softuni.exercisejson.service;

import bg.softuni.exercisejson.model.dtos.product.ProductDTO;
import bg.softuni.exercisejson.repository.ProductRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.exercisejson.config.Paths.EXPORT_PRODUCTS_WITH_NO_BUYERS_IN_PRICE_RANGE;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Gson gson;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, Gson gson) {
        this.productRepository = productRepository;
        this.gson = gson;
    }

    @Override
    public List<ProductDTO> findAllByPriceInRange(BigDecimal low, BigDecimal high) throws IOException {
        List<ProductDTO> productDTOS =
                productRepository.findAllByPriceInRange(low, high).orElseThrow(NoSuchElementException::new);

        FileWriter fileWriter = new FileWriter(EXPORT_PRODUCTS_WITH_NO_BUYERS_IN_PRICE_RANGE.toFile());
        gson.toJson(productDTOS, fileWriter);
        fileWriter.close();
        return productDTOS;
    }
}
