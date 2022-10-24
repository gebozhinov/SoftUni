import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<String> message = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());
        String secretMessage = "";

        for (Integer integer : numberList) {
            int sumNumbers = sumNumbers(integer);
            if (sumNumbers > message.size()) {
                sumNumbers -= message.size();
            }
            for (int j = 0; j < message.size(); j++) {
                if (sumNumbers == j) {
                    secretMessage += message.get(j);
                    message.remove(j);
                    break;
                }
            }
        }
        System.out.println(secretMessage);
    }

    public static int sumNumbers(int number) {
        int sum = 0;
        while (number > 0) {
            int lastNum = number % 10;
            sum += lastNum;
            number /= 10;

        }
        return sum;
    }
}
