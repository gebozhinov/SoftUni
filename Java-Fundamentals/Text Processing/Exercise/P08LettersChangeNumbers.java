import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;
        for (String s : input) {

            double number = getNumberModifier(s);
            sum += number;
        }
        System.out.printf("%.2f",sum);

    }

    private static double getNumberModifier(String s) {
        char firstLetter = s.charAt(0);
        char secondLetter = s.charAt(s.length() - 1);
        double number = Double.parseDouble(s.replace(firstLetter, ' ')
                .replace(secondLetter, ' ').trim());
        if (Character.isUpperCase(firstLetter)) {
            number /= firstLetter - 64;
        } else {
            number *= firstLetter - 96;
        }
        if (Character.isUpperCase(secondLetter)) {
            number -= secondLetter - 64;
        } else {
            number += secondLetter - 96;
        }
        return number;
    }
}
