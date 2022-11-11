import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        int explosion = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '>') {
                int strength = Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                explosion += strength;
            } else if (input.charAt(i) != '>' && explosion != 0) {
                input.deleteCharAt(i);
                explosion--;
                i--;
            }
        }


        System.out.println(input);

    }
}
