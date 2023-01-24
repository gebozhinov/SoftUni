package streamsFilesAndDirectories.lab;

import java.io.File;
import java.util.Arrays;

public class P07ListFiles {
    public static void main(String[] args) {


        File path = new File("C:\\Users\\geboz\\OneDrive\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\" +
                "Files-and-Streams");

        Arrays.stream(path.listFiles())
                .filter(File::isFile)
                .forEach(f -> System.out.println(f.getName() + ": [" + f.length() + "]" ));

    }
}
