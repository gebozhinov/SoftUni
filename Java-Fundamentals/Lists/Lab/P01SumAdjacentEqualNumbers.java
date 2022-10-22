import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Double> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numbersList.size() - 1; i++) {
            double firstIndex = numbersList.get(i);
            double secondIndex = numbersList.get(i + 1);
            if (firstIndex == secondIndex) {
                numbersList.set(i, firstIndex + secondIndex);
                numbersList.remove(i + 1);
                i = -1;
            }
        }

        DecimalFormat df = new DecimalFormat("0.#");
        for (double number : numbersList) {
            System.out.print(df.format(number) + " ");
        }

    }
}
