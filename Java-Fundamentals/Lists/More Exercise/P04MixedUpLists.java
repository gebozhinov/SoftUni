import java.util.*;
import java.util.stream.Collectors;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> fistList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int range = Math.min(fistList.size(), secondList.size());
        List<Integer> mergeList = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            mergeList.add(fistList.get(i));
            mergeList.add(secondList.get(secondList.size() - 1 - i));
        }

        int firstNumber;
        int secondNumber;
        if (fistList.size() > secondList.size()) {
            firstNumber = fistList.get(fistList.size() - 2);
            secondNumber = fistList.get(fistList.size() - 1);
        } else {
            firstNumber = secondList.get(0);
            secondNumber = secondList.get(1);
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (Integer integer : mergeList) {
            if (integer < firstNumber && secondNumber < integer) {
                resultList.add(integer);
            } else if (integer > firstNumber && secondNumber > integer) {
                resultList.add(integer);
            }
        }
        Collections.sort(resultList);
        System.out.print(Arrays.toString(resultList.toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
        
    }
}
