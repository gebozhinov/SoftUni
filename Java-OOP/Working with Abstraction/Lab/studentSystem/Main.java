package workingWithAbstraction.lab.studentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StudentSystem studentSystem = new StudentSystem();

        label:
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "Exit":
                    break label;
                case "Create":
                    studentSystem.createStudent(input);
                    break;
                case "Show":
                    studentSystem.showStudent(input);
                    break;
            }

        }
    }
}
