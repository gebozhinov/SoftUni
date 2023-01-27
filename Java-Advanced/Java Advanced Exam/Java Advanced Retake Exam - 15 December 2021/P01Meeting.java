package exam.december2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] males = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        for (int m : males) {
            malesStack.push(m);
        }

        int[] females = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        for (int f : females) {
            femalesQueue.offer(f);
        }

        int matchesCount = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int lastMen = malesStack.peek();
            int firstWomen = femalesQueue.peek();

            if (lastMen <= 0) {
                malesStack.pop();
                continue;
            } else if (lastMen % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }
            if (firstWomen <= 0) {
                femalesQueue.poll();
                continue;
            } else if (firstWomen % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            malesStack.pop();
            femalesQueue.poll();
            if (lastMen != firstWomen) {
                lastMen -= 2;
                malesStack.push(lastMen);
            } else {
                matchesCount++;
            }
        }

        System.out.printf("Matches: %d%n", matchesCount);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            malesStack.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.printf("Males left: %s%n", sb);
        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            femalesQueue.forEach(e -> sb.append(e).append(", "));
            sb.replace(sb.length() - 2, sb.length(), "");
            System.out.printf("Females left: %s%n", sb);
        }
    }
}
