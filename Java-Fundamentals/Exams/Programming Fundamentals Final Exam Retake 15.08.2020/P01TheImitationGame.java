import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String command = input.split("\\|")[0];
            switch (command) {
                case "Move":
                    int number = Integer.parseInt(input.split("\\|")[1]);
                    String moveLetter = message.substring(0, number);
                    message.replace(0, number, "");
                    message.append(moveLetter);
                    break;
                case "Insert":
                    int index = Integer.parseInt(input.split("\\|")[1]);
                    String value = input.split("\\|")[2];
                    message.insert(index, value);
                    break;
                case "ChangeAll":
                    String changeStr = input.split("\\|")[1];
                    String replacement = input.split("\\|")[2];
                    for (int i = 0; i < message.length(); i++) {
                        char currentStr = message.charAt(i);
                        if (String.valueOf(currentStr).equals(changeStr)) {
                            message.replace(i, i + 1, replacement);
                        }
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", message);

    }
}
