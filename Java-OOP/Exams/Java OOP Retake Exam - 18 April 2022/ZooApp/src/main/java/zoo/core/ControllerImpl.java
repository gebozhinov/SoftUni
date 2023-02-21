package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }


    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        switch (areaType) {
            case "WaterArea":
                area = new WaterArea(areaName);
                break;
            case "LandArea":
                area = new LandArea(areaName);
                break;
            default:
                throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.add(area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        areas.stream().filter(area -> area.getName().equals(areaName))
                .forEach(area -> area.addFood(food));
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        if ((animalType.equals("TerrestrialAnimal") && isMatch(areaName, "WaterArea")) ||
                animalType.equals("AquaticAnimal") && isMatch(areaName, "LandArea")) {
            return AREA_NOT_SUITABLE;
        }
        areas.stream().filter(area -> area.getName().equals(areaName))
                .forEach(area -> area.addAnimal(animal));

        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    private boolean isMatch(String areaName, String areaType) {
        return areas.stream().filter(area -> area.getName().equals(areaName))
                .anyMatch(area -> area.getClass().getSimpleName().equals(areaType));
    }

    @Override
    public String feedAnimal(String areaName) {
        int count = 0;
        for (Area area : areas) {
            if (area.getName().equals(areaName)) {
                count += area.getAnimals().size();
                break;
            }
        }
        areas.stream().filter(area -> area.getName().equals(areaName))
                .forEach(Area::feed);
        return String.format(ANIMALS_FED, count);
    }

    @Override
    public String calculateKg(String areaName) {
        double totalKg = 0;
        for (Area area : areas) {
            if (area.getName().equals(areaName)) {
                for (Animal animal : area.getAnimals()) {
                    totalKg += animal.getKg();
                }
            }
        }

        return String.format(KILOGRAMS_AREA, areaName, totalKg);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb=new StringBuilder();
        for (Area area : this.areas) {
            sb.append(area.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
