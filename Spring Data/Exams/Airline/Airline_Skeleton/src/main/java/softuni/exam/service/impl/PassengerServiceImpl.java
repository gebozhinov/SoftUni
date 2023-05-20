package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.passenger.PassengerImportDTO;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Ticket;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static softuni.exam.constant.Message.INVALID_DATA;
import static softuni.exam.constant.Message.SUCCESSFULLY_IMPORTED_PASSENGER;
import static softuni.exam.constant.Paths.IMPORT_PASSENGERS_PATH;

@Service
public class PassengerServiceImpl implements PassengerService {

    private static final String PRINT_OUTPUT = "Passenger %s %s%n" +
            "   Email - %s%n" +
            "   Phone - %s%n" +
            "   Number of tickets - %s%n";

    private final PassengerRepository passengerRepository;

    private final TownRepository townRepository;

    private final Gson gson;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    public PassengerServiceImpl(PassengerRepository passengerRepository,
                                TownRepository townRepository,
                                Gson gson,
                                ModelMapper modelMapper,
                                ValidationUtil validationUtil) {
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(IMPORT_PASSENGERS_PATH);
    }

    @Override
    public String importPassengers() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPassengersFileContent(), PassengerImportDTO[].class))
                .forEach(passengerImportDTO -> {
                    boolean isValid = validationUtil.isValid(passengerImportDTO);

                    Optional<Town> town = townRepository.findFirstByName(passengerImportDTO.getTown());

                    if (town.isEmpty()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Passenger passenger = modelMapper.map(passengerImportDTO, Passenger.class);
                        passenger.setTown(town.get());
                        passengerRepository.saveAndFlush(passenger);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_PASSENGER,
                                        passenger.getLastName(), passenger.getEmail()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INVALID_DATA, "Passenger"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {

        StringBuilder sb = new StringBuilder();

        List<Passenger> passengers = this.passengerRepository.getPassengersOrderByTicketsCountDescendingThenByEmail()
                .orElseThrow(NoSuchElementException::new);

        passengers.forEach(passenger ->
                sb.append(String.format(PRINT_OUTPUT,
                                passenger.getFirstName(),
                                passenger.getLastName(),
                                passenger.getEmail(),
                                passenger.getPhoneNumber(),
                                passenger.getTickets().size()))
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
