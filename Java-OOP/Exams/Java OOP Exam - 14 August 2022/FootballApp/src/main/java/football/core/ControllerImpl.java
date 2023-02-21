package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }


    @Override
    public String addField(String fieldType, String fieldName) {
        Field field = null;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement currentSupplement;
        switch (type) {
            case "Powdered":
                currentSupplement = new Powdered();
                break;
            case "Liquid":
                currentSupplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplement.add(currentSupplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement currentSupplement = supplement.findByType(supplementType);
        if (currentSupplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        fields.stream().filter(e -> e.getName().equals(fieldName))
                .forEach(e -> e.addSupplement(currentSupplement));
        supplement.remove(currentSupplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        if ((playerType.equals("Men") && fieldName.equals("ArtificialTurf")) ||
                playerType.equals("Women") && fieldName.equals("NaturalGrass")) {
            return FIELD_NOT_SUITABLE;
        }

        Player finalPlayer = player;
        fields.stream().filter(e -> e.getName().equals(fieldName))
                .forEach(e -> e.addPlayer(finalPlayer));
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getFieldByName(fieldName);
        for (Player p : field.getPlayers()) {
            p.stimulation();
        }
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }
    private Field getFieldByName(String fieldName) {
        return fields.stream()
                .filter(f -> f.getName().equals(fieldName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String calculateStrength(String fieldName) {
        List<Field> field = fields.stream().filter(f -> f.getName().equals(fieldName))
                .collect(Collectors.toList());
        List<Player> players = new ArrayList<>(field.get(0).getPlayers());
        int strengthSum = players.stream().mapToInt(Player::getStrength).sum();
        return String.format(STRENGTH_FIELD, fieldName, strengthSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            sb.append(field.getInfo());
        }
        return sb.toString().trim();
    }
}
