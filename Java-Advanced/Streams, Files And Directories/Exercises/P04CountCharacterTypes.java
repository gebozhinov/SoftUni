package streamsFilesAndDirectories.exercises;

import java.io.*;

public class P04CountCharacterTypes {
    public static void main(String[] args) {

        int vowels = 0;
        int punctuation = 0;
        int others = 0;
        try (FileReader fr = new FileReader("src/resource/input.txt");
             PrintWriter pw = new PrintWriter(new FileWriter("src/resource/output.txt"))) {
            int firstSymbol = fr.read();
            while (firstSymbol != -1) {
                char symbolAsChar = (char) firstSymbol;
                if (isVowel(symbolAsChar)) {
                    vowels++;
                } else if (isPunctuation(symbolAsChar)) {
                    punctuation++;
                } else if (!Character.isWhitespace(symbolAsChar)) {
                    others++;
                }
                firstSymbol = fr.read();
            }
            pw.println("Vowels: " + vowels);
            pw.println("Other symbols: " + others);
            pw.println("Punctuation: " + punctuation);

        } catch (IOException ignored) {
        }


    }

    private static boolean isPunctuation(char symbolAsChar) {
        return symbolAsChar == '!' || symbolAsChar == ',' || symbolAsChar == '.' || symbolAsChar == '?';
    }

    private static boolean isVowel(char symbolAsChar) {
        return symbolAsChar == 'a' || symbolAsChar == 'e' || symbolAsChar == 'i' || symbolAsChar == 'o' || symbolAsChar == 'u';
    }
}
