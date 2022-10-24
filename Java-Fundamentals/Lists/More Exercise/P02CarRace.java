import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        double firstCar = 0;
        double secondCar = 0;
        for (int i = 0; i < numberList.size() / 2; i++) {
            if (numberList.get(i) == 0) {
                firstCar *= 0.8;
            } else {
                firstCar += numberList.get(i);
            }
        }
        for (int i = numberList.size() - 1; i > numberList.size() / 2; i--) {
            if (numberList.get(i) == 0) {
                secondCar *= 0.8;
            } else {
                secondCar += numberList.get(i);
            }
        }

        if (firstCar < secondCar) {
            System.out.printf("The winner is left with total time: %.1f", firstCar);
        } else {
            System.out.printf("The winner is right with total time: %.1f", secondCar);
        }

    }
}
