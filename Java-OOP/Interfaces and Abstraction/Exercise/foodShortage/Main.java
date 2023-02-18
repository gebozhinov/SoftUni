package interfacesAndAbstraction.exercises.foodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Buyer> buyerMap = new HashMap<>();
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            switch (tokens.length) {
                case 4:
                    String id = tokens[2];
                    String birthdate = tokens[3];
                    Citizen citizen = new Citizen(name, age, id, birthdate);
                    buyerMap.put(name, citizen);
                    break;
                case 3:
                    String group = tokens[2];
                    Rebel rebel = new Rebel(name, age, group);
                    buyerMap.put(name, rebel);
                    break;
            }
        }

        String name = scanner.nextLine();
        while (!"End".equals(name)) {
            if (buyerMap.containsKey(name)) {
                buyerMap.get(name).buyFood();
            }
            name = scanner.nextLine();
        }

        int sum = buyerMap.values().stream().map(Buyer::getFood).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

    }
}
