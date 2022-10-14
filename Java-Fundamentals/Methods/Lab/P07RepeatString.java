import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repeatTimes = Integer.parseInt(scanner.nextLine());

        String result = repeatString(input, repeatTimes);
        System.out.println(result);

    }

    public static String repeatString(String textToRepeat, int repeatTimes) {
        String result = "";
        for (int i = 0; i < repeatTimes; i++) {
            result += textToRepeat;
        }
        return result;
    }
}
