package bg.softuni.exercisespringdataautomappingobjects.service.game;

import bg.softuni.exercisespringdataautomappingobjects.model.dto.GameDTO;
import bg.softuni.exercisespringdataautomappingobjects.model.entities.Game;
import bg.softuni.exercisespringdataautomappingobjects.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper mapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper mapper) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
    }

    @Override
    public void add(String[] args) {
        String title = args[1];
        BigDecimal price = new BigDecimal(args[2]);
        double size = Double.parseDouble(args[3]);
        String trailer = args[4];
        String imgUrl = args[5];
        String description = args[6];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate releaseDate = LocalDate.parse(args[7], formatter);

        GameDTO gameDTO = new GameDTO(title, price, size, trailer, imgUrl, description, releaseDate);
        Game game = this.mapper.map(gameDTO, Game.class);
        this.gameRepository.save(game);
    }

    @Transactional
    @Modifying
    @Override
    public void edit(String[] args) throws NoSuchFieldException {
        long id = Long.parseLong(args[1]);
        Game game = findById(id);

        Map<String, String> editValues = new HashMap<>();
        for (int i = 2; i < args.length; i++) {
            String[] values = args[i].split("=");
            editValues.put(values[0], values[1]);
        }

        for (var entry : editValues.entrySet()) {
            String field = entry.getKey();
            String val = entry.getValue();

            switch (field) {
                case "title" -> game.setTitle(val);
                case "trailer" -> game.setTrailer(val);
                case "imgUrl" -> game.setImgUrl(val);
                case "size" -> game.setSize(Double.parseDouble(val));
                case "price" -> game.setPrice(new BigDecimal(val));
                case "description" -> game.setDescription(val);
                case "releaseDate" -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
                    game.setReleaseDate(LocalDate.parse(val, formatter));
                }
            }
        }

    }

    @Override
    public Game findById(long id) {
        return this.gameRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public String delete(long id) {
        Game game = this.gameRepository.findById(id).orElseThrow(NoSuchElementException::new);
        String title = game.getTitle();
        this.gameRepository.delete(game);
        return title;
    }

}
