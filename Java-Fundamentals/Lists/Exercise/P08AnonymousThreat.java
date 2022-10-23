import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("3:1")) {
            String command = inputLine.split(" ")[0];
            if (command.equals("merge")) {
                int startIndex = Integer.parseInt(inputLine.split(" ")[1]);
                int endIndex = Integer.parseInt(inputLine.split(" ")[2]);

                int minIndex = startIndex;
                if (inputList.size() - 1 < startIndex || startIndex < 0) {
                    minIndex = 0;
                }
                int maxIndex = Math.min(inputList.size() - 1, endIndex);

                String merge = "";
                for (int i = minIndex; i <= maxIndex; i++) {
                    merge += inputList.get(i);
                }

                inputList.set(minIndex, merge);
                if (maxIndex >= minIndex + 1) {
                    inputList.subList(minIndex + 1, maxIndex + 1).clear();
                }


            } else {

                int index = Integer.parseInt(inputLine.split(" ")[1]);
                int partitions = Integer.parseInt(inputLine.split(" ")[2]);
                String getText = inputList.get(index);
                List<String> result = new ArrayList<>();
                int substringCount = inputList.get(index).length() / partitions;
                int count = 0;
                if (getText.length() % partitions == 0) {
                    for (int i = 0; i < partitions; i++) {
                        String concatenate = "";
                        for (int j = 0; j < substringCount; j++) {
                            char symbol = getText.charAt(count);
                            concatenate += symbol;
                            count++;
                        }
                        result.add(concatenate);
                    }

                } else {
                    for (int i = 0; i < partitions; i++) {
                        String concatenate = "";
                        if (i == partitions - 1) {
                            for (int j = count; j < getText.length(); j++) {
                                char symbol = getText.charAt(count);
                                concatenate += symbol;
                                count++;
                            }
                        } else {
                            for (int j = 0; j < substringCount; j++) {
                                char symbol = getText.charAt(count);
                                concatenate += symbol;
                                count++;
                            }
                        }
                        result.add(concatenate);
                    }
                }
                inputList.remove(index);
                inputList.addAll(index, result);
            }


            inputLine = scanner.nextLine();
        }
        System.out.print(Arrays.toString(inputList.toArray())
                .replace("]", "")
                .replace("[", "")
                .replace(",", ""));
    }

}
