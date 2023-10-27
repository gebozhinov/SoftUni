package bg.softuni.Pathfinder.model.enums;

import java.util.Map;
import java.util.logging.Level;

public enum UserLevel {

    BEGINNER,
    INTERMEDIATE,
    ADVANCED;

    public static final Map<String, UserLevel> levelMap = Map.of(
            "BEGINNER", BEGINNER,
            "INTERMEDIATE", INTERMEDIATE,
            "ADVANCED", ADVANCED);
}
