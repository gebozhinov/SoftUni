package magicGame.core;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Collection;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.*;
import static magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGIC;
import static magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN;

public class ControllerImpl implements Controller {

    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic;
        switch (type) {
            case "RedMagic":
                magic = new RedMagic(name, bulletsCount);
                magics.addMagic(magic);
                break;
            case "BlackMagic":
                magic = new BlackMagic(name, bulletsCount);
                magics.addMagic(magic);
                break;
            default:
                throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magician magician;
        Magic magic = magics.findByName(magicName);
        if (magic == null) {
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }
        switch (type) {
            case "Wizard":
                magician = new Wizard(username, health, protection, magic);
                magicians.addMagician(magician);
                break;
            case "BlackWidow":
                magician = new BlackWidow(username, health, protection, magic);
                magicians.addMagician(magician);
                break;
            default:
                throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
//        Collection<Magician> aliveMagicians = magicians.getData().stream()
//                .filter(Magician::isAlive)
//                .collect(Collectors.toList());
        return region.start(magicians.getData());
    }

    @Override
    public String report() {
        List<Magician> printMagicians = magicians.getData()
                .stream()
                .sorted(Comparator.comparing(Magician::getHealth).reversed())
                .sorted(Comparator.comparing(Magician::getUsername))
                .sorted(Comparator.comparing(magician -> magician.getClass().getSimpleName()))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Magician magician : printMagicians) {
            sb.append(magician.getClass().getSimpleName())
                    .append(": ")
                    .append(magician.getUsername())
                    .append(System.lineSeparator())
                    .append("Health: ")
                    .append(magician.getHealth() >= 0 ? magician.getHealth() : "0")
                    .append(System.lineSeparator())
                    .append("Protection: ")
                    .append(magician.getProtection() >= 0 ? magician.getProtection() : "0")
                    .append(System.lineSeparator())
                    .append("Magic: ")
                    .append(magician.getMagic().getName())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
