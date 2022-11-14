import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] tickets = scanner.nextLine().trim().split("\\s*,\\s*");
        String validRegex = ".{20}";
        String winnerSymbolRegex = "[$@#^]";
        Pattern validPatter = Pattern.compile(validRegex);
        Pattern winnerSymbolPattern = Pattern.compile(winnerSymbolRegex);

        for (int i = 0; i < tickets.length; i++) {
            String currentTicket = tickets[i];
            if (currentTicket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            Matcher validMatcher = validPatter.matcher(currentTicket);
            Matcher winnerMatcher = winnerSymbolPattern.matcher(currentTicket);
            while (validMatcher.find()) {
                String validTicket = validMatcher.group();
                String winnerSymbol = "";
                while (winnerMatcher.find()) {
                    winnerSymbol = winnerMatcher.group();
                    break;
                }
                String countRegex = "[$]{6,10}|@{6,10}|#{6,10}|\\^{6,10}";
                Pattern countPattern = Pattern.compile(countRegex);
                String leftPart = validTicket.substring(0, validTicket.length() / 2);
                String rightPart = validTicket.substring(validTicket.length() / 2);
                Matcher countMatcherLeft = countPattern.matcher(leftPart);
                Matcher countMatcherRight = countPattern.matcher(rightPart);
                int countLeft = 0;
                int countRight = 0;
                while (countMatcherLeft.find() && countMatcherRight.find()) {
                    countLeft = countMatcherLeft.group().length();
                    countRight = countMatcherRight.group().length();
                }

                if (Math.min(countLeft, countRight) == 10) {
                    System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", validTicket, Math.min(countLeft, countRight), winnerSymbol);
                } else if (Math.min(countLeft, countRight) >= 6) {
                    System.out.printf("ticket \"%s\" - %d%s%n", validTicket, Math.min(countLeft, countRight), winnerSymbol);
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", validTicket);
                }
            }
        }


    }
}
