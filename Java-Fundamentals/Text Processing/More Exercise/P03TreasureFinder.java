import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int moveNumber = 0;
        while (!input.equals("find")) {
            StringBuilder treasure = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if (moveNumber >= numbers.length) {
                    moveNumber = 0;
                }
                int getNumber = numbers[moveNumber];
                moveNumber++;
                char symbol = (char) (input.charAt(i) - getNumber);
                treasure.append(symbol);
            }
            moveNumber = 0;
            String treasureRegex = "&\\w+&";
            String coordinatesRegex = "<\\w+>";
            Pattern treasurePattern = Pattern.compile(treasureRegex);
            Pattern coordinatesPattern = Pattern.compile(coordinatesRegex);
            Matcher treasureMatcher = treasurePattern.matcher(treasure);
            Matcher coordinatesMatcher = coordinatesPattern.matcher(treasure);
            StringBuilder treasureType = new StringBuilder();
            while (treasureMatcher.find()) {
                treasureType.append(treasureMatcher.group());
            }
            StringBuilder coordinates = new StringBuilder();
            while (coordinatesMatcher.find()) {
                coordinates.append(coordinatesMatcher.group());
            }
            System.out.printf("Found %s at ", treasureType.substring(1, treasureType.length() - 1));
            System.out.printf("%s", coordinates.substring(1, coordinates.length() - 1));
            System.out.println();
            input = scanner.nextLine();
        }


    }

}
