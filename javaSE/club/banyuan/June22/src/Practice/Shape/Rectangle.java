package Practice.Shape;

public class Rectangle extends Shape{
    private int x;
    private int y;


    @Override
    public String getShapeName() {
        return "矩形";
    }

    public Rectangle(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public double area() {
        return x*y;
    }

    @Override
    public double perimeter() {
        return (x+y)*2;
    }

}
