package bg.softuni.Battleships.service;

import bg.softuni.Battleships.model.Category;
import bg.softuni.Battleships.model.Ship;
import bg.softuni.Battleships.model.User;
import bg.softuni.Battleships.model.dto.AddShipDTO;
import bg.softuni.Battleships.model.dto.ShipDTO;
import bg.softuni.Battleships.model.mapper.AddShipMapper;
import bg.softuni.Battleships.model.mapper.ShipMapper;
import bg.softuni.Battleships.repository.CategoryRepository;
import bg.softuni.Battleships.repository.ShipRepository;
import bg.softuni.Battleships.repository.UserRepository;
import bg.softuni.Battleships.user.SessionUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final SessionUser sessionUser;
    private final AddShipMapper addShipMapper;
    private final ShipMapper shipMapper;

    public ShipService(ShipRepository shipRepository,
                       CategoryRepository categoryRepository,
                       UserRepository userRepository,
                       SessionUser sessionUser,
                       AddShipMapper addShipMapper,
                       ShipMapper shipMapper) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.sessionUser = sessionUser;
        this.addShipMapper = addShipMapper;
        this.shipMapper = shipMapper;
    }

    public void addShip(AddShipDTO addShipDTO) {

        Ship ship = this.addShipMapper.addShipDTOToShip(addShipDTO);

        Category category = this.categoryRepository.findByName(addShipDTO.getCategory()).get();

        User user = this.userRepository.findById(sessionUser.getId()).get();

        ship.setCategory(category);
        ship.setUser(user);

        this.shipRepository.save(ship);

    }

    public List<ShipDTO> getOwnerShips() {

        List<Ship> ships = this.shipRepository.getOwnerShips(sessionUser.getId()).orElse(null);

        return this.shipMapper.shipsToShipsDTO(ships);

    }
    public List<ShipDTO> getEnemyShips() {

        List<Ship> ships = this.shipRepository.getEnemyShips(sessionUser.getId()).orElse(null);

        return this.shipMapper.shipsToShipsDTO(ships);

    }

    public List<ShipDTO> getAllShips() {

        List<Ship> ships = this.shipRepository.getAllShips().orElse(null);

        return this.shipMapper.shipsToShipsDTO(ships);

    }

}
