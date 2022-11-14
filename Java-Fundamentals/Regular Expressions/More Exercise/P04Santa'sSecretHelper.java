import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> nameList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            StringBuilder decrypt = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                decrypt.append((char) (symbol - n));
            }
            String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*(?<behavior>!G!)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decrypt);
            while (matcher.find()) {
                String name = matcher.group("name");
                nameList.add(name);
            }
            input = scanner.nextLine();
        }

        nameList.forEach(System.out::println);
    }
}
