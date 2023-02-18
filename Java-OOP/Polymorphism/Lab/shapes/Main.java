package polymorphism.lab.shapes;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(3.0, 4.0);
        Circle circle = new Circle(4.0);

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

    }
}
