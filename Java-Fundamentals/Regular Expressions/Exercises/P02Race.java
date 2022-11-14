import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participantsList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        Map<String, Integer> participants = new LinkedHashMap<>();
        participantsList.forEach(name -> participants.put(name, 0));

        String nameRegex = "[A-Za-z]+";
        Pattern patternName = Pattern.compile(nameRegex);
        String distanceRegex = "\\d";
        Pattern patternDistance = Pattern.compile(distanceRegex);
        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            Matcher matcherName = patternName.matcher(input);
            StringBuilder name = new StringBuilder();
            while (matcherName.find()) {
                name.append(matcherName.group());
            }

            if (participants.containsKey(name.toString())) {
                Matcher matcherDistance = patternDistance.matcher(input);
                int distance = 0;
                while (matcherDistance.find()) {
                    distance += Integer.parseInt(matcherDistance.group());
                }
                int currentDistance = participants.get(name.toString());
                participants.put(name.toString(), currentDistance + distance);
            }


            input = scanner.nextLine();
        }

        List<String> firstThree = participants.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3).map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));


    }
}
