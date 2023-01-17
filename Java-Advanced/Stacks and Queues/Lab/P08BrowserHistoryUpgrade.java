package setsAndMapsAdvanced.exercises.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        ArrayDeque<String> backHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (backHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.addFirst(backHistory.pop());
                    System.out.println(backHistory.peek());
                }
                input = scanner.nextLine();
                continue;
            } else if (input.equals("forward")) {
                if (forwardHistory.size() == 0) {
                    System.out.println("no next URLs");
                } else {
                    String currentSite = forwardHistory.poll();
                    backHistory.push(currentSite);
                    System.out.println(currentSite);
                }
                input = scanner.nextLine();
                continue;
            }
            forwardHistory.clear();
            backHistory.push(input);
            System.out.println(backHistory.peek());
            input = scanner.nextLine();
        }

    }
}
