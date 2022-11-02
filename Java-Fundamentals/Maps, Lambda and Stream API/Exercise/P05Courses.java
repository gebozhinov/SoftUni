import java.util.*;

public class P05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> result = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String course = input.split(" : ")[0];
            String student = input.split(" : ")[1];
            result.putIfAbsent(course, new ArrayList<>());
            result.get(course).add(student);


            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> course : result.entrySet()) {
            System.out.printf("%s: %d%n", course.getKey(), course.getValue().size());
            for (int i = 0; i < course.getValue().size(); i++) {
                System.out.printf("-- %s%n", course.getValue().get(i));

            }
        }


    }
}
