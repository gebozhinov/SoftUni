package iteratorsAndComparators.exercises.linkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomLinkedList customLinkedList = new CustomLinkedList();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            int number = Integer.parseInt(input[1]);
            switch (command) {
                case "Add":
                    customLinkedList.add(number);
                    break;
                case "Remove":
                    customLinkedList.remove(number);
                    break;
            }
        }

        System.out.println(customLinkedList.getSize());
        for (Integer integer : customLinkedList) {
            System.out.print(integer + " ");
        }
    }
}
