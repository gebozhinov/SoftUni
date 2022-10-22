import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input will be one line of integers separated by space
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        // Second line of input will be different commands
        // While command is not "end" do something
        String inputCommand = scanner.nextLine();
        while (!inputCommand.equals("end")) {
            List<String> getCommand = List.of(inputCommand.split(" "));
            // The first element of the list will always be a command
            switch (getCommand.get(0)) {
                case "Contains":
                    // if first element is command "Contains", check if the second index is in the numberList
                    int number = Integer.parseInt(getCommand.get(1));
                    checkIfTheNumberIsInTheList(numbersList, number);
                    break;
                case "Print":
                    switch (getCommand.get(1)) {
                        case "even":
                            printEvenOrOddNumbers(numbersList, "even");
                            break;
                        case "odd":
                            printEvenOrOddNumbers(numbersList, "odd");
                            break;
                    }
                    break;
                case "Get":
                    // "Get sum": print the sum of all numbers in the list
                    printSumOfAllNumbers(numbersList);
                    break;
                case "Filter":
                    // Print all the numbers that fulfill that condition.
                    // The condition will be either '<', '>', ">=", "<="
                    String condition = getCommand.get(1);
                    int fulfillNumber = Integer.parseInt(getCommand.get(2));
                    printAllTheNumbers(numbersList, condition, fulfillNumber);
                    break;
            }

            inputCommand = scanner.nextLine();
        }

    }

    public static void checkIfTheNumberIsInTheList(List<Integer> numberList, int number) {
        for (Integer integer : numberList) {
            if (integer == number) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No such number");
    }

    public static void printEvenOrOddNumbers(List<Integer> numbersList, String evenOrOdd) {
        // depending on the command, print even or odd numbers
        for (Integer integer : numbersList) {
            if (evenOrOdd.equals("even")) {
                if (integer % 2 == 0) {
                    System.out.print(integer + " ");
                }
            } else {
                if (integer % 2 != 0) {
                    System.out.print(integer + " ");
                }
            }
        }
        System.out.println();

    }

    public static void printSumOfAllNumbers(List<Integer> numberList) {
        int sum = 0;
        for (int num : numberList) {
            sum += num;
        }
        System.out.println(sum);
    }
    
    public static void printAllTheNumbers(List<Integer> numberList, String condition, int fulfillNumber) {
        // Print all the numbers based on specific condition
        for (int number : numberList) {
            switch (condition) {
                case "<":
                    if (number < fulfillNumber) {
                        System.out.print(number + " ");
                    }
                    break;
                case ">":
                    if (number > fulfillNumber) {
                        System.out.print(number + " ");
                    }
                    break;
                case ">=":
                    if (number >= fulfillNumber) {
                        System.out.print(number + " ");
                    }
                    break;
                case "<=":
                    if (number <= fulfillNumber) {
                        System.out.print(number + " ");
                    }
                    break;
            }
        }
        System.out.println();
    }
}
