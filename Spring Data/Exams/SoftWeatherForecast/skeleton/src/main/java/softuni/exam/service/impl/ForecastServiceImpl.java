package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.forecast.ImportForecastDTO;
import softuni.exam.models.dto.forecast.ImportForecastWrapper;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.constants.Message.INCORRECT_DATA;
import static softuni.exam.constants.Message.SUCCESSFULLY_IMPORTED_FORECAST;
import static softuni.exam.constants.Paths.IMPORT_FORECASTS_PATH;

@Service
public class ForecastServiceImpl implements ForecastService {
    public final String PRINT_FORMAT =
            "City: %s:%n -min temperature: %.2f%n --max temperature: %.2f%n ---sunrise: %s:%n ----sunset: %s:%n";
    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public ForecastServiceImpl(ForecastRepository forecastRepository,
                               CityRepository cityRepository,
                               ModelMapper modelMapper,
                               ValidationUtils validationUtils) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(IMPORT_FORECASTS_PATH);
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        FileReader fileReader = new FileReader(IMPORT_FORECASTS_PATH.toFile());

        JAXBContext context = JAXBContext.newInstance(ImportForecastWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportForecastWrapper unmarshal = (ImportForecastWrapper) unmarshaller.unmarshal(fileReader);

        for (ImportForecastDTO forecast : unmarshal.getForecasts()) {
            boolean isValid = validationUtils.isValid(forecast);

            if (this.forecastRepository.findFirstByDayOfWeekAndCity(forecast.getDayOfWeek(),
                    this.cityRepository.getById(forecast.getCity())).isPresent()) {
                isValid = false;
            }

            if (isValid) {
                Forecast forecastToSave = modelMapper.map(forecast, Forecast.class);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime sunrise = LocalTime.parse(forecast.getSunrise(), formatter);
                LocalTime sunset = LocalTime.parse(forecast.getSunset(), formatter);

                forecastToSave.setSunrise(sunrise);
                forecastToSave.setSunset(sunset);

                forecastToSave.setCity(this.cityRepository.getById(forecast.getCity()));

                this.forecastRepository.saveAndFlush(forecastToSave);
                sb.append(String.format(SUCCESSFULLY_IMPORTED_FORECAST, forecast.getDayOfWeek(),
                                forecast.getMaxTemperature()))
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format(INCORRECT_DATA, "forecast")).append(System.lineSeparator());
            }
        }

        fileReader.close();
        return sb.toString().trim();
    }

    @Override
    public String exportForecasts() {
        List<Forecast> forecasts = this.forecastRepository.findAllByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(
                        DayOfWeek.SUNDAY, 150000)
                .orElseThrow(NoSuchElementException::new);

        return forecasts.stream().map(forecast -> String.format(PRINT_FORMAT,
                        forecast.getCity().getCityName(),
                        forecast.getMinTemperature(),
                        forecast.getMaxTemperature(),
                        forecast.getSunrise(),
                        forecast.getSunset()))
                .collect(Collectors.joining(System.lineSeparator()));


    }
}
