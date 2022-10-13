import java.util.Arrays;
import java.util.Scanner;

public class P05KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        int[] bestDNA = new int[n];
        int mostSubsequence = 0;
        int getFirstSubsequenceIndex = bestDNA.length;
        int mostSumElements = 0;
        int bestInput = 0;
        int totalInput = 0;
        String input = scanner.nextLine();
        while (!input.equals("Clone them!")) {
            int[] dna = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt).toArray();
            totalInput++;

            int subsequence = getLongestSubsequenceOfOnes(dna);
            int firstSubsequenceIndex = getFirstSubsequenceIndex(dna);
            int sumElements = getSumOfSubsequenceElements(dna);

            if (subsequence > mostSubsequence) {
                mostSubsequence = subsequence;
                getFirstSubsequenceIndex = firstSubsequenceIndex;
                mostSumElements = sumElements;
                getBestDNA(dna, bestDNA);
                bestInput = totalInput;
            } else if (subsequence == mostSubsequence && firstSubsequenceIndex < getFirstSubsequenceIndex) {
                getFirstSubsequenceIndex = firstSubsequenceIndex;
                mostSumElements = sumElements;
                getBestDNA(dna, bestDNA);
                bestInput = totalInput;
            } else if (subsequence == mostSubsequence && firstSubsequenceIndex == getFirstSubsequenceIndex
                    && sumElements > mostSumElements) {
                mostSumElements = sumElements;
                getBestDNA(dna, bestDNA);
                bestInput = totalInput;
            }

            input = scanner.nextLine();
        }
        if (mostSubsequence == 0) {
            bestInput = 1;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestInput, mostSumElements);
        printBestDna(bestDNA);

    }

    public static int[] getBestDNA(int[] dna, int[] bestDNA) {
        System.arraycopy(dna, 0, bestDNA, 0, dna.length);
        return bestDNA;
    }

    public static int getLongestSubsequenceOfOnes(int[] dnaArray) {
        int countSubsequence = 0;
        for (int i = 0; i < dnaArray.length - 1; i++) {
            if (dnaArray[i] == 1 && dnaArray[i + 1] == 1) {
                countSubsequence++;
            }
        }
        return countSubsequence;
    }
  public static int getFirstSubsequenceIndex(int[] dnaArray) {
        int getFirstSubsequenceIndex = dnaArray.length;
        for (int i = 0; i < dnaArray.length - 1; i++) {
            if (dnaArray[i] == 1 && dnaArray[i + 1] == 1) {
                if (i < getFirstSubsequenceIndex) {
                    getFirstSubsequenceIndex = i;
                }
            }
        }
        return getFirstSubsequenceIndex;
    }

    public static int getSumOfSubsequenceElements(int[] dnaArray) {
        int sum = 0;
        for (int dna : dnaArray) {
            sum += dna;
        }
        return sum;
    }

    public static void printBestDna(int[] bestDNA) {
        System.out.print(Arrays.toString(bestDNA).replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
