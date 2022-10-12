import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputLine = scanner.nextLine().split(" ");

        int[] numbers = new int[inputLine.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputLine[i]);
        }
        int maxNum = Arrays.stream(numbers).max().getAsInt();

        String finalList = "";
        boolean maxNumFound = false;
        for (int i = 0; i < inputLine.length; i++) {
            int currentInt = numbers[i];
            for (int j = i; j < inputLine.length - 1; j++) {
                int nextInt = numbers[j + 1];
                if (maxNum == currentInt) {
                    maxNumFound = true;
                    finalList += maxNum + " ";
                    break;
                }
                if (maxNumFound) {
                    if (currentInt > nextInt) {
                        finalList += currentInt + " ";
                        break;
                    }
                }


            }
        }
        System.out.println(finalList + inputLine[inputLine.length - 1]);
    }
}
