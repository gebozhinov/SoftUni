package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.*;

public class SpotRepository implements Repository<Spot> {


    private Map<String, Spot> spots;

    public SpotRepository() {
        this.spots = new LinkedHashMap<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(spots.values());
    }

    @Override
    public void add(Spot entity) {
        spots.putIfAbsent(entity.getName(), entity);

    }

    @Override
    public boolean remove(Spot entity) {
        return spots.remove(entity.getName(), entity);
    }

    @Override
    public Spot byName(String name) {
        return spots.get(name);
    }

}
