package exam.mid.april2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input.split(" ")[0];
            int index = Integer.parseInt(input.split(" ")[1]);
            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(input.split(" ")[2]);
                    if (index < numberList.size() && index >= 0) {
                        numberList.set(index, numberList.get(index) - power);
                        if (numberList.get(index) <= 0) {
                            numberList.remove(index);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(input.split(" ")[2]);
                    if (index < 0 || index >= numberList.size()) {
                        System.out.println("Invalid placement!");
                    } else {
                        numberList.add(index, value);
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(input.split(" ")[2]);
                    boolean isIndexValid = index >= 0 && index < numberList.size();
                    boolean isRadiusValid = index - radius >= 0 && index - radius < numberList.size();
                    if (isIndexValid && isRadiusValid) {
                        numberList.subList(index - radius, index + radius + 1).clear();


                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numberList.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", "|")
                .replace(" ", ""));
    }
}
