package club.banyuan.July6.Practice;

import java.util.Scanner;

public class MyThread extends Thread {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            try {
                for (char aChar : chars) {
                    System.out.println(aChar);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
    }
}

