package definingClasses.lab;

import java.util.Scanner;

public class P02Constructors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String brand = input[0];
            Car car;
            if (input.length == 1) {
                car = new Car(brand);
            } else {
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);
                car = new Car(brand, model, horsePower);
            }
            System.out.println(car.getInfo());
        }


    }
}
