package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.city.ImportCitiesDTO;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;

import static softuni.exam.constants.Message.INCORRECT_DATA;
import static softuni.exam.constants.Message.SUCCESSFULLY_IMPORTED_CITY;
import static softuni.exam.constants.Paths.IMPORT_CITIES_PATH;
import static softuni.exam.constants.Paths.IMPORT_COUNTRIES_PATH;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public CityServiceImpl(CityRepository cityRepository,
                           CountryRepository countryRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(IMPORT_CITIES_PATH);
    }

    @Override
    public String importCities() throws IOException {

        StringBuilder sb = new StringBuilder();

        ImportCitiesDTO[] importCitiesDTOS = gson.fromJson(readCitiesFileContent(), ImportCitiesDTO[].class);
        for (ImportCitiesDTO importCityDTO : importCitiesDTOS) {
            boolean isValid = this.validationUtils.isValid(importCityDTO);

            if (this.cityRepository.findFirstByCityName(importCityDTO.getCityName()).isPresent()) {
                isValid = false;
            }

            if (isValid) {
                sb.append(String.format(
                                SUCCESSFULLY_IMPORTED_CITY,
                                importCityDTO.getCityName(),
                                importCityDTO.getPopulation()))
                        .append(System.lineSeparator());
                City city = modelMapper.map(importCityDTO, City.class);
                city.setCountry(this.countryRepository.getById(importCityDTO.getCountry()));
                this.cityRepository.saveAndFlush(city);
            } else {
                sb.append(String.format(INCORRECT_DATA, "city")).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
