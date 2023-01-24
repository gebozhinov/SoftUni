package streamsFilesAndDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resource/input.txt"))){
            String line = bufferedReader.readLine();
            int sum = 0;
            while (line != null) {
                char[] symbol = line.toCharArray();
                for (char currentSymbol : symbol) {
                    sum += currentSymbol;
                }

                line = bufferedReader.readLine();
            }
            System.out.println(sum);

        } catch (IOException ignored) {
        }

    }
}
