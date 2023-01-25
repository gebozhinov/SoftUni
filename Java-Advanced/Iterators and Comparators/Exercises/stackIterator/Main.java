package iteratorsAndComparators.exercises.stackIterator;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack customStack = null;
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandParts = input.split(", ");
            String command = commandParts[0].split(" ")[0];
            switch (command) {
                case "Push":
                    Integer[] arr = getArr(commandParts);
                    if (arr.length > 1) {
                        customStack = new CustomStack(arr);
                    } else {
                        customStack.push(arr[0]);
                    }
                    break;
                case "Pop":
                    try {
                        customStack.pop();
                    } catch (EmptyStackException e) {
                        System.out.println("No elements");
                    }
                    break;
            }


            input = scanner.nextLine();
        }


        for (Integer num : customStack) {
            System.out.println(num);
        }
        for (Integer num : customStack) {
            System.out.println(num);
        }
    }

    public static Integer[] getArr(String[] strArr) {
        Integer[] arr = new Integer[strArr.length];
        int num = Integer.parseInt(strArr[0].split(" ")[1]);
        arr[0] = num;
        for (int i = 1; i < strArr.length; i++) {
            int current = Integer.parseInt(strArr[i]);
            arr[i] = current;
        }
        return arr;
    }

}
