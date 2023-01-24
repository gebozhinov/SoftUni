package streamsFilesAndDirectories.lab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

            String line = bufferedReader.readLine();
            int counter = 1;
            while (line != null) {
                if (counter % 3 == 0) {
                    writer.println(line);
                }
                counter++;


                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            writer.close();

        } catch (IOException ignored) {

        }
    }
}
