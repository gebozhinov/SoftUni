package streamsFilesAndDirectories.exercises;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/resource/inputLineNumbers.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/resource/output.txt"))) {
            String line = br.readLine();
            int lineNumber = 1;
            while (line != null) {
                bw.write(lineNumber + ". " + line);
                bw.newLine();
                lineNumber++;
                line = br.readLine();
            }

        } catch (IOException ignored) {
        }


    }
}
