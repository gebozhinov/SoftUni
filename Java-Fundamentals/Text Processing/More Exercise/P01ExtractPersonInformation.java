import java.util.Scanner;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            StringBuilder name = new StringBuilder();
            StringBuilder age = new StringBuilder();
            int nameStartIndex = 0;
            int nameEndIndex = 0;
            int ageStartIndex = 0;
            int ageEndIndex = 0;
            for (int j = 0; j < input.length(); j++) {
                char symbol = input.charAt(j);
                if (symbol == '@') {
                    nameStartIndex = j + 1;
                } else if (symbol == '|') {
                    nameEndIndex = j;
                } else if (symbol == '#') {
                    ageStartIndex = j + 1;
                } else if (symbol == '*') {
                    ageEndIndex = j;
                }
            }
            String getName = input.substring(nameStartIndex, nameEndIndex);
            String getAge = input.substring(ageStartIndex, ageEndIndex);

            name.append(getName);
            age.append(getAge);

            System.out.printf("%s is %s years old.%n", name, age);

        }


    }
}
