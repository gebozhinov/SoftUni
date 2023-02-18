package workingWithAbstraction.exercise.trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(" ");

        List<TrafficLights> trafficLights = new ArrayList<>();
        for (String color : input) {
            TrafficLights currentLight = new TrafficLights(Color.valueOf(color));
            trafficLights.add(currentLight);
        }

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (TrafficLights currentLight : trafficLights) {
                currentLight.changeColor();
                System.out.print(currentLight.getColor() + " ");
            }
            System.out.println();
        }


    }
}
