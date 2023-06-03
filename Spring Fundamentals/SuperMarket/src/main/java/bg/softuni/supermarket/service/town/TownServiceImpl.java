package bg.softuni.supermarket.service.town;

import bg.softuni.supermarket.domain.entities.Town;
import bg.softuni.supermarket.repository.TownRepository;
import org.springframework.stereotype.Service;

import static bg.softuni.supermarket.constant.Messages.SUCCESSFULLY_ADDED;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public String addTown(String townName) {

        Town town = new Town();
        town.setName(townName);
        townRepository.saveAndFlush(town);

        return String.format(SUCCESSFULLY_ADDED, "town!");
    }
}
