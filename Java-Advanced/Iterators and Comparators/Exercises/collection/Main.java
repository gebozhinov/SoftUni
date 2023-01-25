package iteratorsAndComparators.exercises.collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = null;
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandParts = input.split(" ");
            String command = commandParts[0];
            switch (command) {
                case "Create":
                    String[] copy = Arrays.copyOfRange(commandParts, 1, commandParts.length);
                    listyIterator = new ListyIterator(copy);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listyIterator.print());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    for (String s : listyIterator) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
            }


            input = scanner.nextLine();
        }


    }
}
