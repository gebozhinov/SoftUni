package streamsFilesAndDirectories.exercises;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resource/input.txt"))){
            String line = bufferedReader.readLine();
            PrintWriter printWriter = new PrintWriter(new FileWriter("src/resource/output.txt"));
            while (line != null) {
                printWriter.println(line.toUpperCase());

                line = bufferedReader.readLine();

            }
        printWriter.close();
        }catch (IOException ignored) {

        }



    }
}
