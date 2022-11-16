import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String regex = "([#|])(?<food>[A-Za-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> foodList = new ArrayList<>();
        List<String> dateList = new ArrayList<>();
        List<Integer> caloriesList = new ArrayList<>();
        while (matcher.find()) {
            foodList.add(matcher.group("food"));
            dateList.add(matcher.group("date"));
            caloriesList.add(Integer.parseInt(matcher.group("calories")));
        }

        int totalCalories = 0;
        for (int calories : caloriesList) {
            totalCalories += calories;
        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        if (!foodList.isEmpty()) {
            for (int i = 0; i < foodList.size(); i++) {
                System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", foodList.get(i), dateList.get(i), caloriesList.get(i));
            }
        }
    }
}
