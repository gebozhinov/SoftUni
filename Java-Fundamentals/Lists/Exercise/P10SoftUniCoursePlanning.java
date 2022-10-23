import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> lessonsList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("course start")) {
            List<String> getCommand = Arrays.stream(command.split(":"))
                    .collect(Collectors.toList());
            switch (getCommand.get(0)) {
                case "Add":
                    if (!lessonsList.contains(getCommand.get(1))) {
                        lessonsList.add(getCommand.get(1));
                    }
                    break;
                case "Insert":
                    int insertAtIndex = Integer.parseInt(getCommand.get(2));
                    if (!lessonsList.contains(getCommand.get(1))) {
                        lessonsList.add(insertAtIndex, getCommand.get(1));
                    }
                    break;
                case "Remove":
                    lessonsList.remove(getCommand.get(1));
                    lessonsList.remove(getCommand.get(1) + "-Exercise");

                    break;
                case "Swap":
                    if (lessonsList.contains(getCommand.get(1)) && lessonsList.contains(getCommand.get(2))) {
                        int firstIndex = indexOfTheLesson(lessonsList, getCommand.get(1));
                        int secondIndex = indexOfTheLesson(lessonsList, getCommand.get(2));
                        Collections.swap(lessonsList, firstIndex, secondIndex);
                        if (lessonsList.contains(getCommand.get(1) + "-Exercise")) {
                            lessonsList.add(secondIndex + 1, getCommand.get(1) + "-Exercise");
                            lessonsList.remove(firstIndex + 1);
                        }
                        if (lessonsList.contains(getCommand.get(2) + "-Exercise")) {
                            lessonsList.add(firstIndex + 1, getCommand.get(2) + "-Exercise");
                            lessonsList.remove(secondIndex + 2);
                        }
                    }

                    break;
                case "Exercise":
                    if (!lessonsList.contains(getCommand.get(1))) {
                        lessonsList.add(getCommand.get(1));
                        lessonsList.add(getCommand.get(1) + "-Exercise");
                    } else if (!lessonsList.contains(getCommand.get(1) + "-Exercise")) {
                        int index = indexOfTheLesson(lessonsList, getCommand.get(1));
                        lessonsList.add(index + 1, getCommand.get(1) + "-Exercise");
                    }

                    break;
            }


            command = scanner.nextLine();
        }
        for (int i = 0; i < lessonsList.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, lessonsList.get(i));
        }

    }

    public static int indexOfTheLesson(List<String> lessonsList, String lesson) {
        int index = 0;
        for (int i = 0; i < lessonsList.size(); i++) {
            if (lessonsList.get(i).equals(lesson)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
