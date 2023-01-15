package exam.finale.august2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String regex = "([=\\/])(?<location>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> location = new ArrayList<>();
        while (matcher.find()) {
            location.add(matcher.group("location"));
        }

        System.out.println("Destinations: " + String.join(", ", location));
        int points = 0;
        for (String loc : location) {
            points += loc.length();
        }
        System.out.println("Travel Points: " + points);
    }
}
