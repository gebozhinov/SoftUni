package exam.june2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        for (int n : tasks) {
            tasksStack.push(n);
        }

        int[] threads = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                                .toArray();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        for (int n : threads) {
            threadsQueue.offer(n);
        }


        int valueOfTheTask = Integer.parseInt(scanner.nextLine());

        while (true) {
            int firstThread = threadsQueue.peek();
            int lastTask = tasksStack.peek();
            if (lastTask == valueOfTheTask) {
                System.out.printf("Thread with value %d killed task %d%n", firstThread, lastTask);
                break;
            }
            threadsQueue.poll();
            if (firstThread >= lastTask) {
                tasksStack.pop();
            }

        }
        threadsQueue.forEach(e -> System.out.print(e + " "));
    }
}
