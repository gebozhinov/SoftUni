import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceOfLightSaber = Double.parseDouble(scanner.nextLine());
        double priceOfRobe = Double.parseDouble(scanner.nextLine());
        double priceOfBelt = Double.parseDouble(scanner.nextLine());

        double lightSabersTotalPrice = Math.ceil(countOfStudents * 1.1) * priceOfLightSaber;
        double robeTotalPrice = countOfStudents * priceOfRobe;
        double beltTotalPrice = (countOfStudents - Math.floor(countOfStudents / 6.0)) * priceOfBelt;

        double totalPrice = lightSabersTotalPrice + robeTotalPrice + beltTotalPrice;
        if (amountOfMoney >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - amountOfMoney);
        }
    }
}
