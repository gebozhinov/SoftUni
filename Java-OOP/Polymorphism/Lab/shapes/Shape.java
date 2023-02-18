package polymorphism.lab.shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();
}
