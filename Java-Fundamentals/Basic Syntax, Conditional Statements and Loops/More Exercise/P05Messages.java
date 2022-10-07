import java.util.Scanner;

public class P05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String massage = "";
        for (int i = 0; i < input; i++) {
            String digit = scanner.nextLine();
            int asciiCode = 0;
            for (int j = 0; j < digit.length(); j++) {
                char mainChar = digit.charAt(0);
                String firstString = String.valueOf(mainChar);
                int mainDigit = Integer.parseInt(firstString);
                int offsetNumber = (mainDigit - 2) * 3;
                if (mainDigit == 8 || mainDigit == 9) {
                    offsetNumber++;
                }
                int letterIndex = offsetNumber + digit.length() - 1;
                if (letterIndex == -6) {
                    asciiCode = 32;
                } else {
                    asciiCode = letterIndex + 97;
                }
            }
            massage += Character.toString(asciiCode);
        }
        System.out.println(massage);

    }
}
