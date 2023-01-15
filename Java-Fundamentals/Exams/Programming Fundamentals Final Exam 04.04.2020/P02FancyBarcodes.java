package exam.finale.april2020;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            boolean isContained = false;
            String barcode = scanner.nextLine();
            String regex = "@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(barcode);
            while (matcher.find()) {
                isContained = true;
                String product = matcher.group("barcode");
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < product.length(); j++) {
                    char symbol = product.charAt(j);
                    if (Character.isDigit(symbol)) {
                        sb.append(symbol);
                    }
                }
                if (sb.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", sb);
                }
            }
            if (!isContained) {
                System.out.println("Invalid barcode");
            }
        }

    }
}
