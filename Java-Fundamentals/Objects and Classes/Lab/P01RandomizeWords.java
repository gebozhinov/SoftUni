import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> words = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        Random random = new Random();
        while (!words.isEmpty()) {

            int index = random.nextInt(words.size());
            System.out.println(words.get(index));
            words.remove(index);
        }

    }
}
