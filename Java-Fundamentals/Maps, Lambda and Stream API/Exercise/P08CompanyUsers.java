import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> users = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String employee = input.split(" -> ")[1];

            users.putIfAbsent(company, new ArrayList<>());
            boolean isEmployeeFound = false;

            for (Object id : users.get(company)) {
                if (employee.equals(id)) {
                    isEmployeeFound = true;
                    break;
                }
            }

            if (!isEmployeeFound) {
                users.get(company).add(employee);
            }

            input = scanner.nextLine();
        }

        for (String key : users.keySet()) {
            System.out.println(key);
            for (Object value : users.get(key)) {
                System.out.printf("-- %s%n", value);
            }
        }


    }
}
