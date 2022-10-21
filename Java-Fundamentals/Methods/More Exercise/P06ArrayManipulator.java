import java.util.*;

public class P06ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] action = command.split(" ");
            if (action[0].equals("exchange")) {
                int exchangeIndex = Integer.parseInt(action[1]);
                if (exchangeIndex < 0 || exchangeIndex >= numbers.length) {
                    System.out.println("Invalid index");
                } else {
                    int[] leftNumbers = Arrays.copyOfRange(numbers, 0, exchangeIndex + 1);
                    int[] rightNumbers = Arrays.copyOfRange(numbers, exchangeIndex + 1, numbers.length);
                    System.arraycopy(rightNumbers, 0, numbers, 0, rightNumbers.length);
                    System.arraycopy(leftNumbers, 0, numbers, rightNumbers.length, leftNumbers.length);

                }
            } else if (action[0].equals("max")) {
                if (action[1].equals("even")) {
                    printMaxIndex(numbers, "even");
                } else {
                    printMaxIndex(numbers, "odd");
                }

            } else if (action[0].equals("min")) {
                if (action[1].equals("even")) {
                    printMinIndex(numbers, "even");
                } else {
                    printMinIndex(numbers, "odd");
                }
            } else if (action[0].equals("first")) {
                int countFirst = Integer.parseInt(action[1]);
                if (countFirst <= 0 || countFirst > numbers.length) {
                    System.out.println("Invalid count");
                } else {
                    if (action[2].equals("even")) {
                        printFirstCount(numbers, countFirst, "even");
                    } else {
                        printFirstCount(numbers, countFirst, "odd");
                    }
                }
            } else if (action[0].equals("last")) {
                int countLast = Integer.parseInt(action[1]);
                if (countLast <= 0 || countLast > numbers.length) {
                    System.out.println("Invalid count");
                } else {
                    if (action[2].equals("even")) {
                        printLastCount(numbers, countLast, "even");
                    } else {
                        printLastCount(numbers, countLast, "odd");
                    }
                }
            }


            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numbers));
    }

    public static void printMaxIndex(int[] numbers, String evenOrOdd) {
        int maxEvenIndex = Integer.MIN_VALUE;
        int maxOddIndex = Integer.MIN_VALUE;
        int maxEvenNum = Integer.MIN_VALUE;
        int maxOddNum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (maxEvenNum <= numbers[i]) {
                    maxEvenIndex = i;
                    maxEvenNum = numbers[i];
                }
            } else {
                if (maxOddNum <= numbers[i]) {
                    maxOddIndex = i;
                    maxOddNum = numbers[i];
                }
            }
        }

        if (evenOrOdd.equals("even") && maxEvenNum != Integer.MIN_VALUE) {
            System.out.println(maxEvenIndex);
        } else if (evenOrOdd.equals("odd") && maxOddNum != Integer.MIN_VALUE) {
            System.out.println(maxOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    public static void printMinIndex(int[] numbers, String evenOrOdd) {
        int minEvenIndex = Integer.MAX_VALUE;
        int minOddIndex = Integer.MAX_VALUE;
        int minEvenNum = Integer.MAX_VALUE;
        int minOddNum = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (minEvenNum >= numbers[i]) {
                    minEvenIndex = i;
                    minEvenNum = numbers[i];
                }
            } else {
                if (minOddNum >= numbers[i]) {
                    minOddIndex = i;
                    minOddNum = numbers[i];
                }
            }
        }
        if (evenOrOdd.equals("even") && minEvenNum != Integer.MAX_VALUE) {
            System.out.println(minEvenIndex);
        } else if (evenOrOdd.equals("odd") && minOddNum != Integer.MAX_VALUE) {
            System.out.println(minOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    public static void printFirstCount(int[] numbers, int count, String evenOrOdd) {
        List<Integer> firstEvenNumbers = new ArrayList<>();
        List<Integer> firstOddNumbers = new ArrayList<>();
        int countEvenNumbers = 0;
        int countOddNumbers = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                if (countEvenNumbers == count) {
                    break;
                }
                countEvenNumbers++;
                firstEvenNumbers.add(number);
            } else {
                if (countOddNumbers == count) {
                    break;
                }
                countOddNumbers++;
                firstOddNumbers.add(number);
            }
        }
        if (evenOrOdd.equals("even")) {
            System.out.println(firstEvenNumbers);
        } else {
            System.out.println(firstOddNumbers);
        }
    }

    public static void printLastCount(int[] numbers, int count, String evenOrOdd) {
        List<Integer> lastEvenNumbers = new ArrayList<>();
        List<Integer> lastOddNumbers = new ArrayList<>();
        int countEvenNumbers = 0;
        int countOddNumbers = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 == 0) {
                if (countEvenNumbers == count) {
                    break;
                }
                countEvenNumbers++;
                lastEvenNumbers.add(numbers[i]);
            } else {
                if (countOddNumbers == count) {
                    break;
                }
                countOddNumbers++;
                lastOddNumbers.add(numbers[i]);
            }
        }
        Collections.reverse(lastEvenNumbers);
        Collections.reverse(lastOddNumbers);
        if (evenOrOdd.equals("even")) {
            System.out.println(lastEvenNumbers);
        } else {
            System.out.println(lastOddNumbers);
        }
    }
}
