import java.util.*;
import java.util.stream.Collectors;

public class P03MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Map<String, Integer>> playersMap = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                String player = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skill = Integer.parseInt(input.split(" -> ")[2]);
                if (playersMap.containsKey(player)) {
                    if (playersMap.get(player).containsKey(position)) {
                        int currentSkill = playersMap.get(player).get(position);
                        if (skill > currentSkill) {
                            playersMap.get(player).put(position, skill);
                        }
                    } else {
                        playersMap.get(player).put(position, skill);
                    }
                } else {
                    playersMap.put(player, new TreeMap<>());
                    playersMap.get(player).put(position, skill);
                }

            } else if (input.contains("vs")) {
                String firstPlayer = input.split(" vs ")[0];
                String secondPlayer = input.split(" vs ")[1];
                if (playersMap.containsKey(firstPlayer) && playersMap.containsKey(secondPlayer)) {
                    boolean isPositionCommon = false;
                    for (Map.Entry<String, Integer> first : playersMap.get(firstPlayer).entrySet()) {
                        for (Map.Entry<String, Integer> second : playersMap.get(secondPlayer).entrySet()) {
                            if (first.getKey().equals(second.getKey())) {
                                isPositionCommon = true;
                                break;
                            }
                        }
                        if (isPositionCommon) {
                            break;
                        }
                    }
                    if (isPositionCommon) {
                        int firstPlayerTotalPoints = getPlayerPoints(playersMap, firstPlayer);
                        int secondPlayerTotalPoints = getPlayerPoints(playersMap, secondPlayer);
                        if (firstPlayerTotalPoints > secondPlayerTotalPoints) {
                            playersMap.remove(secondPlayer);
                        } else if (secondPlayerTotalPoints > firstPlayerTotalPoints) {
                            playersMap.remove(firstPlayer);
                        }
                    }
                }

            }
            input = scanner.nextLine();
        }

        Map<String, Integer> totalPlayerPoints = new HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> player : playersMap.entrySet()) {
            for (Map.Entry<String, Integer> position : playersMap.get(player.getKey()).entrySet()) {
                int points = playersMap.get(player.getKey()).get(position.getKey());
                totalPlayerPoints.putIfAbsent(player.getKey(), 0);
                int currentPoints = totalPlayerPoints.get(player.getKey());
                totalPlayerPoints.put(player.getKey(), points + currentPoints);
            }
        }
        Map<String, Integer> sortPlayersByPoints = totalPlayerPoints.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> player : sortPlayersByPoints.entrySet()) {
            System.out.println(player.getKey() + ": " + player.getValue() + " skill");
            for (Map.Entry<String, Map<String, Integer>> entry : playersMap.entrySet()) {
                Map<String, Integer> sortByPoints = entry.getValue().entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                                , (e1, e2) -> e1, LinkedHashMap::new));
                if (player.getKey().equals(entry.getKey())) {
                    for (Map.Entry<String, Integer> position : sortByPoints.entrySet()) {
                        System.out.printf("- %s <::> %d%n", position.getKey(), position.getValue());

                    }
                }
            }
        }

    }

    public static int getPlayerPoints(Map<String, Map<String, Integer>> playerPoints, String player) {
        int points = 0;
        for (Map.Entry<String, Integer> entry : playerPoints.get(player).entrySet()) {
            points += entry.getValue();
        }

        return points;
    }

}
