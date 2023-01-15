package exam.mid.july2020;

import java.util.Arrays;
import java.util.Scanner;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String command = input.split(" ")[0];
            switch (command) {
                case "swap":
                    int index1 = Integer.parseInt(input.split(" ")[1]);
                    int index2 = Integer.parseInt(input.split(" ")[2]);
                    int firstNum = numbersArr[index1];
                    int secondNum = numbersArr[index2];
                    numbersArr[index2] = firstNum;
                    numbersArr[index1] = secondNum;
                    break;
                case "multiply":
                    int multiplyIndex1 = Integer.parseInt(input.split(" ")[1]);
                    int multiplyIndex2 = Integer.parseInt(input.split(" ")[2]);
                    int result = numbersArr[multiplyIndex1] * numbersArr[multiplyIndex2];
                    numbersArr[multiplyIndex1] = result;
                    break;
                case "decrease":
                    for (int i = 0; i < numbersArr.length; i++) {
                        numbersArr[i] -= 1;
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numbersArr)
                .replace("[", "")
                .replace("]", ""));

    }
}
