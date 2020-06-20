package club.banyuan.June16;

import java.util.Scanner;

class GuessNumber{
    public static void main(String[] args) {
        System.out.println("猜数字游戏开始");
        System.out.println("请输入一个四位数");
        int ranNumber=(int)(Math.random()*9000)+1000;
        Scanner sc =new Scanner(System.in);
        while(true){
            int inputNumber=sc.nextInt();
            if(inputNumber>ranNumber){
                System.out.println("猜大了");
            }
            else if(inputNumber<ranNumber){
                System.out.println("猜小了");
            }else{
                System.out.println("猜对了");
                break;
            }
        }
    }
}



