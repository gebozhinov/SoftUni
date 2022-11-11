import java.util.*;
import java.util.stream.Collectors;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Map<String, Integer>> contestMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("no more time")) {
            String username = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);
            if (contestMap.containsKey(contest)) {
                if (contestMap.get(contest).containsKey(username)) {
                    int currentPoints = contestMap.get(contest).get(username);
                    if (points > currentPoints) {
                        contestMap.get(contest).put(username, points);
                    }
                } else {
                    contestMap.get(contest).put(username, points);
                }
            } else {
                contestMap.put(contest, new TreeMap<>());
                contestMap.get(contest).put(username, points);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> contest : contestMap.entrySet()) {
            System.out.println(contest.getKey() + ": " + contest.getValue().size() + " participants");
            Map<String, Integer> userPoints = contest.getValue().entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                            , (e1, e2) -> e1, LinkedHashMap::new));
            int counter = 1;
            for (Map.Entry<String, Integer> entry : userPoints.entrySet()) {
                System.out.printf("%d. %s <::> %d%n", counter, entry.getKey(), entry.getValue());
                counter++;
            }
        }


        Map<String, Integer> userTotalPoints = new TreeMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : contestMap.entrySet()) {
            for (Map.Entry<String, Integer> user : entry.getValue().entrySet()) {
                if (userTotalPoints.containsKey(user.getKey())) {
                    int currentPoints = userTotalPoints.get(user.getKey());
                    userTotalPoints.put(user.getKey(), user.getValue() + currentPoints);
                } else {
                    userTotalPoints.put(user.getKey(), user.getValue());
                }
            }
        }
        System.out.println("Individual standings:");
        Map<String, Integer> sortUserTotalPoints = userTotalPoints.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (e1, e2) -> e1, LinkedHashMap::new));
        int counter = 1;
        for (Map.Entry<String, Integer> entry : sortUserTotalPoints.entrySet()) {
            System.out.printf("%d. %s -> %d%n", counter, entry.getKey(), entry.getValue());
            counter++;
        }


    }
}
