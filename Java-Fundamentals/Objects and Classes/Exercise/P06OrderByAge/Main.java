import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<PersonInfo> personInfoList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String name = input.split(" ")[0];
            String id = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);
            PersonInfo personInfo = new PersonInfo(name, id, age);
            personInfoList.add(personInfo);


            input = scanner.nextLine();
        }
        personInfoList.sort(Comparator.comparing(PersonInfo::getAge));
        for (PersonInfo personInfo : personInfoList) {
            System.out.println(personInfo);
        }

    }
}
