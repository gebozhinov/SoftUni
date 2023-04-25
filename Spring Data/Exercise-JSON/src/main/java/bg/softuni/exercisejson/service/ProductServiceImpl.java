package bg.softuni.exercisejson.service;

import bg.softuni.exercisejson.model.dtos.product.ProductDTO;
import bg.softuni.exercisejson.model.dtos.product.wrappers.ProductWrapperDTO;
import bg.softuni.exercisejson.repository.ProductRepository;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.exercisejson.config.Paths.EXPORT_PRODUCTS_WITH_NO_BUYERS_IN_PRICE_RANGE;
import static bg.softuni.exercisejson.config.Paths.EXPORT_PRODUCTS_WITH_NO_BUYERS_IN_PRICE_RANGE_XML;

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
    public List<ProductDTO> findAllByPriceInRange(BigDecimal low, BigDecimal high) throws IOException, JAXBException {
        List<ProductDTO> productDTOS =
                productRepository.findAllByPriceInRange(low, high).orElseThrow(NoSuchElementException::new);

        FileWriter fileWriter = new FileWriter(EXPORT_PRODUCTS_WITH_NO_BUYERS_IN_PRICE_RANGE.toFile());
        gson.toJson(productDTOS, fileWriter);
        fileWriter.close();

        ProductWrapperDTO productWrapperDTO = new ProductWrapperDTO(productDTOS);
        File file = EXPORT_PRODUCTS_WITH_NO_BUYERS_IN_PRICE_RANGE_XML.toFile();

        JAXBContext context =  JAXBContext.newInstance(ProductWrapperDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(productWrapperDTO, file);

        return productDTOS;
    }
}
