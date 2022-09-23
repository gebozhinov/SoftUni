import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String start = scanner.nextLine();
        String end = scanner.nextLine();
        String skip = scanner.nextLine();
        int counter = 0;
        for (int i = start.charAt(0); i <= end.charAt(0); i++) {
            for (int j = start.charAt(0); j <= end.charAt(0); j++) {
                for (int k = start.charAt(0); k <= end.charAt(0); k++) {
                    if (i != skip.charAt(0) && j != skip.charAt(0) && k != skip.charAt(0)) {
                        counter++;
                        System.out.printf("%s%s%s ", Character.toString(i), Character.toString(j), Character.toString(k));
                    }
                }
            }
        }
        System.out.println(counter);
    }
}

