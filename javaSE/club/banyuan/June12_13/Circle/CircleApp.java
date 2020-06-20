package club.banyuan.June12_13.Circle;

public class CircleApp {

    public static void main(String[] args) {
        double rd = 12.3;
        Circle circle1 = new Circle(rd);
        System.out.println("circle1");
        System.out.println("半径 = " + rd);
        System.out.println("周长：" + circle1.calPerimeter());
        System.out.println("面积：" + circle1.calArea());

        // 创建一个circle2 对象，将circle1对象作为构造方法参数传入，显示其周长和半径

        Circle circle2 = new Circle(circle1);
        System.out.println("circle2");
        System.out.println("半径=" + circle2.getR());
        System.out.println("周长=" + circle2.calPerimeter());

        // 使用setRadius 修改circle1 的半径。是否会同时修改circle2的半径？ 验证答案
        circle1.setRadius(18.8);
        System.out.println("circle1的半径=" + circle1.getR());
        System.out.println("circle2的半径=" + circle2.getR());
        //不会改变circle2的半径


        //声明 `Circle circle3 = circle2`，当修改circle2的半径之后，circle3的周长和面积是否发生变化。

        Circle circle3 = circle2;
        System.out.println("circle3的周长=" + circle3.calPerimeter());
        System.out.println("circle3的面积=" + circle3.calArea());
        circle2.setRadius(25.5);
        System.out.println("修改后circle3的周长=" + circle3.calPerimeter());
        System.out.println("修改后circle3的面积=" + circle3.calArea());
        //circle3的周长和面积发生了变化

        // circle3的值是否为null

        circle2 = null;
        if (circle3 == null) {
            System.out.println("circle3的值为null");
        } else {
            System.out.println("circle3的值不为null");
        }
    }

}
