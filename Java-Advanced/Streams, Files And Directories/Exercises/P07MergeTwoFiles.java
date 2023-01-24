package streamsFilesAndDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) {

        try (BufferedReader fileOne = new BufferedReader(new FileReader("src/resource/inputOne.txt"));
             BufferedReader fileTwo = new BufferedReader(new FileReader("src/resource/inputTwo.txt"));
             PrintWriter pw = new PrintWriter("src/resource/result.txt")) {
            List<String> result = new ArrayList<>();
            String line = fileOne.readLine();
            while (line != null) {
                result.add(String.valueOf(line));
                line = fileOne.readLine();
            }

            line = fileTwo.readLine();
            while (line != null) {
                result.add(line);
                line = fileTwo.readLine();
            }
            result.forEach(pw::println);
        } catch (IOException ignored) {

        }


    }
}
