package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }


    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        houses.stream().filter(house -> house.getName().equals(houseName))
                .forEach(house -> house.buyToy(toy));
        toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        House house = houses.stream().filter(house1 -> house1.getName().equals(houseName))
                .findFirst().orElse(null);
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        if ((house.getClass().getSimpleName().equals("LongHouse") && catType.equals("ShorthairCat"))
                || house.getClass().getSimpleName().equals("ShortHouse") && catType.equals("LonghairCat")) {
            return UNSUITABLE_HOUSE;
        }
        houses.stream().filter(house1 -> house1.getName().equals(houseName))
                .forEach(house1 -> house1.addCat(cat));
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {

        houses.stream().filter(house -> house.getName().equals(houseName))
                .forEach(house -> {
                    house.getCats().forEach(Cat::eating);
                });


        int fedCats = 0;
        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                fedCats = house.getCats().size();
                break;
            }
        }

        return String.format(FEEDING_CAT, fedCats);
    }

    @Override
    public String sumOfAll(String houseName) {

        double[] toysPrice = {0};
        double[] catsPrice = {0};
        houses.stream().filter(house -> house.getName().equals(houseName))
                .forEach(house -> house.getToys().forEach(toy -> toysPrice[0] += toy.getPrice()));
        houses.stream().filter(house -> house.getName().equals(houseName))
                .forEach(house -> house.getCats().forEach(cat -> catsPrice[0] += cat.getPrice()));

        return String.format(VALUE_HOUSE, houseName, toysPrice[0] + catsPrice[0]);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (House house : houses) {
            sb.append(house.getStatistics());
        }

        return sb.toString().trim();
    }
}
