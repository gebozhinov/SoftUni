package streamsFilesAndDirectories.lab;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) {

        try {
            FileInputStream inputStream = new FileInputStream("input.txt");
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.next());
                } else {
                    scanner.next();

                }
            }
            writer.close();
        } catch (IOException ignored) {

        }

    }
}
