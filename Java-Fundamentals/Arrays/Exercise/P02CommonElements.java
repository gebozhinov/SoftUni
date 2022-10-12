import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ");


        for (String s : secondLine) {
            for (String value : firstLine) {
                if (s.equals(value)) {
                    System.out.print(s + " ");
                }
            }
        }
    }
}
