package setsAndMapsAdvanced.exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> usersMap = new TreeMap<>();
        while (!input.equals("end")) {
            String address = input.split("IP=")[1].split(" ")[0];
            String user = input.split("=")[3];
            usersMap.putIfAbsent(user, new LinkedHashMap<>());
            usersMap.get(user).putIfAbsent(address, 0);
            usersMap.get(user).put(address, usersMap.get(user).get(address) + 1);
            input = scanner.nextLine();
        }

        for (var user : usersMap.entrySet()) {
            System.out.println(user.getKey() + ": ");
            StringBuilder sb = new StringBuilder();
            for (var address : user.getValue().entrySet()) {
                String format = String.format("%s => %d, ", address.getKey(), address.getValue());
                sb.append(format);
            }
            String output = sb.substring(0, sb.length() - 2);
            output = output + ".";
            System.out.println(output);
        }
    }
}
