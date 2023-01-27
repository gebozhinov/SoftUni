package exam.february2022;

import java.util.*;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] vowels = scanner.nextLine().split(" ");
        ArrayDeque<Character> vowelsCollection = new ArrayDeque<>();
        for (int i = 0; i < vowels.length; i++) {
            char current = vowels[i].charAt(0);
            vowelsCollection.offer(current);
        }

        String[] consonants = scanner.nextLine().split(" ");
        ArrayDeque<Character> consonantsCollection = new ArrayDeque<>();
        for (int i = 0; i < consonants.length; i++) {
            char current = consonants[i].charAt(0);
            consonantsCollection.push(current);
        }

        Map<String, List<Character>> words = new LinkedHashMap<>();
        words.put("pear", new ArrayList<>());
        words.put("flour", new ArrayList<>());
        words.put("pork", new ArrayList<>());
        words.put("olive", new ArrayList<>());
        while (!consonantsCollection.isEmpty()) {
            char currentVowel = vowelsCollection.poll();
            char currentConsonants = consonantsCollection.pop();

            if ("pear".contains(String.valueOf(currentVowel))) {
                updateMap("pear", currentVowel, words);
            }
            if ("flour".contains(String.valueOf(currentVowel))) {
                updateMap("flour", currentVowel, words);
            }
            if ("pork".contains(String.valueOf(currentVowel))) {
                updateMap("pork", currentVowel, words);
            }
            if ("olive".contains(String.valueOf(currentVowel))) {
                updateMap("olive", currentVowel, words);
            }
            if ("pear".contains(String.valueOf(currentConsonants))) {
                updateMap("pear", currentConsonants, words);
            }
            if ("flour".contains(String.valueOf(currentConsonants))) {
                updateMap("flour", currentConsonants, words);
            }
            if ("pork".contains(String.valueOf(currentConsonants))) {
                updateMap("pork", currentConsonants, words);
            }
            if ("olive".contains(String.valueOf(currentConsonants))) {
                updateMap("olive", currentConsonants, words);
            }

            vowelsCollection.offer(currentVowel);
        }

        int wordsFound = (int) words.entrySet().stream().filter(e -> e.getKey().length() == e.getValue().size())
                        .count();

        System.out.printf("Words found: %d%n", wordsFound);

        words.entrySet().stream().filter(e -> e.getKey().length() == e.getValue().size())
                        .forEach(e -> System.out.println(e.getKey()));

    }


    public static Map<String, List<Character>> updateMap(String word, Character symbol, Map<String, List<Character>> map) {
        if (!map.get(word).contains(symbol)) {
            map.get(word).add(symbol);

        }
        return map;
    }
}
