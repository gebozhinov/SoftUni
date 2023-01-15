package exam.finale.april2020;

import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder key = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String command = input.split(">>>")[0];
            switch (command) {
                case "Contains":
                    String contains = input.split(">>>")[1];
                    if (key.toString().contains(contains)) {
                        System.out.printf("%s contains %s%n", key, contains);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String side = input.split(">>>")[1];
                    int startIndex = Integer.parseInt(input.split(">>>")[2]);
                    int endIndex = Integer.parseInt(input.split(">>>")[3]);
                    switch (side) {
                        case "Upper":
                            key.replace(startIndex, endIndex, key.substring(startIndex, endIndex).toUpperCase());
                            break;
                        case "Lower":
                            key.replace(startIndex, endIndex, key.substring(startIndex, endIndex).toLowerCase());
                            break;
                    }
                    System.out.println(key);
                    break;
                case "Slice":
                    int start = Integer.parseInt(input.split(">>>")[1]);
                    int end = Integer.parseInt(input.split(">>>")[2]);
                    key.delete(start, end);
                    System.out.println(key);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", key);
    }

}
