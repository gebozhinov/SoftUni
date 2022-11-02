import java.util.*;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentsMap.putIfAbsent(studentName, new ArrayList<>());
            studentsMap.get(studentName).add(grade);


        }
        for (Map.Entry<String, List<Double>> studentsGrade : studentsMap.entrySet()) {
            double sum = 0;
            for (int i = 0; i < studentsGrade.getValue().size(); i++) {
                sum += studentsGrade.getValue().get(i);
            }
            sum = sum / studentsGrade.getValue().size();
            studentsGrade.getValue().add(sum);
            studentsGrade.getValue().subList(0, studentsGrade.getValue().size() - 1).clear();


        }

        studentsMap.entrySet().removeIf(entry -> entry.getValue().get(0) < 4.5);
        studentsMap.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value.get(0)));
    }
}
