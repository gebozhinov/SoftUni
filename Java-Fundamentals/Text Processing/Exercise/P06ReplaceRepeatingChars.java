import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        result.append(input.charAt(0));
        for (int i = 1; i < input.toCharArray().length; i++) {
            String letter = "" + input.charAt(i);
            String letterBefore = "" + input.charAt(i - 1);
            if (!letter.equals(letterBefore)) {
                result.append(letter);

            }
        }
        System.out.println(result);

    }

}
