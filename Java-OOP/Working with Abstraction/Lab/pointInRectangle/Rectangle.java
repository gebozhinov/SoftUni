package workingWithAbstraction.lab.pointInRectangle;

public class Rectangle {
    private int bottomLeftX;
    private int bottomLeftY;
    private int topRightX;
    private int topRightY;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRightX;
        this.topRightY = topRightY;
    }

    public boolean contains(Point point) {
        return point.getCoordinateX() >= bottomLeftX && point.getCoordinateX() <= topRightX
                && point.getCoordinateY() >= bottomLeftY && point.getCoordinateY() <= topRightY;
    }

}
