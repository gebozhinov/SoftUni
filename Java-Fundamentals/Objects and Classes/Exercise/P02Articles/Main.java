import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String articleData = scanner.nextLine();
        String title = articleData.split(", ")[0];
        String content = articleData.split(", ")[1];
        String author = articleData.split(", ")[2];

        Articles article = new Articles(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String getCommand = command.split("\\: ")[0];
            String newValue = command.split("\\: ")[1];
            switch (getCommand) {
                case "Edit":
                    article.edit(newValue);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(newValue);
                    break;
                case "Rename":
                    article.rename(newValue);
                    break;
            }
        }
        System.out.println(article);

    }
}
