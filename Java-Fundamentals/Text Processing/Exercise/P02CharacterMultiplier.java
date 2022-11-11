import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String firstWord = input.split(" ")[0];
        String secondWord = input.split(" ")[1];

        int shorterWord = Math.min(firstWord.length(), secondWord.length());
        int sum = 0;
        for (int i = 0; i < shorterWord; i++) {
            char l1 = firstWord.charAt(i);
            char l2 = secondWord.charAt(i);
            sum += l1 * l2;
        }

        int longerWord = Math.max(firstWord.length(), secondWord.length());
        for (int i = shorterWord; i < longerWord; i++) {
            if (firstWord.length() > secondWord.length()) {
                sum += firstWord.charAt(i);
            } else {
                sum += secondWord.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
