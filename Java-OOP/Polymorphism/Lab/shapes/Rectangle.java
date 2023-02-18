package polymorphism.lab.shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);
        calculateArea();
        calculatePerimeter();
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.height * 2 + this.width * 2);
    }

    @Override
    protected void calculateArea() {
        setArea(this.height *  this.width);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
