
public class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double s, double x) {
        super("Rectangle");
        this.length = s;
        this.width = x;
    }

    public double area() {
        return length * width;
    }

}
