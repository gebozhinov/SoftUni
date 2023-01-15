package exam.mid.july2020;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        for (Integer num : numbersList) {
            sum += num;
        }

        int numbersCount = 0;
        List<Integer> resultList = new ArrayList<>();
        double average = sum * 1.0 / numbersList.size();
        for (int i = numbersList.size() - 1; i >= 0; i--) {
            int currentNum = numbersList.get(i);
            if (currentNum > average) {
                resultList.add(currentNum);
                numbersCount++;

            }
        }
        if (numbersCount == 0) {
            System.out.println("No");
        } else {
            Collections.sort(resultList, Collections.reverseOrder());
            int min = Math.min(resultList.size(), 5);
            for (int i = 0; i < min; i++) {
                System.out.print(resultList.get(i) + " ");
            }
        }

    }
}
