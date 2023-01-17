package setsAndMapsAdvanced.exercises.stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        ArrayDeque<Character> parenthesesDeck = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char parentheses = input.charAt(i);
            if (parentheses == '(' || parentheses == '{' || parentheses == '[') {
                parenthesesDeck.push(parentheses);
            } else {
                if (parenthesesDeck.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastParentheses = parenthesesDeck.pop();
                if (parentheses == ')' && lastParentheses != '(') {
                    isBalanced = false;
                } else if (parentheses == '}' && lastParentheses != '{') {
                    isBalanced = false;
                } else if (parentheses == ']' && lastParentheses != '[') {
                    isBalanced = false;
                }
            }
            if (!isBalanced) {
                break;
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
