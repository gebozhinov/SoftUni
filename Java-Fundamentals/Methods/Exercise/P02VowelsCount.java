import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        vowelsCount(input);

    }
    public static void vowelsCount(String word) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (vowels.indexOf(letter) != -1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
