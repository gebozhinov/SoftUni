import javax.sql.rowset.serial.SerialStruct;
import java.util.Arrays;
import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int wagonCount = Integer.parseInt(scanner.nextLine());
        int[] peoplePerWagon = new int[wagonCount];
        int sum = 0;
        for (int i = 0; i < wagonCount; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            peoplePerWagon[i] = people;
            sum += peoplePerWagon[i];
        }
        System.out.print(Arrays.toString(peoplePerWagon)
                .replace("[", "")
                .replace(",", "")
                .replace("]", "")
                .trim());
        System.out.println();
        System.out.println(sum);

    }
}
