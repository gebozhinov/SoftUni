package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ticket.TicketImportWrapper;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Plane;
import softuni.exam.models.entity.Ticket;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static softuni.exam.constant.Message.INVALID_DATA;
import static softuni.exam.constant.Message.SUCCESSFULLY_IMPORTED_TICKET;
import static softuni.exam.constant.Paths.IMPORT_TICKETS_PATH;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final TownRepository townRepository;

    private final PassengerRepository passengerRepository;

    private final PlaneRepository planeRepository;
    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    public TicketServiceImpl(TicketRepository ticketRepository,
                             TownRepository townRepository,
                             PassengerRepository passengerRepository,
                             PlaneRepository planeRepository,
                             ModelMapper modelMapper,
                             ValidationUtil validationUtil) {
        this.ticketRepository = ticketRepository;
        this.townRepository = townRepository;
        this.passengerRepository = passengerRepository;
        this.planeRepository = planeRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(IMPORT_TICKETS_PATH);
    }

    @Override
    public String importTickets() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_TICKETS_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(TicketImportWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        TicketImportWrapper ticketImportWrapper = (TicketImportWrapper) unmarshaller.unmarshal(file);

        ticketImportWrapper.getTickets()
                .forEach(ticketImportDTO -> {
                    boolean isValid = validationUtil.isValid(ticketImportDTO);

                    Optional<Town> fromTown =
                            townRepository.findFirstByName(ticketImportDTO.getFromTown().getName());
                    Optional<Town> toTown =
                            townRepository.findFirstByName(ticketImportDTO.getToTown().getName());
                    Optional<Passenger> passenger =
                            passengerRepository.findFirstByEmail(ticketImportDTO.getPassenger().getEmail());
                    Optional<Plane> plane =
                            planeRepository.findFirstByRegisteredNumber(ticketImportDTO.getPlane().getRegisterNumber());

                    if (fromTown.isEmpty() || toTown.isEmpty() || passenger.isEmpty() || plane.isEmpty()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Ticket ticket = modelMapper.map(ticketImportDTO, Ticket.class);

                        String str = ticketImportDTO.getTakeOff();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime takeOff = LocalDateTime.parse(str, formatter);
                        ticket.setTakeOff(takeOff);

                        ticket.setFromTown(fromTown.get());
                        ticket.setToTown(toTown.get());
                        ticket.setPassenger(passenger.get());
                        ticket.setPlane(plane.get());

                        ticketRepository.saveAndFlush(ticket);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_TICKET,
                                        ticket.getFromTown().getName(),
                                        ticket.getToTown().getName()))
                                .append(System.lineSeparator());

                    } else {
                        sb.append(String.format(INVALID_DATA, "Ticket"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
