import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\\\");
        String pathOfFile = input[input.length - 1];
        String fileName = pathOfFile.split("\\.")[0];
        String extension = pathOfFile.split("\\.")[1];

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s%n", extension);


    }
}
