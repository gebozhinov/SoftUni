import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<PersonData> personDataList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            if (age > 30) {
                PersonData person = new PersonData(name, age);
                personDataList.add(person);
            }
        }
        for (PersonData person : personDataList) {
            System.out.println(person.getName() + " - " + person.getAge());
        }

    }
}
