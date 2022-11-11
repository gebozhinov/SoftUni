import java.util.Scanner;

public class P05HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String title = scanner.nextLine();
        String content = scanner.nextLine();

        System.out.println("<h1>");
        System.out.println("    " + title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println("    " + content);
        System.out.println("</article>");

        String comment = scanner.nextLine();
        while (!comment.equals("end of comments")) {
            System.out.println("<div>");
            System.out.println("    " + comment);
            System.out.println("</div>");

            comment = scanner.nextLine();
        }


    }
}
