import java.util.*;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String specialNumbers = scanner.nextLine();
        int bombNumber = Integer.parseInt(specialNumbers.split(" ")[0]);
        int powerNumber = Integer.parseInt(specialNumbers.split(" ")[1]);

        for (int i = 0; i < numberList.size(); i++) {
            if (numberList.get(i) == bombNumber) {
                numberList.set(i, 0);
                for (int j = 0; j < powerNumber; j++) {
                    if (i - 1 - j >= 0) {
                            numberList.set(i - 1 - j, 0);
                    }
                    if (i + 1 + j <= numberList.size()- 1) {
                        numberList.set(i + 1 + j, 0);
                    }
                }
            }
        }
        int sum = 0;
        for (int number : numberList) {
            sum += number;
        }
        System.out.println(sum);
    }
}
