package interfacesAndAbstraction.exercises.collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();


        String[] items = scanner.nextLine().split(" ");
        int removeCount = Integer.parseInt(scanner.nextLine());


        printAddCollection(items, addCollection);
        printAddCollection(items, addRemoveCollection);
        printAddCollection(items, myList);

        printRemoveCollection(addRemoveCollection, removeCount);
        printRemoveCollection(myList, removeCount);

    }

    private static void printRemoveCollection(AddRemovable collection, int removeCount) {
        for (int i = 0; i < removeCount; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();

    }

    private static void printAddCollection(String[] items, Addable collection) {
        for (String item : items) {
            System.out.print(collection.add(item) + " ");
        }
        System.out.println();
    }
}
