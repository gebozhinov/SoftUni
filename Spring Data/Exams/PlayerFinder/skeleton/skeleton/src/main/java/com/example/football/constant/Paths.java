package com.example.football.constant;

import java.nio.file.Path;

public enum Paths {
    ;

    public static final Path IMPORT_TOWNS_PATH = Path.of("src/main/resources/files/json/towns.json");
    public static final Path IMPORT_TEAMS_PATH = Path.of("src/main/resources/files/json/teams.json");
    public static final Path IMPORT_STATS_PATH = Path.of("src/main/resources/files/xml/stats.xml");
    public static final Path IMPORT_PLAYERS_PATH = Path.of("src/main/resources/files/xml/players.xml");
}
