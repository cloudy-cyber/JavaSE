package club.banyuan.July6.src.club.banyuan;

public class ReverseHelloMultithreaded extends Thread {
    private int num;

    public ReverseHelloMultithreaded(int num) {
        this.num = num;
    }

    public static void doReverseHello() throws InterruptedException {
        ReverseHelloMultithreaded thred = new ReverseHelloMultithreaded(1);
        thred.start();
    }

    @Override
    public void run() {
        if (num < 50) {
            ReverseHelloMultithreaded thread = new ReverseHelloMultithreaded(num + 1);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello from thread " + num);
    }

    public static void main(String[] args) throws InterruptedException {
        ReverseHelloMultithreaded.doReverseHello();
    }
}
