package definingClasses.exercises.pokemonTrainer;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Trainer> trainerMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String trainerName = input.split(" ")[0];
            String pokemonName = input.split(" ")[1];
            String pokemonElement = input.split(" ")[2];
            int pokemonHealth = Integer.parseInt(input.split(" ")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName, pokemon);
            if (trainerMap.containsKey(trainerName)) {
                trainerMap.get(trainerName).addPokemon(pokemon);
            } else {
                trainerMap.put(trainerName, trainer);
            }

            input = scanner.nextLine();
        }

        String element = scanner.nextLine();
        while (!element.equals("End")) {
            String currentElement = element;


            boolean flag;
            for (var entry : trainerMap.entrySet()) {
                flag = entry.getValue().getPokemonList().stream().anyMatch(pokemon -> {
                    String pokemonElement = pokemon.getElement();
                    return pokemonElement.equals(currentElement);
                });
                if (flag) {
                    entry.getValue().updateBadges();
                } else {
                    entry.getValue().getPokemonList().forEach(Pokemon::updateHealth);
                }

                for (Pokemon pokemon : entry.getValue().getPokemonList()) {
                    if (pokemon.getHealth() <= 0) {
                        entry.getValue().removePokemon(pokemon);
                        break;
                    }
                }


            }
            element = scanner.nextLine();
        }

        List<Trainer> finalList = new ArrayList<>();
        for (var entry : trainerMap.entrySet()) {
            finalList.add(entry.getValue());
        }

        finalList.stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(System.out::println);


    }
}
