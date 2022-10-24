import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> encryptedMessage = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < encryptedMessage.size(); i++) {
            char asciiValue = encryptedMessage.get(i).charAt(0);
            if (asciiValue >= 48 && asciiValue <= 57) {
                numberList.add(Integer.parseInt(encryptedMessage.get(i)));
                encryptedMessage.remove(i);
                i--;
            }
        }
        List<Integer> takeList = oddOrEvenNumbers(numberList, "take");
        List<Integer> skipList = oddOrEvenNumbers(numberList, "skip");

        List<String> resultList = new ArrayList<>();
        int takeCount = 0;
        int skipCount = 0;
        for (int i = 0; i < numberList.size() / 2; i++) {
            for (int j = 0; j < takeList.get(i); j++) {
                if (takeCount + skipCount > encryptedMessage.size() - 1) {
                    break;
                }
                resultList.add(encryptedMessage.get(takeCount + skipCount));
                takeCount++;
            }
            for (int j = 0; j < skipList.get(i); j++) {
                skipCount++;
            }
        }


        for (String word : resultList) {
            System.out.print(word + "");
        }
    }
    public static List<Integer> oddOrEvenNumbers (List<Integer> numberList, String listType){
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numberList.get(i));
            } else {
                skipList.add(numberList.get(i));
            }
        }
        if (listType.equals("take")) {
            return takeList;
        } else {
            return skipList;
        }
    }
}
