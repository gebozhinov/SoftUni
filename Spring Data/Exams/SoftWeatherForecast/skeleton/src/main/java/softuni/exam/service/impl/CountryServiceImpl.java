package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.country.ImportCountriesDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static softuni.exam.constants.Message.INCORRECT_DATA;
import static softuni.exam.constants.Message.SUCCESSFULLY_IMPORTED_COUNTRY;
import static softuni.exam.constants.Paths.IMPORT_COUNTRIES_PATH;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final Gson gson;

    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public CountryServiceImpl(CountryRepository countryRepository,
                              Gson gson,
                              ModelMapper modelMapper,
                              ValidationUtils validationUtils) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(IMPORT_COUNTRIES_PATH);
    }

    @Override
    public String importCountries() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCountriesFromFile(), ImportCountriesDTO[].class))
                .forEach(importCountriesDTO -> {
                    boolean isValid = this.validationUtils.isValid(importCountriesDTO);

                    if (this.countryRepository
                            .findFirstByCountryName(
                                    importCountriesDTO.getCountryName()).isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_COUNTRY,
                                importCountriesDTO.getCountryName(), importCountriesDTO.getCurrency()));
                        sb.append(System.lineSeparator());
                        this.countryRepository.saveAndFlush(this.modelMapper.map(importCountriesDTO, Country.class));
                    } else {
                        sb.append(String.format(INCORRECT_DATA, "country")).append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
