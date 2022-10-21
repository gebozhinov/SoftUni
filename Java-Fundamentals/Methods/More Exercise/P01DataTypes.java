import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String dataType = scanner.nextLine();
        String data = scanner.nextLine();

        if (dataType.equals("int")) {
            int dataTypeInt = Integer.parseInt(data);
            System.out.println(multiplyBy2(dataTypeInt));
        } else if (dataType.equals("real")) {
            double dataTypeDouble = Double.parseDouble(data);
            System.out.printf("%.2f", multiplyBy1AndAHalf(dataTypeDouble));
        } else {
            System.out.println(addDollarSign(data));
        }


    }

    public static int multiplyBy2(int number) {
        return number * 2;
    }

    public static double multiplyBy1AndAHalf(double number) {
        return number * 1.5;
    }

    public static String addDollarSign(String text) {
        return "$" + text + "$";
    }
}
