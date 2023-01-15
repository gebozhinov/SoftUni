package exam.finale.april2020;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String command = input.split(":\\|:")[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(input.split(":\\|:")[1]);
                    message.insert(index, " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = input.split(":\\|:")[1];
                    if (message.toString().contains(substring)) {
                        int i = message.indexOf(substring);
                        if (i != -1) {
                            message.delete(i, i + substring.length());
                            message.append(getReversedString(substring));
                            System.out.println(message);
                        }
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String changeThis = input.split(":\\|:")[1];
                    String replacement = input.split(":\\|:")[2];
                    int j = message.indexOf(changeThis);
                    while (j != -1) {
                        message.replace(j, j + changeThis.length(), replacement);
                        j += replacement.length();
                        j = message.indexOf(changeThis, j);
                    }
                    System.out.println(message);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", message);

    }

    public static StringBuilder getReversedString(String textToReversed) {
        StringBuilder result = new StringBuilder();
        for (int i = textToReversed.length() - 1; i >= 0; i--) {
            result.append(textToReversed.charAt(i));
        }
        return result;
    }
}
