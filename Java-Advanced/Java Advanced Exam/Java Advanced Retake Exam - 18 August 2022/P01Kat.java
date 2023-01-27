package exam.august2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Kat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] license = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> licenseQueue = new ArrayDeque<>();
        for (int n : license) {
            licenseQueue.offer(n);
        }

        int[] cars = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> carStack = new ArrayDeque<>();
        for (int n : cars) {
            carStack.push(n);
        }

        int neededDays = 0;
        int registeredCars = 0;
        while (!licenseQueue.isEmpty() && !carStack.isEmpty()) {
            neededDays++;
            int licensePlate = licenseQueue.poll();
            int currentCars = carStack.pop();
            if (currentCars * 2 < licensePlate) {
                licenseQueue.offer(licensePlate - currentCars * 2);
                registeredCars += currentCars;
            } else if (currentCars * 2 > licensePlate) {
                carStack.offer(currentCars - (licensePlate / 2));
                registeredCars += licensePlate / 2;
            } else {
                registeredCars += currentCars;
            }

        }


        System.out.printf("%d cars were registered for %d days!%n", registeredCars, neededDays);
        if (carStack.isEmpty() && licenseQueue.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (!carStack.isEmpty()) {
            int carsWithoutLicense = carStack.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%d cars remain without license plates!%n", carsWithoutLicense);
        } else {
            int licensePlates = licenseQueue.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%d license plates remain!%n", licensePlates);
        }
    }
}
