package streamsFilesAndDirectories.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) {

        Path inputPath = Path.of("input.txt");

        try {
            List<String> lines = Files.readAllLines(inputPath).stream().sorted()
                    .collect(Collectors.toList());
            Path outputPath = Path.of("outputPath.txt");

            Path write = Files.write(outputPath, lines);
        } catch (IOException ignored) {
        }

    }
}
