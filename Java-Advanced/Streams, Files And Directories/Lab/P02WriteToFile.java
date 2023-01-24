package streamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) {


        try {
            FileInputStream fileInputStream = new FileInputStream("input.txt");
            FileOutputStream outputStream = new FileOutputStream("output.txt");

            int read = fileInputStream.read();
            Set<Character> punctuations = Set.of(',', '.', '!', '?');
            while (read != -1) {
                if (!punctuations.contains((char) read)) {
                    outputStream.write(read);
                }
                read = fileInputStream.read();
            }

        } catch (IOException ignored) {

        }


    }
}
