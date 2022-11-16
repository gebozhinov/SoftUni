import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int pieces = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, String>> collection = new LinkedHashMap<>();
        for (int i = 0; i < pieces; i++) {
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];

            collection.put(piece, new LinkedHashMap<>());
            collection.get(piece).put(composer, key);

        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String command = input.split("\\|")[0];
            switch (command) {
                case "Add":
                    String piece = input.split("\\|")[1];
                    String composer = input.split("\\|")[2];
                    String key = input.split("\\|")[3];
                    if (collection.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        collection.put(piece, new LinkedHashMap<>());
                        collection.get(piece).put(composer, key);
                        System.out.printf("%s by %s in %s added to the collection!%n"
                                , piece, composer, key);
                    }
                    break;
                case "Remove":
                    String removePiece = input.split("\\|")[1];
                    if (collection.containsKey(removePiece)) {
                        collection.remove(removePiece);
                        System.out.printf("Successfully removed %s!%n", removePiece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", removePiece);
                    }
                    break;
                case "ChangeKey":
                    String changePiece = input.split("\\|")[1];
                    String newKey = input.split("\\|")[2];
                    if (collection.containsKey(changePiece)) {
                        for (Map.Entry<String, String> entry : collection.get(changePiece).entrySet()) {
                            System.out.printf("Changed the key of %s to %s!%n", changePiece, newKey);
                            collection.get(changePiece).put(entry.getKey(), newKey);
                            break;
                        }
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", changePiece);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, String>> key : collection.entrySet()) {
            for (Map.Entry<String, String> value : collection.get(key.getKey()).entrySet()) {
                System.out.printf("%s -> Composer: %s, Key: %s%n"
                        , key.getKey(), value.getKey(), value.getValue());
            }
        }
    }
}
