import java.util.Scanner;

public class TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        int mostPowerfulWordPoints = 0;
        String mostPowerfulWord = "";
        while (!word.equals("End of words")) {
            boolean flag = false;
            int currentWordPoints = 0;
            for (int i = 0; i < word.length(); i++) {
                int currentLetter = word.charAt(i);
                currentWordPoints += currentLetter;
                switch (word.charAt(0)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'y':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        flag = true;
                        break;
                }
            }
            if (flag) {
                currentWordPoints *= word.length();
            } else {
                currentWordPoints = (int) Math.floor(currentWordPoints * 1.0 / word.length());
            }
            if (currentWordPoints >= mostPowerfulWordPoints) {
                mostPowerfulWordPoints = currentWordPoints;
                mostPowerfulWord = word;
            }
            word = scanner.nextLine();
        }
        System.out.printf("The most powerful word is %s - %d", mostPowerfulWord, mostPowerfulWordPoints);
    }
}
