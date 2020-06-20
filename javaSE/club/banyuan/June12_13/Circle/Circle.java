package club.banyuan.June12_13.Circle;

public class Circle {

    private double r;

    public  Circle(double r) {
        this.r = r;
    }

    public Circle(Circle circle) {
        r = circle.r;
    }

    public void setRadius(double r) {
        this.r = r;
    }
    public double calPerimeter() {
        return 2 * Math.PI * r;
    }

    public  double calArea() {
        return Math.PI * r * r;
    }
    public double getR() {
        return r;
    }
}
