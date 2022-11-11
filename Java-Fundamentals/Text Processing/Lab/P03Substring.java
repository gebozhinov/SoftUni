import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String removeString = scanner.nextLine();
        String text = scanner.nextLine();
        while (text.contains(removeString)) {
            text = text.replace(removeString, "");

        }
        System.out.println(text);
    }
}
