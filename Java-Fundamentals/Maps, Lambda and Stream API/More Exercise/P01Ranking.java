import java.util.*;
import java.util.stream.Collectors;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        Map<String, String> contestMap = new LinkedHashMap<>();
        while (!input.equals("end of contests")) {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contestMap.put(contest, password);


            input = scanner.nextLine();
        }


        Map<String, List<String>> userContest = new LinkedHashMap<>();
        Map<String, List<Integer>> userPoints = new LinkedHashMap<>();
        String submission = scanner.nextLine();
        while (!submission.equals("end of submissions")) {
            String contest = submission.split("=>")[0];
            String password = submission.split("=>")[1];
            String username = submission.split("=>")[2];
            int points = Integer.parseInt(submission.split("=>")[3]);
            if (contestMap.containsKey(contest) && contestMap.get(contest).equals(password)) {
                userContest.putIfAbsent(username, new ArrayList<>());
                userPoints.putIfAbsent(username, new ArrayList<>());
                if (!userContest.get(username).contains(contest)) {
                    userContest.get(username).add(contest);
                    userPoints.get(username).add(points);
                } else {
                    int currentPoints = userPoints.get(username).get(userContest.get(username).indexOf(contest));
                    if (points > currentPoints) {
                        userPoints.get(username).set(userContest.get(username).indexOf(contest), points);
                    }
                }


            }
            submission = scanner.nextLine();
        }
        String user = getTheUserWithMostPoints(userPoints).split(" ")[0];
        int points = Integer.parseInt(getTheUserWithMostPoints(userPoints).split(" ")[1]);
        System.out.printf("Best candidate is %s with total %d points.%n", user, points);
        System.out.println("Ranking: ");


        Map<String, List<String>> sortedUsers = new TreeMap<>(userContest);

        for (Map.Entry<String, List<String>> entry : sortedUsers.entrySet()) {
            System.out.println(entry.getKey());
            Map<String, Integer> unsortedContest = new HashMap<>();
            for (int i = 0; i < entry.getValue().size(); i++) {
                String contest = entry.getValue().get(i);
                int contestPoints = userPoints.get(entry.getKey()).get(i);
                unsortedContest.put(contest, contestPoints);
            }

            Map<String, Integer> sortedContest = unsortedContest.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                            , (e1, e2) -> e1, LinkedHashMap::new));
            sortedContest.forEach((key, value) -> System.out.printf("#  %s -> %d%n", key, value));

        }

    }

    public static String getTheUserWithMostPoints(Map<String, List<Integer>> userPoints) {
        int mostPoints = 0;
        String user = "";

        for (Map.Entry<String, List<Integer>> entry : userPoints.entrySet()) {
            int points = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                points += entry.getValue().get(i);
            }
            if (points > mostPoints) {
                mostPoints = points;
                user = entry.getKey() + " " + mostPoints;
            }
        }
        return user;
    }

}
