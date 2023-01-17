package setsAndMapsAdvanced.exercises.stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> undo = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];
            switch (command) {
                case "1":
                    undo.push(text.toString());
                    String appendString = input.split(" ")[1];
                    text.append(appendString);
                    break;
                case "2":
                    undo.push(text.toString());
                    int count = Integer.parseInt(input.split(" ")[1]);
                    text.replace(text.length() - count, text.length(), "");
                    break;
                case "3":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    char getChar = text.charAt(index - 1);
                    System.out.println(getChar);
                    break;
                case "4":
                    text.delete(0, text.length());
                    text.append(undo.pop());
                    break;
            }
        }


    }
}
