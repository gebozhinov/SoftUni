import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        int rightLeftSlash;
        int middleSlash;
        if (n % 2 == 0) {
            rightLeftSlash = (n - 2) / 2;
            middleSlash = 2;
        } else {
            rightLeftSlash = (n - 1) / 2;
            middleSlash = 1;
        }
        for (int i = 0; i < Math.ceil(n / 2.0); i++) {
            if (i == 0 && n % 2 == 0) {
                System.out.print(repeatString("-", rightLeftSlash));
                System.out.print("**");
                System.out.println(repeatString("-", rightLeftSlash));
            } else if (i == 0 && n % 2 == 1) {
                System.out.print(repeatString("-", rightLeftSlash));
                System.out.print("*");
                System.out.println(repeatString("-", rightLeftSlash));
            } else {
                System.out.print(repeatString("-", rightLeftSlash));
                System.out.print("*");
                System.out.print(repeatString("-", middleSlash));
                System.out.print("*");
                System.out.println(repeatString("-", rightLeftSlash));
                middleSlash += 2;
            }
            rightLeftSlash--;
        }
        rightLeftSlash++;
        middleSlash -= 2;
        for (int i = 0; i < Math.ceil(n / 2.0) - 1; i++) {
            rightLeftSlash++;
            middleSlash -= 2;
            if (i + 1 == Math.ceil(n / 2.0) - 1 && n % 2 == 0) {
                System.out.print(repeatString("-", rightLeftSlash));
                System.out.print("**");
                System.out.println(repeatString("-", rightLeftSlash));
            } else if (i + 1 == Math.ceil(n / 2.0) - 1 && n % 2 == 1) {
                System.out.print(repeatString("-", rightLeftSlash));
                System.out.print("*");
                System.out.println(repeatString("-", rightLeftSlash));
            } else {
                System.out.print(repeatString("-", rightLeftSlash));
                System.out.print("*");
                System.out.print(repeatString("-", middleSlash));
                System.out.print("*");
                System.out.println(repeatString("-", rightLeftSlash));
            }
        }

    }

    static String repeatString(String stringToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += stringToRepeat;
        }
        return text;
    }
}
