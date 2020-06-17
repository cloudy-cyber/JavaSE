import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {


        System.out.println("猜数字游戏开始");
        System.out.println("请输入一个四位数：");
        //生成一个四位随机数：
        int ranNumber = (int) (Math.random() * 9000) + 1000;
        Scanner sc = new Scanner(System.in);
        while (true) {
            int number = sc.nextInt();
            if (number > ranNumber) {
                System.out.println("猜大了");
            } else if (number < ranNumber) {
                System.out.println("猜小了");
            } else {
                System.out.println("恭喜猜对了！");
                break;
            }
        }
    }

}


