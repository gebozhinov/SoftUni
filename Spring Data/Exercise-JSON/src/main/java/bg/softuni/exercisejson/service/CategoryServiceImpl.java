package bg.softuni.exercisejson.service;

import bg.softuni.exercisejson.model.dtos.category.CategoriesByProductCountDTO;
import bg.softuni.exercisejson.model.dtos.category.wrappers.CategoriesByProductCountWrapper;
import bg.softuni.exercisejson.repository.CategoryRepository;
import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.exercisejson.config.Paths.EXPORT_CATEGORIES_BY_PRODUCTS_COUNT;
import static bg.softuni.exercisejson.config.Paths.EXPORT_CATEGORIES_BY_PRODUCTS_COUNT_XML;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final Gson gson;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
    }

    @Override
    public List<CategoriesByProductCountDTO> getAllByProductsCount() throws IOException, JAXBException {
        List<CategoriesByProductCountDTO> categoriesByProductCountDTOS =
                this.categoryRepository.getAllByProductsCount().orElseThrow(NoSuchElementException::new);

        FileWriter fileWriter = new FileWriter(EXPORT_CATEGORIES_BY_PRODUCTS_COUNT.toFile());
        gson.toJson(categoriesByProductCountDTOS, fileWriter);
        fileWriter.close();

        CategoriesByProductCountWrapper categoriesByProductCountWrapper =
                new CategoriesByProductCountWrapper(categoriesByProductCountDTOS);

        File file = EXPORT_CATEGORIES_BY_PRODUCTS_COUNT_XML.toFile();

        JAXBContext context = JAXBContext.newInstance(CategoriesByProductCountWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(categoriesByProductCountWrapper, file);

        return categoriesByProductCountDTOS;
    }
}
