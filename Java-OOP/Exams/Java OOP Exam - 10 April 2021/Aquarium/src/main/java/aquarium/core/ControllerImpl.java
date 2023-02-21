package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName))
                .forEach(aquarium -> aquarium.addDecoration(decoration));
        decorations.remove(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquarium1 = aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName))
                .findFirst().orElse(null);
        if ((fishType.equals("FreshwaterFish") && aquarium1.getClass().getSimpleName().equals("SaltwaterAquarium")) ||
                fishType.equals("SaltwaterFish") && aquarium1.getClass().getSimpleName().equals("FreshwaterAquarium")) {
            return WATER_NOT_SUITABLE;
        }
        aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName))
                .forEach(aquarium -> aquarium.addFish(fish));

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium1 = aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName))
                .findFirst().orElse(null);
        aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName))
                .forEach(Aquarium::feed);
        int fedFish = aquarium1.getFish().size();

        return String.format(FISH_FED, fedFish);
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium1 = aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName))
                .findFirst().orElse(null);
        double fishPrice = aquarium1.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationPrice = aquarium1.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format(VALUE_AQUARIUM, aquariumName, fishPrice + decorationPrice);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
