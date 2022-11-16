import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> phoneList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input.split(" - ")[0];
            String phone = input.split(" - ")[1];
            switch (command) {
                case "Add":
                    if (!isPhoneExist(phoneList, phone)) {
                        phoneList.add(phone);
                    }
                    break;
                case "Remove":
                    if (isPhoneExist(phoneList, phone)) {
                        phoneList.remove(phone);
                    }
                    break;
                case "Bonus phone":
                    String oldPhone = phone.split(":")[0];
                    String newPhone = phone.split(":")[1];
                    if (isPhoneExist(phoneList, oldPhone)) {
                        int index = phoneList.indexOf(oldPhone);
                        phoneList.add(index + 1, newPhone);
                    }
                    break;
                case "Last":
                    if (isPhoneExist(phoneList, phone)) {
                        phoneList.remove(phone);
                        phoneList.add(phone);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", phoneList));

    }

    public static boolean isPhoneExist(List<String> phoneList, String phone) {
        for (String currentPhone : phoneList) {
            if (currentPhone.equals(phone)) {
                return true;
            }
        }
        return false;
    }
}
