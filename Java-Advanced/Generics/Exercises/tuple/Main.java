package generics.exercises.tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String name = input.split(" ")[0] + " " + input.split(" ")[1];
        String address = input.split(" ")[2];
        Tuple<String, String> personInfo = new Tuple<>(name, address);
        System.out.println(personInfo);

        input = scanner.nextLine();
        String name2 = input.split(" ")[0];
        int beer = Integer.parseInt(input.split(" ")[1]);
        Tuple<String, Integer> beerDrink = new Tuple<>(name2, beer);
        System.out.println(beerDrink);

        input = scanner.nextLine();
        int intNum = Integer.parseInt(input.split(" ")[0]);
        double doubleNum = Double.parseDouble(input.split(" ")[1]);
        Tuple<Integer, Double> integerDoubleTuple = new Tuple<>(intNum, doubleNum);
        System.out.println(integerDoubleTuple);

    }
}
