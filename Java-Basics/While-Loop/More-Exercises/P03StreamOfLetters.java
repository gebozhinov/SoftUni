import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean codeC = false;
        boolean codeO = false;
        boolean codeN = false;
        String letters = "";
        String codeWord = "";
        while (!input.equals("End")) {
            char symbol = input.charAt(0);
            if ((symbol >= 65 && symbol <= 90) || (symbol >= 97 && symbol <= 122)) {
                if (symbol == 99) {
                    if (codeC) {
                        letters += symbol;
                    }
                    codeC = true;
                } else if (symbol == 111) {
                    if (codeO) {
                        letters += symbol;
                    }
                    codeO = true;
                } else if (symbol == 110) {
                    if (codeN) {
                        letters += symbol;
                    }
                    codeN = true;
                } else {
                    letters += symbol;
                }
                if (codeC && codeO && codeN) {
                    codeWord += letters + " ";
                    letters = "";
                    codeC = false;
                    codeO = false;
                    codeN = false;
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(codeWord);
    }
}
