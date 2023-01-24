package setsAndMapsAdvanced.exercises;

import java.util.*;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, Integer>> logs = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String address = input.split(" ")[0];
            String user = input.split(" ")[1];
            int duration = Integer.parseInt(input.split(" ")[2]);

            logs.putIfAbsent(user, new TreeMap<>());
            logs.get(user).putIfAbsent(address, 0);
            int currentDuration = logs.get(user).get(address);
            logs.get(user).put(address, duration + currentDuration);

        }
        for (var user : logs.entrySet()) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for (var address : user.getValue().entrySet()) {
                sum += address.getValue();
                sb.append(address.getKey()).append(", ");
            }
            String output = sb.substring(0, sb.length() - 2);
            System.out.printf("%s: %d [%s]%n", user.getKey(), sum, output);
        }

    }
}
