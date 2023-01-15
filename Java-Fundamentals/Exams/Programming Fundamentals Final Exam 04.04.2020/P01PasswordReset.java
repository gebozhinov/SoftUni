package exam.finale.april2020;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder password = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String command = input.split(" ")[0];
            switch (command) {
                case "TakeOdd":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            sb.append(password.charAt(i));
                        }
                    }
                    password.delete(0, password.length());
                    password.append(sb);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    int length = Integer.parseInt(input.split(" ")[2]);
                    password.replace(index, index + length, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = input.split(" ")[1];
                    String substitute = input.split(" ")[2];
                    if (password.toString().contains(substring)) {
                        int i = password.indexOf(substring);
                        while (i != -1) {
                            password.replace(i, i + substring.length(), substitute);
                            i += substring.length();
                            i = password.indexOf(substring, i);
                        }
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.printf("Your password is: %s", password);
    }
}
