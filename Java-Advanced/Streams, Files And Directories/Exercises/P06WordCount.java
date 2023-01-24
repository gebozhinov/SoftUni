package streamsFilesAndDirectories.exercises;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06WordCount {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileReader("src/resource/words.txt"));
             Scanner scan = new Scanner(new FileReader("src/resource/text.txt"));
             PrintWriter pw = new PrintWriter("src/resource/result.txt")) {
            LinkedHashMap<String, Integer> wordsMap = new LinkedHashMap<>();
            Arrays.stream(scanner.nextLine().split(" ")).forEach(word -> wordsMap.put(word, 0));
            while (scan.hasNext()) {
                String word = scan.next();
                if (wordsMap.containsKey(word)) {
                    int currentCount = wordsMap.get(word);
                    currentCount++;
                    wordsMap.put(word, currentCount);
                }
            }
            wordsMap.forEach((key, value) -> pw.println(key + " - " + value));


        } catch (IOException ignored) {

        }


    }
}
