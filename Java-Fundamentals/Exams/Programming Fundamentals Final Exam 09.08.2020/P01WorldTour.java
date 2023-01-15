package exam.finale.august2020;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder tour = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String command = input.split(":")[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(input.split(":")[1]);
                    String str = input.split(":")[2];
                    if (index >= 0 && index <= tour.length()) {
                        tour.insert(index, str);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(input.split(":")[1]);
                    int endIndex = Integer.parseInt(input.split(":")[2]);
                    if ((startIndex >= 0 && endIndex >= 0) && (startIndex < tour.length() && endIndex < tour.length())) {
                        tour.replace(startIndex, endIndex + 1, "");
                    }
                    break;
                case "Switch":
                    String oldString = input.split(":")[1];
                    String newString = input.split(":")[2];
                    replaceAll(tour, oldString, newString);

            }
                System.out.println(tour);

            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", tour);


    }

    public static void replaceAll(StringBuilder builder, String from, String to) {
        int index = builder.indexOf(from);
        while (index != -1) {
            builder.replace(index, index + from.length(), to);
            index += to.length();
            index = builder.indexOf(from, index);
        }
    }
}
