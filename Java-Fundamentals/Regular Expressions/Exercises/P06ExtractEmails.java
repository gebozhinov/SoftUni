import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "[A-Za-z\\d]+[._-]?[A-Za-z\\d]+@[A-Za-z]+-?[A-Za-z]+(\\.[A-Za-z]+)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> emailList = new ArrayList<>();
        while (matcher.find()) {
            String email = matcher.group();
            emailList.add(email);
        }

        emailList.forEach(System.out::println);

    }
}
