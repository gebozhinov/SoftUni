package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.ArrayList;
import java.util.List;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private List<Delicacy> delicacyRepository;
    private List<Cocktail> cocktailRepository;
    private List<Booth> boothRepository;

    private double totalStoreIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = new ArrayList<>();
        this.cocktailRepository = new ArrayList<>();
        this.boothRepository = new ArrayList<>();
        this.totalStoreIncome = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = null;

        if (isDelicacyExist(delicacyRepository, name)) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "Gingerbread":
                delicacy = new Gingerbread(name, price);
                break;
            case "Stolen":
                delicacy = new Stolen(name, price);
                break;
        }
        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }

    private boolean isDelicacyExist(List<Delicacy> delicacyRepository, String name) {
        for (Delicacy delicacy : delicacyRepository) {
            if (delicacy.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = null;

        if (isCocktailExist(cocktailRepository, name)) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "Hibernation":
                cocktail = new Hibernation(name, size, brand);
                break;
            case "MulledWine":
                cocktail = new MulledWine(name, size, brand);
                break;
        }

        cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    private boolean isCocktailExist(List<Cocktail> cocktailRepository, String name) {
        for (Cocktail cocktail : cocktailRepository) {
            if (cocktail.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = null;

        if (isBoothExist(boothRepository, boothNumber)) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }

        switch (type) {
            case "OpenBooth":
                booth = new OpenBooth(boothNumber, capacity);
                break;
            case "PrivateBooth":
                booth = new PrivateBooth(boothNumber, capacity);
                break;
        }

        boothRepository.add(booth);
        return String.format(BOOTH_ADDED, boothNumber);
    }

    private boolean isBoothExist(List<Booth> boothRepository, int boothNumber) {
        for (Booth booth : boothRepository) {
            if (booth.getBoothNumber() == boothNumber) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth booth = boothRepository.stream()
                .filter(booth1 -> !booth1.isReserved())
                .filter(booth1 -> booth1.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);

        if (booth == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        boothRepository.get(boothRepository.indexOf(booth)).reserve(numberOfPeople);
        return String.format(BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.stream()
                .filter(booth1 -> booth1.getBoothNumber() == boothNumber)
                .findFirst().orElseThrow();
        double bill = booth.getBill();
        totalStoreIncome += bill;
        boothRepository.get(boothRepository.indexOf(booth)).clear();

        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {

        return String.format(TOTAL_INCOME, totalStoreIncome);
    }


}
