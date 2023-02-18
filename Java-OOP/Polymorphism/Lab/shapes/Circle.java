package polymorphism.lab.shapes;

public class Circle extends Shape{

    private Double radius;

    public Circle(double radius) {
        setRadius(radius);
        calculatePerimeter();
        calculateArea();
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * radius * radius);
    }

    public final double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
