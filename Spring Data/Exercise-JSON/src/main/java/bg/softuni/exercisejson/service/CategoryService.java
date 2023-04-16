package bg.softuni.exercisejson.service;

import bg.softuni.exercisejson.model.dtos.category.CategoriesByProductCountDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

   List<CategoriesByProductCountDTO> getAllByProductsCount() throws IOException;

}
