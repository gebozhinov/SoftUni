package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {

    private Collection<Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return beverages.stream().filter(beverages1 -> beverages1.getName().equals(drinkName))
                .filter(beverages1 -> beverages1.getBrand().equals(drinkBrand))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(beverages);
    }

    @Override
    public void add(Beverages entity) {
        beverages.add(entity);
    }
}
