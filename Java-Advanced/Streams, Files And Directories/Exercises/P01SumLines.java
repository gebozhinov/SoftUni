package streamsFilesAndDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01SumLines {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resource/input.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                int sum = 0;
                char[] symbols = line.toCharArray();
                    for (char currentSymbol : symbols) {
                    sum += currentSymbol;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }
        } catch (IOException ignored) {
        }
    }
}
