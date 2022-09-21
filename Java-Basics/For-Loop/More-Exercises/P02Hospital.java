import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());
        int doctors = 7;
        int treatedPatients = 0;
        int untTreatedPatients = 0;
        for (int i = 1; i <= period; i++) {
            if (i % 3 == 0) {
                if (untTreatedPatients > treatedPatients) {
                    doctors += 1;
                }
            }
            int patients = Integer.parseInt(scanner.nextLine());
            if (patients <= doctors) {
                treatedPatients += patients;
            } else {
                treatedPatients += doctors;
                untTreatedPatients += patients - doctors;
            }
        }
        System.out.printf("Treated patients: %d.%n", treatedPatients);
        System.out.printf("Untreated patients: %d.", untTreatedPatients);
    }
}
